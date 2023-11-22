import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;
import java.security.InvalidParameterException;

/**
 * A class defining a basic car model with speed and direction on a 2d plane.
 */
abstract public class Car extends Item implements Movable {
    /**
     * The number of doors on the car
     */
    private final int nrDoors;
    /**
     * The engine power of the car
     */
    protected final double enginePower;
    /**
     * The current speed of the car
     */
    private double currentSpeed;
    /**
     * The color of the car
     */
    private Color color;
    /**
     * The car model name
     */
    private final String modelName;

    /**
     * The direction of the car
     */
    protected double direction;


    BufferedImage image;


    /**
     * The constructor of the class
     */
    public Car(double[] position, int nrDoors, Color color, double enginePower, String modelName) {
        super(position);
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
    }

    /**
     * Getters:
     */

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public String getModelName() {
        return modelName;
    }

    /**
     * Setters:
     */
    protected void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }


    public void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * Returns the speedFactor of a car.
     * Can use enginePower
     *
     * @return Returns the speedFactor
     */
    abstract public double speedFactor();

    /**
     * Returns a new speed by taking the old speed and
     * increasing(addition) it by amount relative to the speedFactor
     *
     * @param amount the amount which the speed should increase
     * @return returns the new total speed
     */
    protected double incrementSpeed(double amount) {
        return getCurrentSpeed() + speedFactor() * amount;
    }

    /**
     * Returns a new speed by taking the old speed and
     * decreasing(subtraction) it by amount relative to the speedFactor
     *
     * @param amount the amount which the speed should decrease
     * @return returns the new total speed
     */
    protected double decrementSpeed(double amount) {
        return getCurrentSpeed() - speedFactor() * amount;
    }

    /**
     * Increases the speed of the car
     *
     * @param amount should be in the range [0,1] or exception is thrown
     */
    public void gas(double amount) {
        if (amount >= 0 && amount <= 1) {
            currentSpeed = Math.min(incrementSpeed(amount), enginePower);
        } else {
            throw new InvalidParameterException();
        }
    }

    /**
     * Decreases the speed of the car
     *
     * @param amount should be in the range [0,1] or exception is thrown
     */
    public void brake(double amount) {
        if (amount >= 0 && amount <= 1) {
            currentSpeed = Math.max(decrementSpeed(amount), 0);
        } else {
            throw new InvalidParameterException();
        }
    }

    /**
     * Changes the position of the car with
     */
    public void move() {
        getPosition()[0] += currentSpeed * Math.cos(direction);
        getPosition()[1] += currentSpeed * Math.sin(direction);
    }


    /**
     * Changes the direction of the car
     */
    public void turnLeft() {
        direction += Math.PI / 2;
    }

    /**
     * Changes the direction of the car
     */
    public void turnRight() {
        direction -= Math.PI / 2;
    }
}

