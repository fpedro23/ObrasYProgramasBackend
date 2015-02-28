package DBManagement;

import modelObrasYProgramas.TipoObra;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedrocontreras on 27/02/15.
 */
public class TipoDeObraDBManager {

    public static List<TipoObra> listaDeObras() {


        ResultSet tr = null;
        String select = "SELECT * FROM tipo_obra";
        ArrayList<TipoObra> listaTipoObra = new ArrayList<TipoObra>();
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
                TipoObra tipoObra = new TipoObra();

                tipoObra.setIdTipoObra(tr.getString("idTipoObra"));
                tipoObra.setNombreTipoObra(tr.getString("nombreTipoObra"));

                listaTipoObra.add(tipoObra);

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

        return listaTipoObra;


    }
}
