package modelObrasYProgramas;
import java.util.*;

public class Obra
{
    
	private String idObra;
    private TipoObra tipoObra;
	private Dependencia dependencia;
    private Estado estado;
    private Municipio municipio;
    private PoblacionObjetivo poblacionObjetivo;
    private Impacto impacto;
    private TipoInversion[] tipoInversion;
    private TipoClasificacion[] clasificacion;
    
    private String denominacion;
    private String descripcion;
    private String observaciones;

    private String fechaInicio;
    private String fechaTermino;
	private String inversionTotal;
    private String totalBeneficiarios;
    
    private Inaugurador inaugurador;
    
    private String senalizacion;
    private String susceptibleInauguracion;
    private String porcentajeAvance;
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
	 * @return the municipio
	 */
	public Municipio getMunicipio() {
		return municipio;
	}
	/**
	 * @param municipio the municipio to set
	 */
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	/**
	 * @return the poblacionObjetivo
	 */
	public PoblacionObjetivo getPoblacionObjetivo() {
		return poblacionObjetivo;
	}
	/**
	 * @param poblacionObjetivo the poblacionObjetivo to set
	 */
	public void setPoblacionObjetivo(PoblacionObjetivo poblacionObjetivo) {
		this.poblacionObjetivo = poblacionObjetivo;
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
    
}