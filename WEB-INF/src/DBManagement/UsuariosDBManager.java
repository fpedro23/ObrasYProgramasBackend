package DBManagement;

import modelObrasYProgramas.Usuario;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Pedro on 16/03/15.
 */
public class UsuariosDBManager {

    public static List<Usuario> listaDeUsuarios() {

        Connection conexion = null;
        ResultSetMapper<Usuario> resultSetMapper = new ResultSetMapper<Usuario>();
        ResultSet resultSet;
        List<Usuario> usuarioList = null;

        try {
            conexion = DataSourceFactory.getMySQLDataSource().getConnection();
            CallableStatement callableStatement = conexion.prepareCall("{CALL sp_sel_usuarios()}");
            if (callableStatement.execute()) {
                resultSet = callableStatement.getResultSet();
                usuarioList = resultSetMapper.mapRersultSetToObject(resultSet, Usuario.class);
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
        return usuarioList;
    }


    public static boolean crearUsuario(Usuario usuario) {

        Connection conexion = null;
        try {
            conexion = DataSourceFactory.getMySQLDataSource().getConnection();

        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
        }

        try {
            conexion = DataSourceFactory.getMySQLDataSource().getConnection();
            CallableStatement callableStatement = conexion.prepareCall("{CALL sp_ins_usuarios(?,?,?,?,?)}");
            callableStatement.setString("p_nombreUsuario", usuario.getNombreUsuario());
            callableStatement.setString("p_apellidoPaterno", usuario.getApellidoPaterno());
            callableStatement.setString("p_apellidoMaterno", usuario.getApellidoMaterno());
            callableStatement.setInt("p_idDependencia", usuario.getIdDependencia());
            callableStatement.setInt("p_idRol", usuario.getIdRol());

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


    public static boolean actualizarUsario(Usuario usuario) {

        Connection conexion = null;
        try {
            conexion = DataSourceFactory.getMySQLDataSource().getConnection();

        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
        }

        try {
            conexion = DataSourceFactory.getMySQLDataSource().getConnection();
            CallableStatement callableStatement = conexion.prepareCall("{CALL sp_upd_usuarios(?,?,?,?,?,?)}");
            callableStatement.setInt("p_idUsuario", usuario.getIdUsuario());
            callableStatement.setString("p_nombreUsuario", usuario.getNombreUsuario());
            callableStatement.setString("p_apellidoPaterno", usuario.getApellidoPaterno());
            callableStatement.setString("p_apellidoMaterno", usuario.getApellidoMaterno());
            callableStatement.setInt("p_idDependencia", usuario.getIdDependencia());
            callableStatement.setInt("p_idRol", usuario.getIdRol());

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


    public static boolean deleteUsuario(Usuario usuario) {

        Connection conexion = null;
        try {
            conexion = DataSourceFactory.getMySQLDataSource().getConnection();

        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
        }

        try {
            conexion = DataSourceFactory.getMySQLDataSource().getConnection();
            CallableStatement callableStatement = conexion.prepareCall("{CALL sp_del_usuarios(?)}");
            callableStatement.setInt("p_idUsuario", usuario.getIdUsuario());
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


}
