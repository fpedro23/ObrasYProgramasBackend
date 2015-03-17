package modelObrasYProgramas;

public class TipoInversion {
    private String idTipoInversion;
    private String nombreTipoInversion;
    private String nombreTipoInversionCorta;

    public TipoInversion() {
        this.idTipoInversion = null;
        this.nombreTipoInversion = null;
        this.nombreTipoInversionCorta = null;
    }

    public TipoInversion(String idTipoInversion, String nombreTipoInversion, String nombreTipoInversionCorta) {
        this.idTipoInversion = idTipoInversion;
        this.nombreTipoInversion = nombreTipoInversion;
        this.nombreTipoInversionCorta = nombreTipoInversionCorta;
    }

    public String getNombreTipoInversionCorta() {
        return nombreTipoInversionCorta;
    }

    public void setNombreTipoInversionCorta(String nombreTipoInversionCorta) {
        this.nombreTipoInversionCorta = nombreTipoInversionCorta;
    }

    /**
     * @return the idTipoInversion
     */
    public String getIdTipoInversion() {
        return idTipoInversion;
    }

    /**
     * @param idTipoInversion the idTipoInversion to set
     */
    public void setIdTipoInversion(String idTipoInversion) {
        this.idTipoInversion = idTipoInversion;
    }

    /**
     * @return the nombreTipoInversion
     */
    public String getNombreTipoInversion() {
        return nombreTipoInversion;
    }

    /**
     * @param nombreTipoInversion the nombreTipoInversion to set
     */
    public void setNombreTipoInversion(String nombreTipoInversion) {
        this.nombreTipoInversion = nombreTipoInversion;
    }

}