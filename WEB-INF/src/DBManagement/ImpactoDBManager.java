package DBManagement;

import modelObrasYProgramas.Impacto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedrocontreras on 27/02/15.
 */
public class ImpactoDBManager {

    static Connection conexion = null;


    public static boolean crearImpacto(Impacto impacto) {
        try {
            conexion = DataSourceFactory.getMySQLDataSource().getConnection();
            CallableStatement callableStatement = conexion.prepareCall("{CALL sp_ins_impactos(?)}");
            callableStatement.setString("p_nombreImpacto", impacto.getNombreImpacto());
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

    public static List<Impacto> getImpactoById(Impacto impacto) {

        Connection conexion = null;
        ResultSetMapper<Impacto> resultSetMapper = new ResultSetMapper<Impacto>();
        ResultSet resultSet;
        List<Impacto> impactoList = null;

        try {
            conexion = DataSourceFactory.getMySQLDataSource().getConnection();
            CallableStatement callableStatement = conexion.prepareCall("{CALL sp_sel_impactoByID(?)}");
            callableStatement.setString("p_idImpacto", impacto.getIdImpacto());

            if (callableStatement.execute()) {
                resultSet = callableStatement.getResultSet();
                impactoList = resultSetMapper.mapRersultSetToObject(resultSet, Impacto.class);
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


    public static boolean updateImpacto(Impacto impacto) {
        try {
            conexion = DataSourceFactory.getMySQLDataSource().getConnection();
            CallableStatement callableStatement = conexion.prepareCall("{CALL sp_upd_impactos(?,?)}");
            callableStatement.setString("p_idImpacto", impacto.getIdImpacto());
            callableStatement.setString("p_nombreImpacto", impacto.getNombreImpacto());
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

    public static boolean deleteImpacto(Impacto impacto) {
        try {
            conexion = DataSourceFactory.getMySQLDataSource().getConnection();
            CallableStatement callableStatement = conexion.prepareCall("{CALL sp_del_impactos(?)}");
            callableStatement.setString("p_nombreImpacto", impacto.getIdImpacto());
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


    public static List<Impacto> listaDeImpactos() {
        ResultSet tr = null;
        String select = "SELECT * FROM impactos";

        ArrayList<Impacto> listaImpacto = new ArrayList<Impacto>();

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
                Impacto impacto = new Impacto();

                impacto.setIdImpacto(tr.getString("idImpacto"));
                impacto.setNombreImpacto(tr.getString("nombreImpacto"));

                listaImpacto.add(impacto);

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

        return listaImpacto;
    }
}
