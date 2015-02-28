package DBManagement;

import modelObrasYProgramas.Dependencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedrocontreras on 27/02/15.
 */
public class DependenciaDBManager {

    public static List<Dependencia> listaDeDependencias() {
        ResultSet tr = null;
        String select = "SELECT * FROM dependencias";
        ArrayList<Dependencia> listaDependencia = new ArrayList<Dependencia>();
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
                Dependencia dependencia = new Dependencia();

                dependencia.setIdDependencia(tr.getString("idDependencia"));
                dependencia.setNombreDependencia(tr.getString("nombreDependencia"));
                dependencia.setImagenDependencia(tr.getString("imagenDependencia"));

                listaDependencia.add(dependencia);

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

        return listaDependencia;
    }
}
