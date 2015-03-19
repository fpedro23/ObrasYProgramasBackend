package servletObrasYProgramas;

import DBManagement.*;
import com.opensymphony.xwork2.ActionSupport;
import modelObrasYProgramas.Consulta;
import modelObrasYProgramas.Obra;
import modelObrasYProgramas.ResultadoObra;

import java.util.List;

/**
 * Created by Alejandro on 03/03/15.
 * Parametros que recibe el servlet a traves de un HTTP Request
 * idTipoClasificacion;
 * nombreTipoClasificacion;
 * clasificacionCorta;
 */


public class ActionObras extends ActionSupport {
    public static class ActionObrasExtended extends Obra {
        public List<?> listaEstados;
        public List<?> listaDependencias;
        public ResultadoObra resultadoObra;

        public String obtenCatalogos(){
            listaEstados = EstadosDBManager.listaDeEstados();
            listaDependencias = DependenciaDBManager.listaDeDependencias();
            return "success";
        }

    }
    public static class ActionObrasConsultaExtended extends Consulta {
        public List<?> listaEstados;
        public List<?> listaDependencias;
        public List<?> listaTiposObra;
        public ResultadoObra resultadoObra;

        public String obtenCatalogos(){
            listaEstados = EstadosDBManager.listaDeEstados();
            listaDependencias = DependenciaDBManager.listaDeDependencias();
            listaTiposObra = TipoDeObraDBManager.listaDeObras();
            ObrasAD obras = new ObrasAD();
            resultadoObra = obras.buscar(this);
            return "success";
        }

    }
}
