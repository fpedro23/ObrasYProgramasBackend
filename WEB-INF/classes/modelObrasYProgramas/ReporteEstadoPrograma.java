package modelObrasYProgramas;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Pedro on 11/10/14.
 */
public class ReporteEstadoPrograma extends ReporteEstado {

    private String anio;

    public ReporteEstadoPrograma(ResultSet tr) {
        super(tr);
        try {
            this.setAnio(tr.getString("anioPrograma"));
        } catch (SQLException sqle) {
            System.out.println(sqle);

        }
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }
}
