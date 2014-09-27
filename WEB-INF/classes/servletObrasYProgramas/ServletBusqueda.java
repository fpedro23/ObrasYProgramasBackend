package servletObrasYProgramas;

import javax.servlet.http.*; 		// HttpServletRequest, HttpServletResponse
import com.opensymphony.xwork2.ActionSupport;

import modelObrasYProgramas.*;
import java.util.*;

public class ServletBusqueda extends ActionSupport
{
    public static class Busqueda extends Consulta{
        
        public String execute() throws Exception
        {

            System.out.println(this.toString());

            return "resultadoConsulta";
        }
    }
}

