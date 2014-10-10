package modelObrasYProgramas;
import java.util.*;
import java.sql.*;

public class ReporteDependencia
{

    private Dependencia dependencia;
    private String numeroObras;
    private String totalInvertido;
    
    
    public ReporteDependencia(ResultSet tr){
        try{
            dependencia = new Dependencia();

            dependencia.setIdDependencia(tr.getString("idDependencia"));
            dependencia.setNombreDependencia(tr.getString("nombreDependencia"));

            this.setNumeroObras(tr.getString("numeroObras"));
            this.setTotalInvertido(tr.getString("totalInvertido"));
        }
        catch(SQLException sqle){
            System.out.println(sqle);
            
        }
    }


    public Dependencia getDependencia() {
        return dependencia;
    }

    public void setDependencia(Dependencia dependencia) {
        this.dependencia = dependencia;
    }

    public String getNumeroObras() {
        return numeroObras;
    }
    /**
     * @param numeroObras the numeroObras to set
     */
    public void setNumeroObras(String numeroObras) {
        this.numeroObras = numeroObras;
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