package modelObrasYProgramas;
import java.util.*;

public class ResultadoObra
{
    private List<Obra> listaObras;
    private List<ReporteDependencia> listaReporteDependencia;
    private List<ReporteEstado> listaReporteEstado;
    private List<ReporteGeneral> listaReporteGeneral;
    
    
    /**
     * @return the listaObras
     */
    public List<Obra> getListaObras() {
        return listaObras;
    }
    /**
     * @param listaObras the listaObras to set
     */
    public void setListaObras(List<Obra> listaObras) {
        this.listaObras = listaObras;
    }
    
    public List<ReporteDependencia> getListaReporteDependencia() {
        return listaReporteDependencia;
    }
    public void setListaReporteDependencia(
                                           List<ReporteDependencia> listaReporteDependencia) {
        this.listaReporteDependencia = listaReporteDependencia;
    }
    public List<ReporteEstado> getListaReporteEstado() {
        return listaReporteEstado;
    }
    public void setListaReporteEstado(List<ReporteEstado> listaReporteEstado) {
        this.listaReporteEstado = listaReporteEstado;
    }
    public List<ReporteGeneral> getListaReporteGeneral() {
        return listaReporteGeneral;
    }
    public void setListaReporteGeneral(List<ReporteGeneral> listaReporteGeneral) {
        this.listaReporteGeneral = listaReporteGeneral;
    }
    
    
}