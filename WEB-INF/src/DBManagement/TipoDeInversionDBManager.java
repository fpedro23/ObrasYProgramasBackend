package DBManagement;

import modelObrasYProgramas.TipoInversion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedrocontreras on 27/02/15.
 */
public class TipoDeInversionDBManager {

    public static List<TipoInversion> listaDeInversiones() {


        ResultSet tr = null;
        String select = "SELECT * FROM tipo_inversion";
        ArrayList<TipoInversion> listaTipoInversion = new ArrayList<TipoInversion>();
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
