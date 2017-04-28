package odontologia.proyectoodontologia;

/**
 * Created by Bryan on 7/4/2017.
 */

public class Enfermedad {
    private String Enfermedad, descripcion, tratamiento;
    private int idEnfermedad;

    public Enfermedad(String enfermedad, String descripcion, String tratamiento, int idEnfermedad) {
        Enfermedad = enfermedad;
        this.descripcion = descripcion;
        this.tratamiento = tratamiento;
        this.idEnfermedad = idEnfermedad;
    }

    public String getEnfermedad() {
        return Enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        Enfermedad = enfermedad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public int getIdEnfermedad() {
        return idEnfermedad;
    }

    public void setIdEnfermedad(int idEnfermedad) {
        this.idEnfermedad = idEnfermedad;
    }
}
