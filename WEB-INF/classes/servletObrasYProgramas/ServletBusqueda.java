package servletObrasYProgramas;

import javax.servlet.http.*; 		// HttpServletRequest, HttpServletResponse
import com.opensymphony.xwork2.ActionSupport;

import modelObrasYProgramas.*;
import java.util.*;

public class ServletBusqueda extends ActionSupport
{
    public static class Busqueda extends Consulta{
        
        public List<?> lista;
        //public List<Programa> listaProgramas;

        public String execute() throws Exception
        {
            
            if(this.getConsultaProgramas()!=null){
                ProgramasAD programas = new ProgramasAD();
                lista = programas.buscar(this);
            }
            else{
                ObrasAD obras = new ObrasAD();
                lista = obras.buscar(this);
                
            }



            return "resultadoConsulta";
        }
    }
}

