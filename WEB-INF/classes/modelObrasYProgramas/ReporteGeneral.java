package modelObrasYProgramas;
import java.util.*;
import java.sql.*;

public class ReporteGeneral
{
    
    private String numeroObras;
    private String totalInvertido;

    public ReporteGeneral(ResultSet tr){
        try{
            this.setNumeroObras(tr.getString(1));
            this.setTotalInvertido(tr.getString("totalInvertido"));
        }
        catch(SQLException sqle){
            System.out.println(sqle);
            
        }
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