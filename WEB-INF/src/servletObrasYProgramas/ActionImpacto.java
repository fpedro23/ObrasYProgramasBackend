package servletObrasYProgramas;

import DBManagement.ImpactoDBManager;
import com.opensymphony.xwork2.ActionSupport;
import modelObrasYProgramas.Impacto;

import java.util.List;

/**
 * Created by pedrocontreras on 03/03/15.
 * Parametros que recibe el servlet a traves de un HTTP Request
 * idImpacto;
 * nombreImpacto;
 */
public class ActionImpacto extends ActionSupport {
    public static class ActionImpactoExtended extends Impacto {

        List<Impacto> impactoList;

        public String createImpacto() {
            if (ImpactoDBManager.crearImpacto(this)) return "success";
            else
                return "failure";
        }

        public String getImpactoById() {
            impactoList = ImpactoDBManager.getImpactoById(this);
            if (impactoList != null) return "success";
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
