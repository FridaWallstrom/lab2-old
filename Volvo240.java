import java.awt.*;

/**
 * A subclass of Car
 */
public class Volvo240 extends PassengerCar {

    private double trimFactor = 1.25;

    /**
     * Sets some variables to represent the Volvo240
     *
     * @param position is the position where the car starts
     */
    public Volvo240(double[] position) {
        super(position, 4, Color.black, 100, "Volvo240");
        stopEngine();
    }

    /**
     * Calculates and returns the speedFactor
     *
     * @return speedFactor
     */
    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

}