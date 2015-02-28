package DBManagement;

import modelObrasYProgramas.TipoClasificacion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedrocontreras on 27/02/15.
 */
public class ClasificacionDBManager {

    private static Connection conexion;


    public static void crearClasificacion(TipoClasificacion tipoClasificacion) {

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
