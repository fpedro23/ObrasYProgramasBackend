package modelObrasYProgramas;

import java.util.*;
import java.sql.*;


public class Programa {

    public List<TipoClasificacion> clasificacion;
    private String idPrograma;
    private String nombrePrograma;
    private Dependencia dependencia;
    private Estado estado;
    private TipoApoyo tipoApoyo;
    private PoblacionObjetivo poblacionObjetivo;
    private String montoDeApoyo;
    private String totalBeneficiarios;
    private String totalMunicipios;
    private String observaciones;
    private String anoPrograma;
    private String inversionTotal;
    private String tipoMoneda;
    private String lineaBase;
    private String metaBeneficiarios;
    private String absoluto;
    private String porcentual;
    private String fechaModificacion;


    public Programa(ResultSet tr) {
        try {


            this.tipoApoyo = new TipoApoyo();
            this.dependencia = new Dependencia();
            this.estado = new Estado();
            this.poblacionObjetivo = new PoblacionObjetivo();
            this.clasificacion = new ArrayList<TipoClasificacion>();


            int i = 1;

            this.setIdPrograma(tr.getString(i));
            i++;
            this.setNombrePrograma(tr.getString(i));
            i++;

            this.dependencia.setIdDependencia(tr.getString(i));
            i++;
            this.dependencia.setNombreDependencia(tr.getString(i));
            i++;

            this.estado.setIdEstado(tr.getString(i));
            i++;
            this.estado.setNombreEstado(tr.getString(i));
            i++;
            this.estado.setLatitud(tr.getString(i));
            i++;
            this.estado.setLongitud(tr.getString(i));
            i++;


            this.tipoApoyo.setIdTipoApoyo(tr.getString(i));
            i++;
            this.tipoApoyo.setNombreTipoApoyo(tr.getString(i));
            i++;


            StringTokenizer idClasificacion = new StringTokenizer(tr.getString(i), ",");
            i++;
            StringTokenizer nombreClasificacion = new StringTokenizer(tr.getString(i), ",");
            i++;

            while (idClasificacion.hasMoreElements() && nombreClasificacion.hasMoreElements()) {
                TipoClasificacion tipoClasificacion = new TipoClasificacion(idClasificacion.nextToken(), nombreClasificacion.nextToken());
                this.clasificacion.add(tipoClasificacion);
            }


            this.poblacionObjetivo.setIdPoblacion(tr.getString(i));
            i++;
            this.poblacionObjetivo.setNombrePoblacionObjetivo(tr.getString(i));
            i++;

            this.setMontoDeApoyo(tr.getString(i));
            i++;


            this.setTotalBeneficiarios(tr.getString(i));
            i++;
            this.setTotalMunicipios(tr.getString(i));
            i++;


            this.setObservaciones(tr.getString(i));
            i++;
            this.setAnoPrograma(tr.getString(i));
            i++;
            this.setInversionTotal(tr.getString(i));
            i++;
            this.setTipoMoneda(tr.getString(i));
            i++;
            this.setLineaBase(tr.getString(i));
            i++;
            this.setMetaBeneficiarios(tr.getString(i));
            i++;
            this.setAbsoluto(tr.getString(i));
            i++;
            this.setPorcentual(tr.getString(i));
            i++;
            this.setFechaModificacion(tr.getString(i));
            i++;


        } catch (SQLException sqle) {
            System.out.println(sqle);

        }
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
     * @return the nombrePrograma
     */
    public String getNombrePrograma() {
        return nombrePrograma;
    }

    /**
     * @param nombrePrograma the nombrePrograma to set
     */
    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
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
     * @return the tipoApoyo
     */
    public TipoApoyo getTipoApoyo() {
        return tipoApoyo;
    }

    /**
     * @param tipoApoyo the tipoApoyo to set
     */
    public void setTipoApoyo(TipoApoyo tipoApoyo) {
        this.tipoApoyo = tipoApoyo;
    }

    /**
     * @return the clasificacion
     */
    public List<TipoClasificacion> getClasificacion() {
        return clasificacion;
    }

    /**
     * @param clasificacion the clasificacion to set
     */
    public void setClasificacion(List<TipoClasificacion> clasificacion) {
        this.clasificacion = clasificacion;
    }

    /**
     * @return the montoDeApoyo
     */
    public String getMontoDeApoyo() {
        return montoDeApoyo;
    }

    /**
     * @param montoDeApoyo the montoDeApoyo to set
     */
    public void setMontoDeApoyo(String montoDeApoyo) {
        this.montoDeApoyo = montoDeApoyo;
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
     * @return the totalMunicipios
     */
    public String getTotalMunicipios() {
        return totalMunicipios;
    }

    /**
     * @param totalMunicipios the totalMunicipios to set
     */
    public void setTotalMunicipios(String totalMunicipios) {
        this.totalMunicipios = totalMunicipios;
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
     * @return the anoPrograma
     */
    public String getAnoPrograma() {
        return anoPrograma;
    }

    /**
     * @param anoPrograma the anoPrograma to set
     */
    public void setAnoPrograma(String anoPrograma) {
        this.anoPrograma = anoPrograma;
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
     * @return the tipoMoneda
     */
    public String getTipoMoneda() {
        return tipoMoneda;
    }

    /**
     * @param tipoMoneda the tipoMoneda to set
     */
    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
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
     * @return the fechaModificacion
     */
    public String getFechaModificacion() {
        return fechaModificacion;
    }

    /**
     * @param fechaModificacion the fechaModificacion to set
     */
    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public PoblacionObjetivo getPoblacionObjetivo() {
        return poblacionObjetivo;
    }

    public void setPoblacionObjetivo(PoblacionObjetivo poblacionObjetivo) {
        this.poblacionObjetivo = poblacionObjetivo;
    }
}