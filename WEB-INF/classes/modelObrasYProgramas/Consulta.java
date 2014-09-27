package modelObrasYProgramas;
import java.util.*;

public class Consulta
{
    
    private String tipoDeObra;
    private String dependencia;
    private String estado;
    private String inversionMinima;
    private String inversionMaxima;
    private String tipoDeInversion;
    private String fechaInicio;
    private String fechaFin;
    private String impacto;
    private String clasificacion;
    private String inaugurada;
    private String susceptible;
    
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
    public String getInaugurada() {
        return inaugurada;
    }
    public void setInaugurada(String inaugurada) {
        this.inaugurada = inaugurada;
    }
    public String getSusceptible() {
        return susceptible;
    }
    public void setSusceptible(String susceptible) {
        this.susceptible = susceptible;
    }
    
    public String toString() {
        return "Consulta [tipoDeObra=" + tipoDeObra + ", dependencia="
        + dependencia + ", estado=" + estado + ", inversionMinima="
        + inversionMinima + ", inversionMaxima=" + inversionMaxima
        + ", tipoDeInversion=" + tipoDeInversion + ", fechaInicio="
        + fechaInicio + ", fechaFin=" + fechaFin + ", impacto="
        + impacto + ", clasificacion=" + clasificacion
        + ", inaugurada=" + inaugurada + ", susceptible=" + susceptible
        + "]";
    }
    
    
    
    
}