package odontologia.proyectoodontologia;


public class Student {
    private static Student instance = null;
    private String carne, pin, beca, nombre, apellido1, apellido2, carrera, estadoCivil, carneCCSS, fechaNacimiento, cedula,
    direccionFamiliar, telefono;

    private Student() {
        this.carne = "";
        this.pin = "";
        this.beca = "";
        this.nombre = "";
        this.apellido1 = "";
        this.apellido2 = "";
        this.carrera = "";
        this.estadoCivil = "";
        this.carneCCSS = "";
        this.fechaNacimiento = "";
        this.cedula = "";
        this.direccionFamiliar = "";
        this.telefono = "";
    }

    public static Student getInstance() {
        if(instance == null) {
            instance = new Student();
        }
        return instance;
    }

    public void FillInformation(String carne, String pin, String beca, String nombre, String apellido1, String apellido2,
                    String carrera, String estadoCivil, String carneCCSS, String fechaNacimiento, String cedula,
                    String direccionFamiliar, String telefono) {
        this.carne = carne;
        this.pin = pin;
        this.beca = beca;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2= apellido2;
        this.carrera = carrera;
        this.estadoCivil = estadoCivil;
        this.carneCCSS = carneCCSS;
        this.fechaNacimiento = fechaNacimiento;
        this.cedula = cedula;
        this.direccionFamiliar = direccionFamiliar;
        this.telefono = telefono;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getBeca() {
        return beca;
    }

    public void setBeca(String beca) {
        this.beca = beca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
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
}
