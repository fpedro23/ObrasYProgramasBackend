package servletObrasYProgramas;

import com.opensymphony.xwork2.ActionSupport;
import modelObrasYProgramas.ObrasAD;

import java.util.List;

public class ServletConsultasGenerales extends ActionSupport
{
    

    public List<?> lista;
    private String clasificacion;

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String consultarEstados()throws Exception{
        ObrasAD obrasAD = new ObrasAD();
        lista =  obrasAD.listaDeEstados();
        return "respuestaListaJson";
    }
    
    public String consultarImpactos()throws Exception{
        ObrasAD obrasAD = new ObrasAD();
        lista =  obrasAD.listaDeImpactos();
        return "respuestaListaJson";
    }
    
    public String consultarInauguradores()throws Exception{
        ObrasAD obrasAD = new ObrasAD();
        lista =  obrasAD.listaDeInauguradores();
        return "respuestaListaJson";
    }
    

    
    public String consultarClasificaciones()throws Exception{
        ObrasAD obrasAD = new ObrasAD();
        lista =  obrasAD.listaDeClasificaciones();
        return "respuestaListaJson";
    }

    public String consultarSubclasificacion() throws Exception {
        ObrasAD obrasAD = new ObrasAD();
        lista = obrasAD.listaDeSubClasificaciones(this.clasificacion);
        return "respuestaListaJson";
    }
    
    public String consultarInversiones()throws Exception{
        ObrasAD obrasAD = new ObrasAD();
        lista =  obrasAD.listaDeInversiones();
        return "respuestaListaJson";
    }
    
    public String consultarTiposDeObra()throws Exception{
        ObrasAD obrasAD = new ObrasAD();
        lista =  obrasAD.listaDeObras();
        return "respuestaListaJson";
    }
    
    
    public String consultarDependencias()throws Exception{
        ObrasAD obrasAD = new ObrasAD();
        lista =  obrasAD.listaDeDependencias();
        return "respuestaListaJson";
    }
    

}