package servletObrasYProgramas;

import javax.servlet.http.*; 		// HttpServletRequest, HttpServletResponse
import com.opensymphony.xwork2.ActionSupport;

import modelObrasYProgramas.*;
import java.util.*;

public class ServletBusqueda extends ActionSupport
{
    public static class Busqueda extends Consulta{
        
        public List<Obra> lista;
        public String execute() throws Exception
        {
            ObrasAD obras = new ObrasAD();

            lista = obras.buscar(this);
            
            System.out.println(this.getClass().getName());
            System.out.println(this.getClass());

             //will return the name (as String) (== "SomeClass")
          //will return the SomeClass' Class object
           // objeto = obras.buscar(this);

            return "resultadoConsulta";
        }
    }
}

