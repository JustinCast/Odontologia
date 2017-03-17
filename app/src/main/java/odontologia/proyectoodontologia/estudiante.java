package odontologia.proyectoodontologia;

/**
 * Created by Justin Cast on 11/3/2017
 */

public class estudiante {
    private int carne;
    private int pin;

    public estudiante() {}

    public estudiante(int carne, int pin) {
        this.carne = carne;
        this.pin = pin;
    }

    public int getCarne() {return carne;}

    public int getPin() {return pin;}

    public void setCarne(int carne) {this.carne = carne;}

    public void setPin(int pin) {this.pin = pin;}
}
