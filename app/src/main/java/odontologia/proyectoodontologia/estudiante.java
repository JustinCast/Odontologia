package odontologia.proyectoodontologia;

/**
 * Created by Justin Cast on 11/3/2017
 */

public  class estudiante {
    private String beca;
    private String primerApellido;
    private String segundoApellido;
    private String nombre;
    private String carne;
    private String carrera;
    private String estadoCivil;
    private String carneCCSS;
    private String fechaNacimiento;
    private String cedula;
    private String direccionFamiliar;
    private String telefono;
    private int pin;

    public estudiante(String carne, int pin) {
        this.carne = carne;
        this.pin = pin;
    }

    public estudiante(String beca, String primerApellido, String segundoApellido, String nombre, String carne, String carrera, String estadoCivil, String carneCCSS, String fechaNacimiento, String cedula, String direccionFamiliar, String telefono, int pin) {
        this.beca = beca;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nombre = nombre;
        this.carne = carne;
        this.carrera = carrera;
        this.estadoCivil = estadoCivil;
        this.carneCCSS = carneCCSS;
        this.fechaNacimiento = fechaNacimiento;
        this.cedula = cedula;
        this.direccionFamiliar = direccionFamiliar;
        this.telefono = telefono;
        this.pin = pin;
    }

    public String getBeca() {
        return beca;
    }

    public void setBeca(String beca) {
        this.beca = beca;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCarneCCSS() {
        return carneCCSS;
    }

    public void setCarneCCSS(String carneCCSS) {
        this.carneCCSS = carneCCSS;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccionFamiliar() {
        return direccionFamiliar;
    }

    public void setDireccionFamiliar(String direccionFamiliar) {
        this.direccionFamiliar = direccionFamiliar;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
