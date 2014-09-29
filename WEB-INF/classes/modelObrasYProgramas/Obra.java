package modelObrasYProgramas;
import java.util.*;
import java.sql.*;

public class Obra
{
    
	private String idObra;
    private String denominacion;

    public TipoObra tipoObra;
	public Dependencia dependencia;
    public Estado estado;
    public Impacto impacto;
    public TipoInversion[] tipoInversion;
    public TipoClasificacion[] clasificacion;
    public Inaugurador inaugurador;

    private String descripcion;
    private String observaciones;

    private String fechaInicio;
    private String fechaTermino;
	private String inversionTotal;
    private String totalBeneficiarios;
    
    
    private String senalizacion;
    private String susceptibleInauguracion;
    private String porcentajeAvance;
    
    private String fotoAntes;
    private String fotoDurante;
    private String fotoDespues;
    
    public Obra()
    {
        this.tipoObra = new TipoObra();
        this.dependencia = new Dependencia();
        this.estado = new Estado();
        this.impacto = new Impacto();
        //this.tipoInversion = new TipoInversion[]
        //this.clasificacion = new TipoClasificacion[]
        this.inaugurador = new Inaugurador();
    }
    
    public Obra(ResultSet tr){
        try{

            
        this.tipoObra = new TipoObra();
        this.dependencia = new Dependencia();
        this.estado = new Estado();
        this.impacto = new Impacto();
        //this.tipoInversion = new TipoInversion[]
        //this.clasificacion = new TipoClasificacion[]
        this.inaugurador = new Inaugurador();
        
            int i=1;
        
            this.setIdObra(tr.getString(i)); i++;
        this.setDenominacion(tr.getString(i));i++;
        
        this.tipoObra.setIdTipoObra(tr.getString(i));i++;
        this.tipoObra.setNombreTipoObra(tr.getString(i));i++;
        
        this.dependencia.setIdDependencia(tr.getString(i));i++;
        this.dependencia.setNombreDependencia(tr.getString(i));i++;
        
        this.estado.setIdEstado(tr.getString(i));i++;
        this.estado.setNombreEstado(tr.getString(i));i++;
        this.estado.setLatitud(tr.getString(i));i++;
        this.estado.setLongitud(tr.getString(i));i++;
        

        
        
        this.impacto.setIdImpacto(tr.getString(i));i++;
        this.impacto.setNombreImpacto(tr.getString(i));i++;
        
        //Hacer codigo para que de un tokenizer se vaya a objeto
        /*obra.tipoInversion.setIdDependencia(tr.getString(13));i++;
         obra.tipoInversion.setNombreDependencia(tr.getString(14));i++;
         
         obra.clasificacion.setIdDependencia(tr.getString(15));i++;
         obra.clasificacion.setNombreDependencia(tr.getString(16));i++;*/
        //Hacer Codigo para que de un tokenizer
        
            i++;i++;i++;i++;
        this.inaugurador.setIdCargoInaugura(tr.getString(i));i++;
        this.inaugurador.setNombreCargoInaugura(tr.getString(i));i++;
        
        this.setDescripcion(tr.getString(i));i++;
        this.setObservaciones(tr.getString(i));i++;
        this.setFechaInicio(tr.getString(i));i++;
        this.setFechaTermino(tr.getString(i));i++;
        this.setInversionTotal(tr.getString(i));i++;
        this.setTotalBeneficiarios(tr.getString(i));i++;
        this.setSenalizacion(tr.getString(i));i++;
        this.setSusceptibleInauguracion(tr.getString(i));i++;
        this.setPorcentajeAvance(tr.getString(i));i++;
        this.setFotoAntes(tr.getString(i));i++;
        this.setFotoDurante(tr.getString(i));i++;
        this.setFotoDespues(tr.getString(i));i++;

    
        }
        
        
        catch(SQLException sqle){
            System.out.println(sqle);
            
        }
    
    }
    
