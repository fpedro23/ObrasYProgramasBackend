package modelObrasYProgramas;

public class TipoClasificacion
{
    private String idTipoClasificacion;
    private String nombreTipoClasificacion;
    
    
    
    public TipoClasificacion(){
        this.idTipoClasificacion=null;
        this.nombreTipoClasificacion=null;
    }
    
    
    public TipoClasificacion(String idTipoClasificacion, String nombreTipoClasificacion){
        this.idTipoClasificacion = idTipoClasificacion;
        this.nombreTipoClasificacion = nombreTipoClasificacion;
    }
    
    
	/**
	 * @return the idTipoClasificacion
	 */
	public String getIdTipoClasificacion() {
		return idTipoClasificacion;
	}
	/**
	 * @param idTipoClasificacion the idTipoClasificacion to set
	 */
	public void setIdTipoClasificacion(String idTipoClasificacion) {
		this.idTipoClasificacion = idTipoClasificacion;
	}
	/**
	 * @return the nombreTipoClasificacion
	 */
	public String getNombreTipoClasificacion() {
		return nombreTipoClasificacion;
	}
	/**
	 * @param nombreTipoClasificacion the nombreTipoClasificacion to set
	 */
	public void setNombreTipoClasificacion(String nombreTipoClasificacion) {
		this.nombreTipoClasificacion = nombreTipoClasificacion;
	}
    
}