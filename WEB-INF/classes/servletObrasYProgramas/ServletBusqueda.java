package servletObrasYProgramas;

import javax.servlet.http.*; 		// HttpServletRequest, HttpServletResponse
import com.opensymphony.xwork2.ActionSupport;

import modelObrasYProgramas.*;
import java.util.*;

public class ServletBusqueda extends ActionSupport
{
    public static class Busqueda extends Consulta{
        
        public String objeto;
        public String execute() throws Exception
        {

            objeto = this.toString();

            return "resultadoConsulta";
        }
    }
}

