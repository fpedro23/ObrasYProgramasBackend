package DBManagement;

import modelObrasYProgramas.Impacto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedrocontreras on 27/02/15.
 */
public class ImpactoDBManager {

    public static List<Impacto> listaDeImpactos() {
        ResultSet tr = null;
        String select = "SELECT * FROM impactos";

        ArrayList<Impacto> listaImpacto = new ArrayList<Impacto>();

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
