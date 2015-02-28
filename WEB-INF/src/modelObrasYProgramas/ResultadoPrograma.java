package modelObrasYProgramas;

import java.util.List;

public class ResultadoPrograma
{
    private List<Programa> listaProgramas;
    private List<ReporteDependencia> listaReporteDependencia;
    private List<ReporteEstado> listaReporteEstado;
    private List<ReporteGeneral> listaReporteGeneral;


    /**
     * @return the listaProgramas
     */
    public List<Programa> getListaProgramas() {
        return listaProgramas;
    }

    /**
     * @param listaProgramas the listaProgramas to set
     */
    public void setListaProgramas(List<Programa> listaProgramas) {
        this.listaProgramas = listaProgramas;
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