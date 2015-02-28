package modelObrasYProgramas;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReporteGeneral {

    private String numeroRegistros;
    private String totalInvertido;

    public ReporteGeneral(ResultSet tr) {
        try {
            this.setNumeroRegistros(tr.getString(1));
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