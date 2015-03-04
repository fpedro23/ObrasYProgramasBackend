package DBManagement;

import modelObrasYProgramas.TipoClasificacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedrocontreras on 27/02/15.
 */
public class ClasificacionDBManager {

    private static Connection conexion;


    public static boolean crearClasificacion(TipoClasificacion tipoClasificacion) {
        try {
            conexion = DataSourceFactory.getMySQLDataSource().getConnection();
            CallableStatement callableStatement = conexion.prepareCall("{CALL sp_ins_tipo_clasificacion(?,?)}");
            callableStatement.setString("p_nombreTipoClasificacion", tipoClasificacion.getNombreTipoClasificacion());
            callableStatement.setString("p_clasificacionCorta", tipoClasificacion.getClasificacionCorta());
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

    public static boolean updateClasificacion(TipoClasificacion tipoClasificacion) {
        try {
            conexion = DataSourceFactory.getMySQLDataSource().getConnection();
            CallableStatement callableStatement = conexion.prepareCall("{CALL sp_upd_tipo_clasificacion(?,?,?)}");
            callableStatement.setString("p_idTipoClasificacion", tipoClasificacion.getIdTipoClasificacion());
            callableStatement.setString("p_nombreTipoClasificacion", tipoClasificacion.getNombreTipoClasificacion());
            callableStatement.setString("p_clasificacionCorta", tipoClasificacion.getClasificacionCorta());
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


    public static boolean deleteClasificacion(TipoClasificacion tipoClasificacion) {
        try {
            conexion = DataSourceFactory.getMySQLDataSource().getConnection();
            CallableStatement callableStatement = conexion.prepareCall("{CALL sp_del_tipo_clasificacion(?)}");
            callableStatement.setString("p_idTipoClasificacion", tipoClasificacion.getIdTipoClasificacion());
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



    public static List<TipoClasificacion> listaDeClasificaciones() {


        try {
            conexion = DataSourceFactory.getMySQLDataSource().getConnection();

        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
        }

        TipoClasificacion tipoClasificacion;
        List<TipoClasificacion> listaTipoClasificacion;
        Statement statement = null;

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


        return listaTipoClasificacion;


    }
}
