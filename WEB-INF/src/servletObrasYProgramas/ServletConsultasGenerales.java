package servletObrasYProgramas;

import DBManagement.*;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created by pedrocontreras on 03/03/15.
 * Parametros que recibe el servlet a traves de un HTTP Request
 * NINGUNO
 * Objetos que regresa el servlet "Lista" genérica de la consulta
 */

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

        lista = EstadosDBManager.listaDeEstados();
        return "respuestaListaJson";
    }
    
    public String consultarImpactos()throws Exception{
        lista = ImpactoDBManager.listaDeImpactos();
        return "respuestaListaJson";
    }
    
    public String consultarInauguradores()throws Exception{
        lista = InauguradorDBManager.listaDeInauguradores();
        return "respuestaListaJson";
    }

    public String consultarClasificaciones()throws Exception{

        lista = ClasificacionDBManager.listaDeClasificaciones();
        return "respuestaListaJson";
    }

    public String consultarSubclasificacion() throws Exception {
        lista = SubclasificacionDBManager.listaDeSubClasificaciones(this.clasificacion);
        return "respuestaListaJson";
    }
    
    public String consultarInversiones()throws Exception{
        lista = TipoDeInversionDBManager.listaDeInversiones();
        return "respuestaListaJson";
    }
    
    public String consultarTiposDeObra()throws Exception{
        lista = TipoDeObraDBManager.listaDeObras();
        return "respuestaListaJson";
    }
    
    
    public String consultarDependencias()throws Exception{
        lista = DependenciaDBManager.listaDeDependencias();
        return "respuestaListaJson";
    }
    

}