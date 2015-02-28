package DBManagement;

import modelObrasYProgramas.Subclasificacion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedrocontreras on 27/02/15.
 */
public class SubclasificacionDBManager {


    public static List<Subclasificacion> listaDeSubClasificaciones(String clasificacion) {


        ResultSet tr = null;
        String select = String.format("SELECT * FROM subclasificacion WHERE idTipoClasificacion ='%s'", clasificacion);

        ArrayList<Subclasificacion> listaSubclasificacion = new ArrayList<Subclasificacion>();
        Statement statement = null;


        Connection conexion = null;
        try {
            conexion = DataSourceFactory.getMySQLDataSource().getConnection();

        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);
        }


        try {
            statement = conexion.createStatement();
            tr = statement.executeQuery(select);


            while (tr.next()) {
                Subclasificacion subclasificacion = new Subclasificacion(tr.getString("idSubClasificacion"),
                        tr.getString("idTipoClasificacion"),
                        tr.getString("nombresubClasificacion")
                );
                listaSubclasificacion.add(subclasificacion);

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

        return listaSubclasificacion;

    }

}
