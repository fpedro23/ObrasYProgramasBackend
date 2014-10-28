package modelObrasYProgramas;

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
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //conexion = DriverManager.getConnection("jdbc:mysql://localhost/ObrasYProgramas?user=root");
            System.out.println("Conexion exitosa a la BD");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/obrasyprogramas", "oypdbuser", "0ypProj3ct!");
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


    public ResultadoPrograma buscar(Consulta consulta) {

        ResultSet tr = null;
        listaBusqueda = new ArrayList<Programa>();
        listaReporteDependencia = new ArrayList<ReporteDependencia>();
        listaReporteEstado = new ArrayList<ReporteEstado>();
        listaReporteGeneral = new ArrayList<ReporteGeneral>();


        try {

            if (consulta.getIdPrograma() != null) {
                callableStatement = conexion.prepareCall("{CALL buscarProgramasID(?)}");
                callableStatement.setString("inIDPrograma", consulta.getIdPrograma());
            } else if (consulta.getBusquedaRapida() != null) {
                callableStatement = conexion.prepareCall("{CALL busquedaRapidaProgramas(?,?,?)}");
                callableStatement.setString("inBusquedaRapida", consulta.getBusquedaRapida());
                callableStatement.setInt("inLimiteMin", consulta.getLimiteMin());
                callableStatement.setInt("inLimiteMax", consulta.getLimiteMax());

            } else {
                callableStatement = conexion.prepareCall("{CALL buscarProgramas(?,?,?,?,?,?,?,?,?)}");

                callableStatement.setString("inDependencia", consulta.getDependencia());
                callableStatement.setString("inEstado", consulta.getEstado());
                callableStatement.setString("inRangoInversionMin", consulta.getInversionMinima());
                callableStatement.setString("inRangoInversionMax", consulta.getInversionMaxima());
                callableStatement.setString("inTipoClasificacion", consulta.getClasificacion());
                callableStatement.setInt("inLimiteMin", consulta.getLimiteMin());
                callableStatement.setInt("inLimiteMax", consulta.getLimiteMax());
                callableStatement.setString("inNombrePrograma", consulta.getNombrePrograma());
                callableStatement.setString("inAnoPrograma",consulta.getAnoPrograma());

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
