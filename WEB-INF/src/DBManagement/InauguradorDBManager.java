package DBManagement;

import modelObrasYProgramas.Inaugurador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedrocontreras on 27/02/15.
 */
public class InauguradorDBManager {


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
