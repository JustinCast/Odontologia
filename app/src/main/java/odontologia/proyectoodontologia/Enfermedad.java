package odontologia.proyectoodontologia;

public class Enfermedad {
    private String Enfermedad, descripcion, tratamiento;
    private int idEnfermedad;

    public Enfermedad(int idEnfermedad, String enfermedad, String descripcion, String tratamiento) {
        this.Enfermedad = enfermedad;
        this.descripcion = descripcion;
        this.tratamiento = tratamiento;
        this.idEnfermedad = idEnfermedad;
    }

    public String getEnfermedad() {
        return this.Enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.Enfermedad = enfermedad;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTratamiento() {
        return this.tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public int getIdEnfermedad() {
        return this.idEnfermedad;
    }

    public void setIdEnfermedad(int idEnfermedad) {
        this.idEnfermedad = idEnfermedad;
    }
}
