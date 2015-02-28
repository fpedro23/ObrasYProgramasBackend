package DBManagement;

import modelObrasYProgramas.*;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ObrasAD {
    private Connection conexion;
    private CallableStatement callableStatement;
    private Statement statement;
    private List<Obra> listaBusqueda;

    private Obra obra;

    private ResultadoObra resultado;
    private List<ReporteDependencia> listaReporteDependencia;
    private List<ReporteEstado> listaReporteEstado;
    private List<ReporteGeneral> listaReporteGeneral;



    public ObrasAD() {
        try {
            conexion = DataSourceFactory.getMySQLDataSource().getConnection();

        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
        }

    }


    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws Exception {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json;
            json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    private Double getValorDolar() {
        try{
            JSONObject json = readJsonFromUrl("https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20(%22USDMXN%22)&format=json&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=");

            if(json==null){
                System.out.println("Error en web service");
                return 13.00;
            }
            else{
                JSONObject rate = json.getJSONObject("query").getJSONObject("results").getJSONObject("rate");
                return Double.parseDouble(rate.getString("Rate"));
            }
        }
        catch (Exception e){
            System.out.println("Error: "+e);
            return 13.00;
        }


    }


    public ResultadoObra buscar(Consulta consulta) {

        ResultSet tr = null;
        listaBusqueda = new ArrayList<Obra>();
        listaReporteDependencia = new ArrayList<ReporteDependencia>();
        listaReporteEstado = new ArrayList<ReporteEstado>();
        listaReporteGeneral = new ArrayList<ReporteGeneral>();


        try {

            if (consulta.getIdObra() != null) {
                callableStatement = conexion.prepareCall("{CALL buscarObrasID(?,?)}");
                callableStatement.setString("inIDObra", consulta.getIdObra());
                callableStatement.setDouble("inValorDolar",this.getValorDolar());

            } else if (consulta.getBusquedaRapida() != null) {
                callableStatement = conexion.prepareCall("{CALL busquedaRapidaObras(?,?,?,?)}");
                callableStatement.setString("inBusquedaRapida", consulta.getBusquedaRapida());
                callableStatement.setInt("inLimiteMin", consulta.getLimiteMin());
                callableStatement.setInt("inLimiteMax", consulta.getLimiteMax());
                callableStatement.setDouble("inValorDolar",this.getValorDolar());

            } else {

                callableStatement = conexion.prepareCall("{CALL buscarObras(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                callableStatement.setString("inTipoObra", consulta.getTipoDeObra());
                callableStatement.setString("inDependencia", consulta.getDependencia());
                callableStatement.setString("inEstado", consulta.getEstado());
                callableStatement.setString("inRangoInversionMin", consulta.getInversionMinima());
                callableStatement.setString("inRangoInversionMax", consulta.getInversionMaxima());
                callableStatement.setString("inFechaInicio", consulta.getFechaInicio());
                callableStatement.setString("inFechaInicioSegunda", consulta.getFechaInicioSegunda());
                callableStatement.setString("inFechaTermino", consulta.getFechaFin());
                callableStatement.setString("inFechaTerminoSegunda", consulta.getFechaFinSegunda());
                callableStatement.setString("inImpacto", consulta.getImpacto());
                callableStatement.setString("inCargoInaugura", consulta.getInaugurador());
                callableStatement.setString("inTipoInversion", consulta.getTipoDeInversion());
                callableStatement.setString("inTipoClasificacion", consulta.getClasificacion());
                callableStatement.setString("inSusceptible", consulta.getSusceptible());
                callableStatement.setString("inInaugurada", consulta.getInaugurada());
                callableStatement.setInt("inLimiteMin", consulta.getLimiteMin());
                callableStatement.setInt("inLimiteMax", consulta.getLimiteMax());
                callableStatement.setString("inDenominacion", consulta.getDenominacion());
                callableStatement.setString("inSubclasificacion",consulta.getSubclasificacion());
                callableStatement.setDouble("inValorDolar",this.getValorDolar());
            }

            boolean hasResults = callableStatement.execute();

            int i = 0;
            while (hasResults) {
                tr = callableStatement.getResultSet();
                if (i == 0) {
                    while (tr.next()) {
                        obra = new Obra(tr);
                        listaBusqueda.add(obra);

                    }

                }
                if (i == 1) {
                    while (tr.next()) {
                        ReporteDependencia reporteDependencia = new ReporteDependencia(tr);


                        listaReporteDependencia.add(reporteDependencia);
                    }
                }
                if (i == 2) {
                    while (tr.next()) {
                        ReporteEstado reporteEstado = new ReporteEstado(tr);
                        listaReporteEstado.add(reporteEstado);

                    }
                }
                if (i == 3) {
                    while (tr.next()) {
                        ReporteGeneral reporteGeneral = new ReporteGeneral(tr);
                        listaReporteGeneral.add(reporteGeneral);
                    }

                }


                System.out.println("Resultado número: " + i);

                hasResults = callableStatement.getMoreResults();
                i++;

            }

            conexion.close();


        } catch (SQLException sqle) {
            System.out.println(sqle);

        }catch (Exception ex) {
            System.out.println(ex);

        }

        resultado = new ResultadoObra();

        resultado.setListaObras(listaBusqueda);
        resultado.setListaReporteDependencia(listaReporteDependencia);
        resultado.setListaReporteEstado(listaReporteEstado);
        resultado.setListaReporteGeneral(listaReporteGeneral);


        return resultado;

    }

}
