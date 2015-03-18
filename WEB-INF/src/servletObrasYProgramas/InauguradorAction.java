package servletObrasYProgramas;

import DBManagement.InauguradorDBManager;
import com.opensymphony.xwork2.ActionSupport;
import modelObrasYProgramas.Inaugurador;

import java.util.List;

/**
 * Created by pedrocontreras on 03/03/15.
 * Parametros que recibe el servlet a traves de un HTTP Request
 * idCargoInaugura
 * nombreCargoInaugura
 */
public class InauguradorAction extends ActionSupport {
    public static class InauguradorActionExtended extends Inaugurador {

        public List<Inaugurador> inauguradorList;

        public String createInaugurador() {
            if (InauguradorDBManager.createInaugurador(this)) return "success";
            return "failure";
        }

        public String getInauguradorById() {
            inauguradorList = InauguradorDBManager.getInauguradorById(this);
            if (inauguradorList != null) return "success";
            return "failure";
        }

        public String updateInaugurador() {
            if (InauguradorDBManager.updateInaugurador(this)) return "success";
            return "failure";
        }

        public String deleteInaugurador() {
            if (InauguradorDBManager.deleteInaugurador(this)) return "success";
            return "failure";
        }
    }
}
