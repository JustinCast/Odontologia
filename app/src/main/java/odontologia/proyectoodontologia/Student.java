package odontologia.proyectoodontologia;


@SuppressWarnings("WeakerAccess")
public class Student {
    private static Student ourInstance;
    private static String carne, pin, beca, nombre, apellido1, apellido2, carrera, estadoCivil, carneCCSS, fechaNacimiento, cedula,
    direccionFamiliar, telefono;
    public static Student getInstance() {
        if(ourInstance == null) {
            ourInstance = new Student(carne, pin, beca, nombre, apellido1,  apellido2,
                     carrera,  estadoCivil,  carneCCSS,  fechaNacimiento,  cedula,
                     direccionFamiliar, telefono);
            return ourInstance;
        }
        else
            return ourInstance;
    }

    public Student(String carne, String pin, String beca, String nombre, String apellido1, String apellido2,
                    String carrera, String estadoCivil, String carneCCSS, String fechaNacimiento, String cedula,
                    String direccionFamiliar, String telefono) {
        Student.carne = carne;
        Student.pin = pin;
        Student.beca = beca;
        Student.nombre = nombre;
        Student.apellido1 = apellido1;
        Student.apellido2= apellido2;
        Student.carrera = carrera;
        Student.estadoCivil = estadoCivil;
        Student.carneCCSS = carneCCSS;
        Student.fechaNacimiento = fechaNacimiento;
        Student.cedula = cedula;
        Student.direccionFamiliar = direccionFamiliar;
        Student.telefono = telefono;
    }

    public static String getCarne(){
        return Student.carne;
    }
}
