package odontologia.proyectoodontologia;

/**
 * clase singleton estudiante necesaria para almacecnar la informacion recibida por parte del servidor
 * que hace referencia al usuario ingresado en la aplicacion
 */
public class Student {
    private static Student instance = null;
    private String carne, beca, nombre, apellido1, apellido2, carrera, estadoCivil, carneCCSS, fechaNacimiento, cedula,
    direccionFamiliar, telefono;
    private int pin;
    private Student() {
        this.carne = "";
        this.pin = 0;
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

    /**
     * metodo singleton
     * @return la instacia del estudiante
     */
    public static Student getInstance() {
        if(instance == null) {
            instance = new Student();
        }
        return instance;
    }

    /**
     * metodo que llena al estudiante instanciado, de informacion. para ello utiliza los parametros:
     * @param carne
     * @param pin
     * @param beca
     * @param nombre
     * @param apellido1
     * @param apellido2
     * @param carrera
     * @param estadoCivil
     * @param carneCCSS
     * @param fechaNacimiento
     * @param cedula
     * @param direccionFamiliar
     * @param telefono
     */
    public void FillInformation(String carne, int pin, String beca, String nombre, String apellido1, String apellido2,
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

    /**
     * gets y sets de los atributos del estudiante
     */

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
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
