package servletObrasYProgramas;

import javax.servlet.http.*; 		// HttpServletRequest, HttpServletResponse
import com.opensymphony.xwork2.ActionSupport;

import modelObrasYProgramas.*;
import java.util.*;
public class ServletProgramas extends ActionSupport
{

	public List<Programa> listaProgramas;
    private Programa programa;
    private String idPrograma;

	public String execute() throws Exception
	{
        
        ProgramasAD programasAD = new ProgramasAD();
        listaProgramas = programasAD.consultarProgramas();        
        return "consultarProgramas";
        
	}
    
    public String consultaProgramasEspecifica()throws Exception
    {
        ProgramasAD programasAD = new ProgramasAD();
        listaProgramas = programasAD.consultarProgramasEspecifico(idPrograma);
        return "consultarProgramas";


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
    
}