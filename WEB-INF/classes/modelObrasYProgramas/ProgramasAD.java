package modelObrasYProgramas;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProgramasAD {
    private Connection conexion;
    private Programa programa;


    public ProgramasAD() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/ObrasYProgramas?user=root");
            System.out.println("Conexion exitosa a la BD");
            //conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/obrasyprogramas", "oypdbuser", "0ypProj3ct!");
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

        ResultSet tr;
        List<Programa> listaBusqueda;
        listaBusqueda = new ArrayList<Programa>();

        HashMap<String, List<ReporteEstado>> hashMapEstado;
        hashMapEstado = new HashMap<String, List<ReporteEstado>>();

        HashMap<String, List<ReporteDependencia>> hashMapDependencia;
        hashMapDependencia = new HashMap<String, List<ReporteDependencia>>();

        HashMap<String, List<ReporteGeneral>> hashMapGeneral;
        hashMapGeneral = new HashMap<String, List<ReporteGeneral>>();


        try {
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall("{CALL buscarProgramas(?,?,?,?,?,?,?)}");

            callableStatement.setString("inDependencia", consulta.getDependencia());
            callableStatement.setString("inEstado", consulta.getEstado());
            callableStatement.setString("inRangoInversionMin", consulta.getInversionMinima());
            callableStatement.setString("inRangoInversionMax", consulta.getInversionMaxima());
            callableStatement.setString("inTipoClasificacion", consulta.getClasificacion());
            callableStatement.setInt("inLimiteMin", consulta.getLimiteMin());
            callableStatement.setInt("inLimiteMax", consulta.getLimiteMax());


            boolean hasResults = callableStatement.execute();

            int i = 0;

            while (hasResults) { //Programas
                tr = callableStatement.getResultSet();

                if (i == 0) {
                    while (tr.next()) {
                        programa = new Programa(tr);
                        listaBusqueda.add(programa);

                    }
                }
                if (i == 1) {
                    while (tr.next()) { //Reporte dependencias
                        ReporteDependencia reporteDependencia = new ReporteDependencia(tr);

                        String ano = tr.getString("anioPrograma");

                        if (hashMapDependencia.containsKey(ano)) {
                            List<ReporteDependencia> reporte = hashMapDependencia.get(ano);
                            reporte.add(reporteDependencia);
                            hashMapDependencia.put(ano, reporte);
                        } else {
                            List<ReporteDependencia> reporte = new ArrayList<ReporteDependencia>();
                            reporte.add(reporteDependencia);
                            hashMapDependencia.put(ano, reporte);
                        }
                    }
                }
                if (i == 2) {
                    while (tr.next()) { //Reporte de estados
                        ReporteEstado reporteEstado = new ReporteEstado(tr);

                        String ano = tr.getString("anioPrograma");

                        if (hashMapEstado.containsKey(ano)) {
                            List<ReporteEstado> reporte = hashMapEstado.get(ano);
                            reporte.add(reporteEstado);
                            hashMapEstado.put(ano, reporte);
                        } else {
                            List<ReporteEstado> reporte = new ArrayList<ReporteEstado>();
                            reporte.add(reporteEstado);
                            hashMapEstado.put(ano, reporte);
                        }
                    }
                }
                if (i == 3) {
                    while (tr.next()) {
                        ReporteGeneral reporteGeneral = new ReporteGeneral(tr);

                        String ano = tr.getString("anioPrograma");

                        if (hashMapGeneral.containsKey(ano)) {
                            List<ReporteGeneral> reporte = hashMapGeneral.get(ano);
                            reporte.add(reporteGeneral);
                            hashMapGeneral.put(ano, reporte);
                        } else {
                            List<ReporteGeneral> reporte = new ArrayList<ReporteGeneral>();
                            reporte.add(reporteGeneral);
                            hashMapGeneral.put(ano, reporte);
                        }
                    }

                }

                System.out.println("Resultado número: " + i);

                hasResults = callableStatement.getMoreResults();
                i++;
            }

        } catch (SQLException sqle) {
            System.out.println(sqle);

        }

        ResultadoPrograma resultadoPrograma;
        resultadoPrograma = new ResultadoPrograma();

        resultadoPrograma.setListaProgramas(listaBusqueda);
        resultadoPrograma.setHashMapReporteDependencia(hashMapDependencia);
        resultadoPrograma.setHashMapReporteEstado(hashMapEstado);
        resultadoPrograma.setHashMapReporteGeneral(hashMapGeneral);

        return resultadoPrograma;

    }


}
