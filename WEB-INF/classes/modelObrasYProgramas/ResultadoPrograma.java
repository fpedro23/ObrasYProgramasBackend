package modelObrasYProgramas;

import java.util.HashMap;
import java.util.List;

public class ResultadoPrograma
{
    private List<Programa> listaProgramas;
    private HashMap<String, List<ReporteDependencia>> hashMapReporteDependencia;
    private HashMap<String, List<ReporteEstado>> hashMapReporteEstado;
    private HashMap<String, List<ReporteGeneral>> hashMapReporteGeneral;


    public List<Programa> getListaProgramas() {
        return listaProgramas;
    }


    public void setListaProgramas(List<Programa> listaProgramas) {
        this.listaProgramas = listaProgramas;
    }


    public HashMap<String, List<ReporteDependencia>> getHashMapReporteDependencia() {
        return hashMapReporteDependencia;
    }

    public void setHashMapReporteDependencia(HashMap<String, List<ReporteDependencia>> hashMapReporteDependencia) {
        this.hashMapReporteDependencia = hashMapReporteDependencia;
    }


    public HashMap<String, List<ReporteEstado>> getHashMapReporteEstado() {
        return hashMapReporteEstado;
    }

    public void setHashMapReporteEstado(HashMap<String, List<ReporteEstado>> hashMapReporteEstado) {
        this.hashMapReporteEstado = hashMapReporteEstado;
    }

    public HashMap<String, List<ReporteGeneral>> getHashMapReporteGeneral() {
        return hashMapReporteGeneral;
    }

    public void setHashMapReporteGeneral(HashMap<String, List<ReporteGeneral>> hashMapReporteGeneral) {
        this.hashMapReporteGeneral = hashMapReporteGeneral;
    }
}