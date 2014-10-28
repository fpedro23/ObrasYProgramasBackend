package modelObrasYProgramas;

/**
 * Created by Pedro on 09/10/14.
 */
public class Subclasificacion {

    private String idSubClasificacion;
    private String idTipoClasificacion;
    private String nombreSubclasificacion;

    public Subclasificacion() {
    }

    public Subclasificacion(String idSubClasificacion, String idTipoClasificacion, String nombreSubclasificacion) {
        this.idSubClasificacion = idSubClasificacion;
        this.idTipoClasificacion = idTipoClasificacion;
        this.nombreSubclasificacion = nombreSubclasificacion;
    }

    public String getNombreSubclasificacion() {
        return nombreSubclasificacion;
    }

    public void setNombreSubclasificacion(String nombreSubclasificacion) {
        this.nombreSubclasificacion = nombreSubclasificacion;
    }

    public String getIdTipoClasificacion() {
        return idTipoClasificacion;
    }

    public void setIdTipoClasificacion(String idTipoClasificacion) {
        this.idTipoClasificacion = idTipoClasificacion;
    }

    public String getIdSubClasificacion() {
        return idSubClasificacion;
    }

    public void setIdSubClasificacion(String idSubClasificacion) {
        this.idSubClasificacion = idSubClasificacion;
    }
}
