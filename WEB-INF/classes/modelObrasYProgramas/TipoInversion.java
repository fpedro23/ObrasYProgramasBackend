package modelObrasYProgramas;
import java.util.*;

public class TipoInversion
{
    private String idTipoInversion;
    private String nombreTipoInversion;
    
    public TipoInversion(){
        this.idTipoInversion=null;
        this.nombreTipoInversion=null;
    }
    
    public TipoInversion(String idTipoInversion, String nombreTipoInversion){
        
        this.idTipoInversion = idTipoInversion;
        this.nombreTipoInversion = nombreTipoInversion;
        
        
    }
    
    
    
	/**
	 * @return the idTipoInversion
	 */
	public String getIdTipoInversion() {
		return idTipoInversion;
	}
	/**
	 * @param idTipoInversion the idTipoInversion to set
	 */
	public void setIdTipoInversion(String idTipoInversion) {
		this.idTipoInversion = idTipoInversion;
	}
	/**
	 * @return the nombreTipoInversion
	 */
	public String getNombreTipoInversion() {
		return nombreTipoInversion;
	}
	/**
	 * @param nombreTipoInversion the nombreTipoInversion to set
	 */
	public void setNombreTipoInversion(String nombreTipoInversion) {
		this.nombreTipoInversion = nombreTipoInversion;
	}
    
}