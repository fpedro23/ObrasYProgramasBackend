package servletObrasYProgramas;

import javax.servlet.http.*; 		// HttpServletRequest, HttpServletResponse
import com.opensymphony.xwork2.ActionSupport;

import modelObrasYProgramas.*;
import java.util.*;
public class ServletProgramas extends ActionSupport
{

    
	public List<Programa> listaProgramas;
    private Programa programa;
    

    
	public String execute() throws Exception
	{	
        
        
        ProgramasAD programasAD = new ProgramasAD();
        
     
        listaProgramas = programasAD.consultarProgramas();
        
        return "consultarProgramas";
        
	}
    
}