package servletObrasYProgramas;

import DBManagement.TipoDeInversionDBManager;
import com.opensymphony.xwork2.ActionSupport;
import modelObrasYProgramas.TipoInversion;

/**
 * Created by pedrocontreras on 03/03/15.
 * Parametros que recibe el servlet a traves de un HTTP Request
 * idTipoClasificacion;
 * nombreTipoClasificacion;
 * clasificacionCorta;
 */
public class ActionInversion extends ActionSupport {
    public static class ActionInversionExtended extends TipoInversion {

        public String createClasificacion() {
            if (TipoDeInversionDBManager.crearTipoDeInversion(this)) return "success";
            return "failure";
        }

        public String updateClasificacion() {
            if (TipoDeInversionDBManager.updateInversion(this)) return "success";
            return "failure";
        }

        public String deleteClasificacion() {
            if (TipoDeInversionDBManager.deleteInversion(this)) return "success";
            return "failure";
        }


    }
}
