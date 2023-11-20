import java.awt.*;

/**
 * A subclass of Car
 */
public class Saab95 extends PassengerCar {

    /**
     * State of turbo(on/off)
     */
    private boolean turboOn;

    /**
     * Sets some variables to represent the Saab95
     * and sets the speed to 0
     *
     * @param position is the position where the car starts
     */
    public Saab95(double[] position) {
        super(position, 2, Color.red, 125, "Saab95");
        turboOn = false;
        stopEngine();
    }

    /**
     * Sets the turbo to true
     */
    public void setTurboOn() {
        turboOn = true;
    }

    /**
     * Sets the turbo to false
     */
    public void setTurboOff() {
        turboOn = false;
    }


    /**
     * Calculates and returns the speedFactor
     *
     * @return speedFactor
     */
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}