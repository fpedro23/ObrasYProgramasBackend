package modelObrasYProgramas;
import java.util.*;

public class Programa
{
    
    
	private String idPrograma;
	private String nombreDependencia;
	private String nombreTipoApoyo;
	private String montoApoyo;
	private String nombrePoblacionObjetivo;
    private String totalBeneficiarios;
    private String nombreDeEstado;
    private String totalMunicipiosBeneficiados;
    private String inversionTotal;
    private String lineaBase;
    private String metaBeneficiarios;
    private String absoluto;
    private String porcentual;
    private String observaciones;
    
    
	public Programa(String idPrograma, String nombreDependencia,
                    String nombreTipoApoyo, String montoApoyo,
                    String nombrePoblacionObjetivo, String totalBeneficiarios,
                    String nombreDeEstado, String totalMunicipiosBeneficiados,
                    String inversionTotal, String lineaBase, String metaBeneficiarios,
                    String absoluto, String porcentual, String observaciones) {
		super();
		this.idPrograma = idPrograma;
		this.nombreDependencia = nombreDependencia;
		this.nombreTipoApoyo = nombreTipoApoyo;
		this.montoApoyo = montoApoyo;
		this.nombrePoblacionObjetivo = nombrePoblacionObjetivo;
		this.totalBeneficiarios = totalBeneficiarios;
		this.nombreDeEstado = nombreDeEstado;
		this.totalMunicipiosBeneficiados = totalMunicipiosBeneficiados;
		this.inversionTotal = inversionTotal;
		this.lineaBase = lineaBase;
		this.metaBeneficiarios = metaBeneficiarios;
		this.absoluto = absoluto;
		this.porcentual = porcentual;
		this.observaciones = observaciones;
	}
    
    
	/**
	 * @return the idPrograma
	 */
	public String getIdPrograma() {
		return idPrograma;
	}
	/**
	 * @param idPrograma the idPrograma to set
	 */
	public void setIdPrograma(String idPrograma) {
		this.idPrograma = idPrograma;
	}
	/**
	 * @return the nombreDependencia
	 */
	public String getNombreDependencia() {
		return nombreDependencia;
	}
	/**
	 * @param nombreDependencia the nombreDependencia to set
	 */
	public void setNombreDependencia(String nombreDependencia) {
		this.nombreDependencia = nombreDependencia;
	}
	/**
	 * @return the nombreTipoApoyo
	 */
	public String getNombreTipoApoyo() {
		return nombreTipoApoyo;
	}
	/**
	 * @param nombreTipoApoyo the nombreTipoApoyo to set
	 */
	public void setNombreTipoApoyo(String nombreTipoApoyo) {
		this.nombreTipoApoyo = nombreTipoApoyo;
	}
	/**
	 * @return the montoApoyo
	 */
	public String getMontoApoyo() {
		return montoApoyo;
	}
	/**
	 * @param montoApoyo the montoApoyo to set
	 */
	public void setMontoApoyo(String montoApoyo) {
		this.montoApoyo = montoApoyo;
	}
	/**
	 * @return the nombrePoblacionObjetivo
	 */
	public String getNombrePoblacionObjetivo() {
		return nombrePoblacionObjetivo;
	}
	/**
	 * @param nombrePoblacionObjetivo the nombrePoblacionObjetivo to set
	 */
	public void setNombrePoblacionObjetivo(String nombrePoblacionObjetivo) {
		this.nombrePoblacionObjetivo = nombrePoblacionObjetivo;
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
	 * @return the nombreDeEstado
	 */
	public String getNombreDeEstado() {
		return nombreDeEstado;
	}
	/**
	 * @param nombreDeEstado the nombreDeEstado to set
	 */
	public void setNombreDeEstado(String nombreDeEstado) {
		this.nombreDeEstado = nombreDeEstado;
	}
	/**
	 * @return the totalMunicipiosBeneficiados
	 */
	public String getTotalMunicipiosBeneficiados() {
		return totalMunicipiosBeneficiados;
	}
	/**
	 * @param totalMunicipiosBeneficiados the totalMunicipiosBeneficiados to set
	 */
	public void setTotalMunicipiosBeneficiados(String totalMunicipiosBeneficiados) {
		this.totalMunicipiosBeneficiados = totalMunicipiosBeneficiados;
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
	 * @return the lineaBase
	 */
	public String getLineaBase() {
		return lineaBase;
	}
	/**
	 * @param lineaBase the lineaBase to set
	 */
	public void setLineaBase(String lineaBase) {
		this.lineaBase = lineaBase;
	}
	/**
	 * @return the metaBeneficiarios
	 */
	public String getMetaBeneficiarios() {
		return metaBeneficiarios;
	}
	/**
	 * @param metaBeneficiarios the metaBeneficiarios to set
	 */
	public void setMetaBeneficiarios(String metaBeneficiarios) {
		this.metaBeneficiarios = metaBeneficiarios;
	}
	/**
	 * @return the absoluto
	 */
	public String getAbsoluto() {
		return absoluto;
	}
	/**
	 * @param absoluto the absoluto to set
	 */
	public void setAbsoluto(String absoluto) {
		this.absoluto = absoluto;
	}
	/**
	 * @return the porcentual
	 */
	public String getPorcentual() {
		return porcentual;
	}
	/**
	 * @param porcentual the porcentual to set
	 */
	public void setPorcentual(String porcentual) {
		this.porcentual = porcentual;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
    
	public String toString() {
		return "Programa [idPrograma=" + idPrograma + ", nombreDependencia="
        + nombreDependencia + ", nombreTipoApoyo=" + nombreTipoApoyo
        + ", montoApoyo=" + montoApoyo + ", nombrePoblacionObjetivo="
        + nombrePoblacionObjetivo + ", totalBeneficiarios="
        + totalBeneficiarios + ", nombreDeEstado=" + nombreDeEstado
        + ", totalMunicipiosBeneficiados="
        + totalMunicipiosBeneficiados + ", inversionTotal="
        + inversionTotal + ", lineaBase=" + lineaBase
        + ", metaBeneficiarios=" + metaBeneficiarios + ", absoluto="
        + absoluto + ", porcentual=" + porcentual + ", observaciones="
        + observaciones + "]";
	}
    
    
    
}