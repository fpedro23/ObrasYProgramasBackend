package DBManagement;

import modelObrasYProgramas.TipoInversion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedrocontreras on 27/02/15.
 */
public class TipoDeInversionDBManager {


    public static boolean crearTipoDeInversion(TipoInversion tipoInversion) {

        Connection conexion = null;


        try {
            conexion = DataSourceFactory.getMySQLDataSource().getConnection();
            CallableStatement callableStatement = conexion.prepareCall("{CALL sp_ins_tipo_inversion(?,?)}");
            callableStatement.setString("p_nombreTipoInv", tipoInversion.getNombreTipoInversion());
            callableStatement.setString("p_inversionCorta", tipoInversion.getNombreTipoInversionCorta());
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


    public static List<TipoInversion> getInversionById(TipoInversion tipoInversion) {

        Connection conexion = null;
        ResultSetMapper<TipoInversion> resultSetMapper = new ResultSetMapper<TipoInversion>();
        ResultSet resultSet;
        List<TipoInversion> inversionList = null;

        try {
            conexion = DataSourceFactory.getMySQLDataSource().getConnection();
            CallableStatement callableStatement = conexion.prepareCall("{CALL sp_sel_inversionByID(?)}");
            callableStatement.setString("p_idTipoInversion", tipoInversion.getIdTipoInversion());

            if (callableStatement.execute()) {
                resultSet = callableStatement.getResultSet();
                inversionList = resultSetMapper.mapRersultSetToObject(resultSet, TipoInversion.class);
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
        return inversionList;
    }

    public static boolean updateInversion(TipoInversion tipoInversion) {

        Connection conexion = null;


        try {
            conexion = DataSourceFactory.getMySQLDataSource().getConnection();
            CallableStatement callableStatement = conexion.prepareCall("{CALL sp_upd_tipo_inversion(?,?,?)}");
            callableStatement.setString("p_idTipoInversion", tipoInversion.getIdTipoInversion());
            callableStatement.setString("p_nombreTipoInv", tipoInversion.getNombreTipoInversion());
            callableStatement.setString("p_inversionCorta", tipoInversion.getNombreTipoInversionCorta());
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


    public static boolean deleteInversion(TipoInversion tipoInversion) {


        Connection conexion = null;

        try {
            conexion = DataSourceFactory.getMySQLDataSource().getConnection();
            CallableStatement callableStatement = conexion.prepareCall("{CALL sp_del_tipo_inversion(?)}");
            callableStatement.setString("p_idTipoInversion", tipoInversion.getIdTipoInversion());
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

    public static List<TipoInversion> listaDeInversiones() {


        ResultSet tr = null;
        String select = "SELECT * FROM tipo_inversion";
        ArrayList<TipoInversion> listaTipoInversion = new ArrayList<TipoInversion>();
        Statement statement = null;


        Connection conexion = null;


        try {
            conexion = DataSourceFactory.getMySQLDataSource().getConnection();
            statement = conexion.createStatement();
            tr = statement.executeQuery(select);


            while (tr.next()) {
                TipoInversion tipoInversion = new TipoInversion();

                tipoInversion.setIdTipoInversion(tr.getString("idTipoInversion"));
                tipoInversion.setNombreTipoInversion(tr.getString("nombreTipoInv"));

                listaTipoInversion.add(tipoInversion);

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

        return listaTipoInversion;

    }
}
