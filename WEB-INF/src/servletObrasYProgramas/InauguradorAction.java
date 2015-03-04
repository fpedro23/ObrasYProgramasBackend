package servletObrasYProgramas;

import DBManagement.InauguradorDBManager;
import com.opensymphony.xwork2.ActionSupport;
import modelObrasYProgramas.Inaugurador;

/**
 * Created by pedrocontreras on 03/03/15.
 */
public class InauguradorAction extends ActionSupport {
    public class InauguradorActionExtended extends Inaugurador {

        public String createInaugurador() {
            if (InauguradorDBManager.createInaugurador(this)) return "success";
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
