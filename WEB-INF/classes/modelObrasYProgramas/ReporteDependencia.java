package modelObrasYProgramas;
import java.util.*;
import java.sql.*;

public class ReporteDependencia
{
    
    private String nombreDependencia;
    private String numeroObras;
    private String totalInvertido;
    
    
    public ReporteDependencia(ResultSet tr){
        try{
            this.setNombreDependencia(tr.getString("nombreDependencia"));
            this.setNumeroObras(tr.getString(2));
            this.setTotalInvertido(tr.getString("totalInvertido"));
        }
        catch(SQLException sqle){
            System.out.println(sqle);
            
        }
    }
    
    public String getNombreDependencia() {
        return nombreDependencia;
    }
    /**
     * @param nombreDependencia the nombreDependencia to set
     */
    public void setNombreDependencia(String nombreDependencia) {
        this.nombreDependencia = nombreDependencia;
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