package servletObrasYProgramas;

import DBManagement.ObrasAD;
import DBManagement.ProgramasAD;
import com.opensymphony.xwork2.ActionSupport;
import modelObrasYProgramas.Consulta;
import modelObrasYProgramas.ResultadoObra;
import modelObrasYProgramas.ResultadoPrograma;

/**
 * Created by pedrocontreras on 03/03/15.
 * Parametros que recibe el servlet a traves de un HTTP Request
 * idObra;
 * idPrograma;
 * denominacion;
 * tipoDeObra;
 * dependencia;
 * estado;
 * inversionMinima;
 * inversionMaxima;
 * tipoDeInversion;
 * fechaInicio;
 * fechaInicioSegunda;
 * fechaFin;
 * fechaFinSegunda;
 * <p/>
 * impacto;
 * clasificacion;
 * inaugurador;
 * susceptible;
 * inaugurada;
 * consultaProgramas;
 * busquedaRapida;
 * nombrePrograma;
 * anoPrograma;
 * subclasificacion;
 * limiteMin;
 * limiteMax;
 */


public class ServletBusqueda extends ActionSupport {
    public static class Busqueda extends Consulta {

        public ResultadoObra resultadoObra;
        public ResultadoPrograma resultadoPrograma;

        public String execute() throws Exception {

            if (this.getConsultaProgramas() != null) {
                ProgramasAD programas = new ProgramasAD();
                resultadoPrograma = programas.buscar(this);
                return "resultadoConsultaPrograma";
            } else {
                ObrasAD obras = new ObrasAD();
                resultadoObra = obras.buscar(this);
                return "resultadoConsultaObra";
            }
        }
    }
}

