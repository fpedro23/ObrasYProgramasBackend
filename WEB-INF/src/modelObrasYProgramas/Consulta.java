package modelObrasYProgramas;

public class Consulta
{
    private String idObra;
    private String idPrograma;
    private String denominacion;
    private String tipoDeObra;
    private String dependencia;
    private String estado;
    private String inversionMinima;
    private String inversionMaxima;
    private String tipoDeInversion;
    private String fechaInicio;
    private String fechaInicioSegunda;
    private String fechaFin;
    private String fechaFinSegunda;

    private String impacto;
    private String clasificacion;
    private String inaugurador;
    private String susceptible;
    private String inaugurada;
    private String consultaProgramas;
    private String busquedaRapida;
    private String nombrePrograma;
    private String anoPrograma;
    private String subclasificacion;


    private int limiteMin;
    private int limiteMax;


    public String getInaugurada(){
        return inaugurada;
    }
    
    
    public void setInaugurada(String inaugurada){
         this.inaugurada = inaugurada;
    }
    
    public String getTipoDeObra() {
        return tipoDeObra;
    }
    public void setTipoDeObra(String tipoDeObra) {
        this.tipoDeObra = tipoDeObra;
    }
    public String getDependencia() {
        return dependencia;
    }
    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getInversionMinima() {
        return inversionMinima;
    }
    public void setInversionMinima(String inversionMinima) {
        this.inversionMinima = inversionMinima;
    }
    public String getInversionMaxima() {
        return inversionMaxima;
    }
    public void setInversionMaxima(String inversionMaxima) {
        this.inversionMaxima = inversionMaxima;
    }
    public String getTipoDeInversion() {
        return tipoDeInversion;
    }
    public void setTipoDeInversion(String tipoDeInversion) {
        this.tipoDeInversion = tipoDeInversion;
    }
    public String getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public String getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    public String getImpacto() {
        return impacto;
    }
    public void setImpacto(String impacto) {
        this.impacto = impacto;
    }
    public String getClasificacion() {
        return clasificacion;
    }
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
    public String getInaugurador() {
        return inaugurador;
    }
    public void setInaugurador(String inaugurador) {
        this.inaugurador = inaugurador;
    }
    public String getSusceptible() {
        return susceptible;
    }
    public void setSusceptible(String susceptible) {
        this.susceptible = susceptible;
    }

    public String getSubclasificacion() {
        return subclasificacion;
    }

    public void setSubclasificacion(String subclasificacion) {
        this.subclasificacion = subclasificacion;
    }

    public String getConsultaProgramas() {
        return consultaProgramas;
    }
    
    public void setConsultaProgramas(String consultaProgramas) {
        this.consultaProgramas = consultaProgramas;
    }


    public int getLimiteMin() {
        return limiteMin;
    }

    public void setLimiteMin(int limiteMin) {
        this.limiteMin = limiteMin;
    }

    public int getLimiteMax() {
        return limiteMax;
    }

    public void setLimiteMax(int limiteMax) {
        this.limiteMax = limiteMax;
    }

    public String getFechaInicioSegunda() {
        return fechaInicioSegunda;
    }

    public void setFechaInicioSegunda(String fechaInicioSegunda) {
        this.fechaInicioSegunda = fechaInicioSegunda;
    }

    public String getFechaFinSegunda() {
        return fechaFinSegunda;
    }

    public void setFechaFinSegunda(String fechaFinSegunda) {
        this.fechaFinSegunda = fechaFinSegunda;
    }

    public String getIdObra() {
        return idObra;
    }

    public void setIdObra(String idObra) {
        this.idObra = idObra;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getBusquedaRapida() {
        return busquedaRapida;
    }

    public void setBusquedaRapida(String busquedaRapida) {
        this.busquedaRapida = busquedaRapida;
    }

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }

    public String getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(String idPrograma) {
        this.idPrograma = idPrograma;
    }

    public String getAnoPrograma() {
        return anoPrograma;
    }

    public void setAnoPrograma(String anoPrograma) {
        this.anoPrograma = anoPrograma;
    }

    public String toString() {
        return "Consulta [tipoDeObra=" + tipoDeObra + ", dependencia="
        + dependencia + ", estado=" + estado + ", inversionMinima="
        + inversionMinima + ", inversionMaxima=" + inversionMaxima
        + ", tipoDeInversion=" + tipoDeInversion + ", fechaInicio="
        + fechaInicio + ", fechaFin=" + fechaFin + ", impacto="
        + impacto + ", clasificacion=" + clasificacion
        + ", inaugurador=" + inaugurador + ", susceptible=" + susceptible
        + "]";
    }
    
    
    
    
}