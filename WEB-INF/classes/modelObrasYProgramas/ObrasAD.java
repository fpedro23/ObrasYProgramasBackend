package modelObrasYProgramas;

import com.oracle.javafx.jmx.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.nio.charset.Charset;


public class ObrasAD {
    private Connection conexion;
    private CallableStatement callableStatement;
    private Statement statement;
    private List<Obra> listaBusqueda;

    private Obra obra;

    private Dependencia dependencia;
    private List<Dependencia> listaDependencia;

    private Estado estado;
    private List<Estado> listaEstado;

    private Impacto impacto;
    private List<Impacto> listaImpacto;

    private Inaugurador inaugurador;
    private List<Inaugurador> listaInaugurador;


    private TipoClasificacion tipoClasificacion;
    private List<TipoClasificacion> listaTipoClasificacion;

    private TipoInversion tipoInversion;
    private List<TipoInversion> listaTipoInversion;

    private Subclasificacion subclasificacion;
    private List<Subclasificacion> listaSubclasificacion;

    private TipoObra tipoObra;
    private List<TipoObra> listaTipoObra;

    private ResultadoObra resultado;
    private List<ReporteDependencia> listaReporteDependencia;
    private List<ReporteEstado> listaReporteEstado;
    private List<ReporteGeneral> listaReporteGeneral;



    public ObrasAD() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //conexion= DriverManager.getConnection("jdbc:mysql://localhost/ObrasYProgramas?user=root");

            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/obrasyprogramas", "oypdbuser", "0ypProj3ct!");

            System.out.println("Conexion exitosa a la BD");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error: " + cnfe);
        } catch (InstantiationException ie) {
            System.out.println("Error: " + ie);
        } catch (IllegalAccessException iae) {
            System.out.println("Error: " + iae);
        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
        }


    }

    public List<Estado> listaDeEstados() {
        ResultSet tr = null;
        String select = "SELECT * FROM estados";
        listaEstado = new ArrayList<Estado>();


        try {
            statement = conexion.createStatement();
            tr = statement.executeQuery(select);


            while (tr.next()) {
                estado = new Estado();

                estado.setIdEstado(tr.getString("idEstado"));
                estado.setNombreEstado(tr.getString("nombreEstado"));
                estado.setLatitud(tr.getString("latitud"));
                estado.setLongitud(tr.getString("longitud"));

                listaEstado.add(estado);

            }

        } catch (SQLException sqle) {
            System.out.println(sqle);

        }

        return listaEstado;
    }


    public List<Dependencia> listaDeDependencias() {
        ResultSet tr = null;
        String select = "SELECT * FROM dependencias";
        listaDependencia = new ArrayList<Dependencia>();


        try {
            statement = conexion.createStatement();
            tr = statement.executeQuery(select);


            while (tr.next()) {
                dependencia = new Dependencia();

                dependencia.setIdDependencia(tr.getString("idDependencia"));
                dependencia.setNombreDependencia(tr.getString("nombreDependencia"));
                dependencia.setImagenDependencia(tr.getString("imagenDependencia"));

                listaDependencia.add(dependencia);

            }

        } catch (SQLException sqle) {
            System.out.println(sqle);

        }

        return listaDependencia;
    }


    public List<Impacto> listaDeImpactos() {
        ResultSet tr = null;
        String select = "SELECT * FROM impactos";
        listaImpacto = new ArrayList<Impacto>();


        try {
            statement = conexion.createStatement();
            tr = statement.executeQuery(select);


            while (tr.next()) {
                impacto = new Impacto();

                impacto.setIdImpacto(tr.getString("idImpacto"));
                impacto.setNombreImpacto(tr.getString("nombreImpacto"));

                listaImpacto.add(impacto);

            }

        } catch (SQLException sqle) {
            System.out.println(sqle);

        }

        return listaImpacto;
    }


    public List<Inaugurador> listaDeInauguradores() {

        ResultSet tr = null;
        String select = "SELECT * FROM cargo_inaugura";
        listaInaugurador = new ArrayList<Inaugurador>();


        try {
            statement = conexion.createStatement();
            tr = statement.executeQuery(select);


            while (tr.next()) {
                inaugurador = new Inaugurador();

                inaugurador.setIdCargoInaugura(tr.getString("idCargoInaugura"));
                inaugurador.setNombreCargoInaugura(tr.getString("nombreCargoInaugura"));

                listaInaugurador.add(inaugurador);

            }

        } catch (SQLException sqle) {
            System.out.println(sqle);

        }

        return listaInaugurador;

    }


    public List<TipoClasificacion> listaDeClasificaciones() {


        ResultSet tr = null;
        String select = "SELECT * FROM tipo_clasificacion";
        listaTipoClasificacion = new ArrayList<TipoClasificacion>();


        try {
            statement = conexion.createStatement();
            tr = statement.executeQuery(select);


            while (tr.next()) {
                tipoClasificacion = new TipoClasificacion();

                tipoClasificacion.setIdTipoClasificacion(tr.getString("idTipoClasificacion"));
                tipoClasificacion.setNombreTipoClasificacion(tr.getString("nombreTipoClasificacion"));

                listaTipoClasificacion.add(tipoClasificacion);

            }

        } catch (SQLException sqle) {
            System.out.println(sqle);

        }

        return listaTipoClasificacion;


    }

    public List<TipoInversion> listaDeInversiones() {


        ResultSet tr = null;
        String select = "SELECT * FROM tipo_inversion";
        listaTipoInversion = new ArrayList<TipoInversion>();


        try {
            statement = conexion.createStatement();
            tr = statement.executeQuery(select);


            while (tr.next()) {
                tipoInversion = new TipoInversion();

                tipoInversion.setIdTipoInversion(tr.getString("idTipoInversion"));
                tipoInversion.setNombreTipoInversion(tr.getString("nombreTipoInv"));

                listaTipoInversion.add(tipoInversion);

            }

        } catch (SQLException sqle) {
            System.out.println(sqle);

        }

        return listaTipoInversion;

    }

    public List<Subclasificacion> listaDeSubClasificaciones(String clasificacion) {


        ResultSet tr = null;
        String select = String.format("SELECT * FROM subclasificacion WHERE idTipoClasificacion ='%s'", clasificacion);

        listaSubclasificacion = new ArrayList<Subclasificacion>();


        try {
            statement = conexion.createStatement();
            tr = statement.executeQuery(select);


            while (tr.next()) {
                subclasificacion = new Subclasificacion(tr.getString("idSubClasificacion"),
                        tr.getString("idTipoClasificacion"),
                        tr.getString("nombresubClasificacion")
                );
                listaSubclasificacion.add(subclasificacion);

            }

        } catch (SQLException sqle) {
            System.out.println(sqle);

        }

        return listaSubclasificacion;

    }


    public List<TipoObra> listaDeObras() {


        ResultSet tr = null;
        String select = "SELECT * FROM tipo_obra";
        listaTipoObra = new ArrayList<TipoObra>();


        try {
            statement = conexion.createStatement();
            tr = statement.executeQuery(select);


            while (tr.next()) {
                tipoObra = new TipoObra();

                tipoObra.setIdTipoObra(tr.getString("idTipoObra"));
                tipoObra.setNombreTipoObra(tr.getString("nombreTipoObra"));

                listaTipoObra.add(tipoObra);

            }

        } catch (SQLException sqle) {
            System.out.println(sqle);

        }

        return listaTipoObra;


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
