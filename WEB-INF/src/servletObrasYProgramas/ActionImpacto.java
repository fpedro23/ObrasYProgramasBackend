package servletObrasYProgramas;

import DBManagement.ImpactoDBManager;
import com.opensymphony.xwork2.ActionSupport;
import modelObrasYProgramas.Impacto;

/**
 * Created by pedrocontreras on 03/03/15.
 * Parametros que recibe el servlet a traves de un HTTP Request
 * idImpacto;
 * nombreImpacto;
 */
public class ActionImpacto extends ActionSupport {
    public class ActionImpactoExtended extends Impacto {

        public String createImpacto() {
            if (ImpactoDBManager.crearImpacto(this)) return "success";


            return "failure";
        }

        public String updateImpacto() {
            if (ImpactoDBManager.updateImpacto(this)) return "success";
            return "failure";
        }

        public String deleteImpacto() {
            if (ImpactoDBManager.deleteImpacto(this)) return "success";
            return "failure";
        }
    }
}
