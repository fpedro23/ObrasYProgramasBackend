package servletObrasYProgramas;

import DBManagement.ClasificacionDBManager;
import com.opensymphony.xwork2.ActionSupport;
import modelObrasYProgramas.TipoClasificacion;

/**
 * Created by pedrocontreras on 03/03/15.
 * Parametros que recibe el servlet a traves de un HTTP Request
 * idTipoClasificacion;
 * nombreTipoClasificacion;
 * clasificacionCorta;
 */
public class ActionClasificacion extends ActionSupport {
    public static class ActionClasificacionExtended extends TipoClasificacion {

        public String createClasificacion() {
            if (ClasificacionDBManager.crearClasificacion(this)) return "success";
            return "failure";
        }

        public String updateClasificacion() {
            if (ClasificacionDBManager.updateClasificacion(this)) return "success";
            return "failure";
        }

        public String deleteClasificacion() {
            if (ClasificacionDBManager.deleteClasificacion(this)) return "success";
            return "failure";
        }


    }
}
