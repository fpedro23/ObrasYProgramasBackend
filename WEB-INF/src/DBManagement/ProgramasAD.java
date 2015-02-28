package DBManagement;

import modelObrasYProgramas.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProgramasAD {
    private Connection conexion;
    private Statement statement;
    private CallableStatement callableStatement;

    private List<Programa> listaBusqueda;
    private Programa programa;
    private ResultadoPrograma resultadoPrograma;
    private List<ReporteDependencia> listaReporteDependencia;
    private List<ReporteEstado> listaReporteEstado;
    private List<ReporteGeneral> listaReporteGeneral;


    public ProgramasAD() {
        try {
            conexion = DataSourceFactory.getMySQLDataSource().getConnection();

        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
        }

    }
    private Double getValorDolar(){
        //https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20(%22USDMXN%22)&format=json&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=
        return 13.50;
    }

    public ResultadoPrograma buscar(Consulta consulta) {

        ResultSet tr = null;
        listaBusqueda = new ArrayList<Programa>();
        listaReporteDependencia = new ArrayList<ReporteDependencia>();
        listaReporteEstado = new ArrayList<ReporteEstado>();
        listaReporteGeneral = new ArrayList<ReporteGeneral>();


        try {

            if (consulta.getIdPrograma() != null) {
                callableStatement = conexion.prepareCall("{CALL buscarProgramasID(?,?)}");
                callableStatement.setString("inIDPrograma", consulta.getIdPrograma());
                callableStatement.setDouble("inValorDolar",this.getValorDolar());

            } else if (consulta.getBusquedaRapida() != null) {
                callableStatement = conexion.prepareCall("{CALL busquedaRapidaProgramas(?,?,?,?)}");
                callableStatement.setString("inBusquedaRapida", consulta.getBusquedaRapida());
                callableStatement.setInt("inLimiteMin", consulta.getLimiteMin());
                callableStatement.setInt("inLimiteMax", consulta.getLimiteMax());
                callableStatement.setDouble("inValorDolar",this.getValorDolar());


            } else {
                callableStatement = conexion.prepareCall("{CALL buscarProgramas(?,?,?,?,?,?,?,?,?,?)}");

                callableStatement.setString("inDependencia", consulta.getDependencia());
                callableStatement.setString("inEstado", consulta.getEstado());
                callableStatement.setString("inRangoInversionMin", consulta.getInversionMinima());
                callableStatement.setString("inRangoInversionMax", consulta.getInversionMaxima());
                callableStatement.setString("inTipoClasificacion", consulta.getClasificacion());
                callableStatement.setInt("inLimiteMin", consulta.getLimiteMin());
                callableStatement.setInt("inLimiteMax", consulta.getLimiteMax());
                callableStatement.setString("inNombrePrograma", consulta.getNombrePrograma());
                callableStatement.setString("inAnoPrograma",consulta.getAnoPrograma());
                callableStatement.setDouble("inValorDolar",this.getValorDolar());


            }


            boolean hasResults = callableStatement.execute();

            int i = 0;

            while (hasResults) {
                tr = callableStatement.getResultSet();

                if (i == 0) {
                    while (tr.next()) {
                        programa = new Programa(tr);
                        listaBusqueda.add(programa);

                    }
                }
                if (i == 1) {
                    while (tr.next()) {
                        ReporteDependencia reporteDependencia = new ReporteDependenciaPrograma(tr);


                        listaReporteDependencia.add(reporteDependencia);
                    }
                }
                if (i == 2) {
                    while (tr.next()) {
                        ReporteEstado reporteEstado = new ReporteEstadoPrograma(tr);
                        listaReporteEstado.add(reporteEstado);

                    }
                }
                if (i == 3) {
                    while (tr.next()) {
                        ReporteGeneral reporteGeneral = new ReporteGeneralPrograma(tr);
                        listaReporteGeneral.add(reporteGeneral);
                    }

                }

                System.out.println("Resultado número: " + i);

                hasResults = callableStatement.getMoreResults();
                i++;
            }

        } catch (SQLException sqle) {
            System.out.println(sqle);

        }

        resultadoPrograma = new ResultadoPrograma();

        resultadoPrograma.setListaProgramas(listaBusqueda);
        resultadoPrograma.setListaReporteDependencia(listaReporteDependencia);
        resultadoPrograma.setListaReporteEstado(listaReporteEstado);
        resultadoPrograma.setListaReporteGeneral(listaReporteGeneral);

        return resultadoPrograma;

    }


}
