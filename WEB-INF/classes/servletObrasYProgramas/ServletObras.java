package servletObrasYProgramas;

import javax.servlet.http.*; 		// HttpServletRequest, HttpServletResponse
import com.opensymphony.xwork2.ActionSupport;

import modelObrasYProgramas.*;
import java.util.*;
public class ServletObras extends ActionSupport
{
    

    public List<?> lista;
    
    
    
    public Obra obra ;
    private String idObra;
    

    
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
    
    public String consultarPoblacionesObjetivo()throws Exception{
        ObrasAD obrasAD = new ObrasAD();
        lista =  obrasAD.listaDePoblacionesObjetivo();
        return "respuestaListaJson";
    }
    
    public String consultarClasificaciones()throws Exception{
        ObrasAD obrasAD = new ObrasAD();
        lista =  obrasAD.listaDeClasificaciones();
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
    
    
    
    public String generarFichaTecnica() throws Exception
    {
        ObrasAD obrasAD = new ObrasAD();
        obra = obrasAD.generarFichaTecnicaObra(idObra);
        return "fichaTecnicaObras";
        
    }
    
    
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
}