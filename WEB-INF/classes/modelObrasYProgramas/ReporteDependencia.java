package modelObrasYProgramas;

import java.sql.*;

public class ReporteDependencia {

    private Dependencia dependencia;
    private String numeroRegistros;
    private String totalInvertido;


    public ReporteDependencia(ResultSet tr) {
        try {
            dependencia = new Dependencia();

            dependencia.setIdDependencia(tr.getString("idDependencia"));
            dependencia.setNombreDependencia(tr.getString("nombreDependencia"));

            this.setNumeroRegistros(tr.getString("numeroObras"));
            this.setTotalInvertido(tr.getString("totalInvertido"));
        } catch (SQLException sqle) {
            System.out.println(sqle);

        }
    }


    public Dependencia getDependencia() {
        return dependencia;
    }

    public void setDependencia(Dependencia dependencia) {
        this.dependencia = dependencia;
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