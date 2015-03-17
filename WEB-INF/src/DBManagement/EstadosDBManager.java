package DBManagement;

import modelObrasYProgramas.Estado;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedrocontreras on 27/02/15.
 */
public class EstadosDBManager {


    public static List<Estado> listaDeEstados() {

        Estado estado;
        List<Estado> listaEstado;
        Statement statement = null;

        ResultSet tr = null;
        String select = "SELECT * FROM estados";
        listaEstado = new ArrayList<Estado>();


        Connection conexion = null;

        try {
            conexion = DataSourceFactory.getMySQLDataSource().getConnection();
            statement = conexion.createStatement();
            tr = statement.executeQuery(select);


            while (tr.next()) {
                estado = new Estado();

                estado.setIdEstado(tr.getString("idEstado"));
                estado.setNombreEstado(tr.getString("nombreEstado"));
                estado.setLatitud(tr.getString("latitud"));
                estado.setLongitud(tr.getString("longitud"));

                listaEstado.add(estado);

            }

        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle);

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

        return listaEstado;
    }


}
