package modelObrasYProgramas;
import java.util.*;
import java.sql.*;

public class ReporteEstado
{

    private Estado estado;
    private String numeroObras;
    private String totalInvertido;
    
    
    public ReporteEstado(ResultSet tr){
        try{

            estado = new Estado();

            estado.setIdEstado(tr.getString("idEstado"));
            estado.setNombreEstado(tr.getString("nombreEstado"));
            estado.setLatitud(tr.getString("latitud"));
            estado.setLongitud(tr.getString("longitud"));

            this.setNumeroObras(tr.getString("numeroObras"));
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