package servletObrasYProgramas;

import DBManagement.UsuariosDBManager;
import com.opensymphony.xwork2.ActionSupport;
import modelObrasYProgramas.Usuario;

import java.util.List;

/**
 * Created by pedrocontreras on 03/03/15.
 * Parametros que recibe el servlet a traves de un HTTP Request
 * idTipoClasificacion;
 * nombreTipoClasificacion;
 * clasificacionCorta;
 */
public class ActionUsuario extends ActionSupport {
    public static class ActionUsuarioExtended extends Usuario {

        public List<?> lista;

        public String consultarUsuarios() {
            lista = UsuariosDBManager.listaDeUsuarios();
            if (lista != null) return "respuestaListaJson";
            return "failure";
        }

        public String createUsuario() {
            if (UsuariosDBManager.crearUsuario(this)) return "success";
            return "failure";
        }

        public String updateUsuario() {
            if (UsuariosDBManager.actualizarUsario(this)) return "success";
            return "failure";
        }

        public String deleteUsuario() {
            if (UsuariosDBManager.deleteUsuario(this)) return "success";
            return "failure";
        }


    }
}
