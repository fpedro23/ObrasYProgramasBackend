package modelObrasYProgramas;
import java.util.*;
import java.sql.*;

public class ReporteEstado
{
    
    private String nombreEstado;
    private String numeroObras;
    private String totalInvertido;
    
    
    public ReporteEstado(ResultSet tr){
        try{
            this.setNombreEstado(tr.getString("nombreEstado"));
            this.setNumeroObras(tr.getString(2));
            this.setTotalInvertido(tr.getString("totalInvertido"));
        }
        catch(SQLException sqle){
            System.out.println(sqle);
            
        }
    }
    
    /**
     * @return the nombreEstado
     */
    public String getNombreEstado() {
        return nombreEstado;
    }
    /**
     * @param nombreEstado the nombreEstado to set
     */
    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
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