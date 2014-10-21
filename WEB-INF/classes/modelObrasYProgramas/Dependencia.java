package modelObrasYProgramas;

public class Dependencia {
    private String idDependencia;
    private String nombreDependencia;
    private String imagenDependencia;

    /**
     * @return the idDependencia
     */
    public String getIdDependencia() {
        return idDependencia;
    }

    /**
     * @param idDependencia the idDependencia to set
     */
    public void setIdDependencia(String idDependencia) {
        this.idDependencia = idDependencia;
    }

    /**
     * @return the nombreDependencia
     */
    public String getNombreDependencia() {
        return nombreDependencia;
    }

    /**
     * @param nombreDependencia the nombreDependencia to set
     */
    public void setNombreDependencia(String nombreDependencia) {
        this.nombreDependencia = nombreDependencia;
    }

    public String getImagenDependencia() {
        return imagenDependencia;
    }

    public void setImagenDependencia(String imagenDependencia) {
        this.imagenDependencia = imagenDependencia;
    }
}