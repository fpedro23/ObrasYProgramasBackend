package DBManagement;

import modelObrasYProgramas.Inaugurador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedrocontreras on 27/02/15.
 */
public class InauguradorDBManager {
    //
    public static boolean createInaugurador(Inaugurador inaugurador) {
        Connection conexion = null;
        try {
            conexion = DataSourceFactory.getMySQLDataSource().getConnection();
            CallableStatement callableStatement = conexion.prepareCall("{CALL sp_ins_cargo_inaugura(?)}");
            callableStatement.setString("p_nombreCargoInaugura", inaugurador.getNombreCargoInaugura());
            callableStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static List<Inaugurador> getInauguradorById(Inaugurador inaugurador) {

        Connection conexion = null;
        ResultSetMapper<Inaugurador> resultSetMapper = new ResultSetMapper<Inaugurador>();
        ResultSet resultSet;
        List<Inaugurador> impactoList = null;

        try {
            conexion = DataSourceFactory.getMySQLDataSource().getConnection();
            CallableStatement callableStatement = conexion.prepareCall("{CALL sp_sel_inauguradorByID(?)}");
            callableStatement.setString("p_idCargoInaugura", inaugurador.getIdCargoInaugura());

            if (callableStatement.execute()) {
                resultSet = callableStatement.getResultSet();
                impactoList = resultSetMapper.mapRersultSetToObject(resultSet, Inaugurador.class);
            }
        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return impactoList;
    }


    public static boolean updateInaugurador(Inaugurador inaugurador) {
        Connection conexion = null;
        try {
            conexion = DataSourceFactory.getMySQLDataSource().getConnection();
            CallableStatement callableStatement = conexion.prepareCall("{CALL sp_upd_cargo_inaugura(?,?)}");
            callableStatement.setString("p_idCargoInaugura", inaugurador.getIdCargoInaugura());
            callableStatement.setString("p_nombreCargoInaugura", inaugurador.getNombreCargoInaugura());
            callableStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean deleteInaugurador(Inaugurador inaugurador) {
        Connection conexion = null;
        try {
            conexion = DataSourceFactory.getMySQLDataSource().getConnection();
            CallableStatement callableStatement = conexion.prepareCall("{CALL sp_del_cargo_inaugura(?)}");
            callableStatement.setString("p_idCargoInaugura", inaugurador.getIdCargoInaugura());
            callableStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    public static List<Inaugurador> listaDeInauguradores() {

        ResultSet tr = null;
        String select = "SELECT * FROM cargo_inaugura";
        ArrayList<Inaugurador> listaInaugurador = new ArrayList<Inaugurador>();
        Connection conexion = null;
        Statement statement = null;

        try {
            conexion = DataSourceFactory.getMySQLDataSource().getConnection();

        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
        }

        try {
            statement = conexion.createStatement();
            tr = statement.executeQuery(select);


            while (tr.next()) {
                Inaugurador inaugurador = new Inaugurador();

                inaugurador.setIdCargoInaugura(tr.getString("idCargoInaugura"));
                inaugurador.setNombreCargoInaugura(tr.getString("nombreCargoInaugura"));

                listaInaugurador.add(inaugurador);

            }

        } catch (SQLException sqle) {
            System.out.println(sqle);
        } finally {
            if (tr != null) try {
                tr.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (statement != null) try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (conexion != null) try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return listaInaugurador;

    }

}
