import java.awt.*;

public abstract class PassengerCar extends Car {
    /**
     * The constructor of the class
     *
     * @param position
     * @param nrDoors
     * @param color
     * @param enginePower
     * @param modelName
     */
    public PassengerCar(double[] position, int nrDoors, Color color, double enginePower, String modelName) {
        super(position, nrDoors, color, enginePower, modelName);
    }
}
