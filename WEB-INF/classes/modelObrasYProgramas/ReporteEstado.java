package modelObrasYProgramas;

import java.sql.*;

public class ReporteEstado {

    private Estado estado;
    private String numeroRegistros;
    private String totalInvertido;


    public ReporteEstado(ResultSet tr) {
        try {

            estado = new Estado();

            estado.setIdEstado(tr.getString("idEstado"));
            estado.setNombreEstado(tr.getString("nombreEstado"));
            estado.setLatitud(tr.getString("latitud"));
            estado.setLongitud(tr.getString("longitud"));

            this.setNumeroRegistros(tr.getString("numeroObras"));
            this.setTotalInvertido(tr.getString("totalInvertido"));
        } catch (SQLException sqle) {
            System.out.println(sqle);

        }
    }


    public String getNumeroRegistros() {
        return numeroRegistros;
    }

    /**
     * @param numeroRegistros the numeroRegistros to set
     */
    public void setNumeroRegistros(String numeroRegistros) {
        this.numeroRegistros = numeroRegistros;
    }

    /**
     * @return the totalInvertido
     */
    public String getTotalInvertido() {
        return totalInvertido;
    }

    /**
     * @param totalInvertido the totalInvertido to set
     */
    public void setTotalInvertido(String totalInvertido) {
        this.totalInvertido = totalInvertido;
    }

}