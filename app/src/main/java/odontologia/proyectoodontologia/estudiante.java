package odontologia.proyectoodontologia;

/**
 * Created by Justin Cast on 11/3/2017
 */

public class estudiante {
    private String carne;
    private int pin;

    public estudiante() {}

    public estudiante(String carne, int pin) {
        this.carne = carne;
        this.pin = pin;
    }

    public String getCarne() {return carne;}

    public int getPin() {return pin;}

    public void setCarne(String carne) {this.carne = carne;}

    public void setPin(int pin) {this.pin = pin;}
}
