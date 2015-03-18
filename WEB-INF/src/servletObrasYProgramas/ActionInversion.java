package servletObrasYProgramas;

import DBManagement.TipoDeInversionDBManager;
import com.opensymphony.xwork2.ActionSupport;
import modelObrasYProgramas.TipoInversion;

import java.util.List;

/**
 * Created by pedrocontreras on 03/03/15.
 */
public class ActionInversion extends ActionSupport {
    public static class ActionInversionExtended extends TipoInversion {

        List<TipoInversion> tipoInversionList;

        public String createClasificacion() {
            if (TipoDeInversionDBManager.crearTipoDeInversion(this)) return "success";
            return "failure";
        }

        public String getInversionById() {
            tipoInversionList = TipoDeInversionDBManager.getInversionById(this);
            if (tipoInversionList != null) return "success";
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
