package odontologia.proyectoodontologia;

/**
 * Created by Justin Cast on 11/3/2017
 */

public  class estudiante {
    private String ape1;
    private String ape2;
    private String nombre;
    private String carne;
    private String carrera;
    private String estadoCivil;
    private String carneCCSS;
    private String fechaNacimiento;
    private String cedula;
    //private String direccionFamiliar;
    private String telefono;
    private String sexo;
    private int pin, becado, edad, residente;

    public estudiante(String carne, int pin) {
        this.carne = carne;
        this.pin = pin;
    }

    public estudiante(String carne, int pin, String cedula, String nombre, String ape1, String ape2, String carneCCSS,
                      String telefono, String carrera, int becado, String sexo, int residente, int edad, String estadoCivil,
                      String fechaNacimiento) {
        this.becado = becado;
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.nombre = nombre;
        this.carne = carne;
        this.carrera = carrera;
        this.estadoCivil = estadoCivil;
        this.carneCCSS = carneCCSS;
        this.fechaNacimiento = fechaNacimiento;
        this.cedula = cedula;
        this.telefono = telefono;
        this.pin = pin;
        this.edad = edad;
        this.sexo = sexo;
        this.residente = residente;
    }

    public int getBecado() {
        return becado;
    }

    public void setBecado(int becado) {
        this.becado = becado;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
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

   /* public String getDireccionFamiliar() {
        return direccionFamiliar;
    }

    public void setDireccionFamiliar(String direccionFamiliar) {
        this.direccionFamiliar = direccionFamiliar;
    }*/

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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getResidente() {
        return residente;
    }

    public void setResidente(int residente) {
        this.residente = residente;
    }
}
