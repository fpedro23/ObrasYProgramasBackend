package servletObrasYProgramas;

import javax.servlet.http.*; 		// HttpServletRequest, HttpServletResponse
import com.opensymphony.xwork2.ActionSupport;

import modelObrasYProgramas.*;
import java.util.*;
public class ServletObras extends ActionSupport
{
    
	public List<Programa> listaProgramas;
    public Obra obra ;
    private String idObra;
    

    
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