	/**
	 * @return the idObra
	 */
	public String getIdObra() {
		return idObra;
	}
	/**
	 * @param idObra the idObra to set
	 */
	public void setIdObra(String idObra) {
		this.idObra = idObra;
	}
	/**
	 * @return the tipoObra
	 */
	public TipoObra getTipoObra() {
		return tipoObra;
	}
	/**
	 * @param tipoObra the tipoObra to set
	 */
	public void setTipoObra(TipoObra tipoObra) {
		this.tipoObra = tipoObra;
	}
	/**
	 * @return the dependencia
	 */
	public Dependencia getDependencia() {
		return dependencia;
	}
	/**
	 * @param dependencia the dependencia to set
	 */
	public void setDependencia(Dependencia dependencia) {
		this.dependencia = dependencia;
	}
	/**
	 * @return the estado
	 */
	public Estado getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	/**
	 * @return the impacto
	 */
	public Impacto getImpacto() {
		return impacto;
	}
	/**
	 * @param impacto the impacto to set
	 */
	public void setImpacto(Impacto impacto) {
		this.impacto = impacto;
	}
	/**
	 * @return the TipoInversion
	 */
	public TipoInversion[] getTipoInversion() {
		return tipoInversion;
	}
	/**
	 * @param TipoInversion the TipoInversion to set
	 */
	public void setTipoInversion(TipoInversion[] tipoInversion) {
		this.tipoInversion = tipoInversion;
	}
	/**
	 * @return the TipoClasificacion
	 */
	public TipoClasificacion[] getTipoClasificacion() {
		return clasificacion;
	}
	/**
	 * @param TipoClasificacion the TipoClasificacion to set
	 */
	public void setTipoClasificacion(TipoClasificacion[] clasificacion) {
		this.clasificacion = clasificacion;
	}
	/**
	 * @return the denominacion
	 */
	public String getDenominacion() {
		return denominacion;
	}
	/**
	 * @param denominacion the denominacion to set
	 */
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}
	/**
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	/**
	 * @return the fechaInicio
	 */
	public String getFechaInicio() {
		return fechaInicio;
	}
	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	/**
	 * @return the fechaTermino
	 */
	public String getFechaTermino() {
		return fechaTermino;
	}
	/**
	 * @param fechaTermino the fechaTermino to set
	 */
	public void setFechaTermino(String fechaTermino) {
		this.fechaTermino = fechaTermino;
	}
	/**
	 * @return the inversionTotal
	 */
	public String getInversionTotal() {
		return inversionTotal;
	}
	/**
	 * @param inversionTotal the inversionTotal to set
	 */
	public void setInversionTotal(String inversionTotal) {
		this.inversionTotal = inversionTotal;
	}
	/**
	 * @return the totalBeneficiarios
	 */
	public String getTotalBeneficiarios() {
		return totalBeneficiarios;
	}
	/**
	 * @param totalBeneficiarios the totalBeneficiarios to set
	 */
	public void setTotalBeneficiarios(String totalBeneficiarios) {
		this.totalBeneficiarios = totalBeneficiarios;
	}
	/**
	 * @return the inaugurador
	 */
	public Inaugurador getInaugurador() {
		return inaugurador;
	}
	/**
	 * @param inaugurador the inaugurador to set
	 */
	public void setInaugurador(Inaugurador inaugurador) {
		this.inaugurador = inaugurador;
	}
	/**
	 * @return the senalizacion
	 */
	public String getSenalizacion() {
		return senalizacion;
	}
	/**
	 * @param senalizacion the senalizacion to set
	 */
	public void setSenalizacion(String senalizacion) {
		this.senalizacion = senalizacion;
	}
	/**
	 * @return the susceptibleInauguracion
	 */
	public String getSusceptibleInauguracion() {
		return susceptibleInauguracion;
	}
	/**
	 * @param susceptibleInauguracion the susceptibleInauguracion to set
	 */
	public void setSusceptibleInauguracion(String susceptibleInauguracion) {
		this.susceptibleInauguracion = susceptibleInauguracion;
	}
	/**
	 * @return the porcentajeAvance
	 */
	public String getPorcentajeAvance() {
		return porcentajeAvance;
	}
	/**
	 * @param porcentajeAvance the porcentajeAvance to set
	 */
	public void setPorcentajeAvance(String porcentajeAvance) {
		this.porcentajeAvance = porcentajeAvance;
	}
    
    
    /**
     * @return the fotoAntes
     */
    public String getFotoAntes() {
        return fotoAntes;
    }
    /**
     * @param fotoAntes the fotoAntes to set
     */
    public void setFotoAntes(String fotoAntes) {
        this.fotoAntes = fotoAntes;
    }
    /**
     * @return the fotoDurante
     */
    public String getFotoDurante() {
        return fotoDurante;
    }
    /**
     * @param fotoDurante the fotoDurante to set
     */
    public void setFotoDurante(String fotoDurante) {
        this.fotoDurante = fotoDurante;
    }
    /**
     * @return the fotoDespues
     */
    public String getFotoDespues() {
        return fotoDespues;
    }
    /**
     * @param fotoDespues the fotoDespues to set
     */
    public void setFotoDespues(String fotoDespues) {
        this.fotoDespues = fotoDespues;
    }
    
    
    public String toString() {
        return "TipoObra [idObra=" + idObra + ", denominacion=" + denominacion
        + ", descripcion=" + descripcion + ", observaciones="
        + observaciones + ", fechaInicio=" + fechaInicio
        + ", fechaTermino=" + fechaTermino + ", inversionTotal="
        + inversionTotal + ", totalBeneficiarios=" + totalBeneficiarios
        + ", senalizacion=" + senalizacion
        + ", susceptibleInauguracion=" + susceptibleInauguracion
        + ", porcentajeAvance=" + porcentajeAvance + "]";
    }
    
    
}