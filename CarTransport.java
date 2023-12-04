import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


 class CarTransport extends Car {

    private Ramp ramp;
    private Container<Car> transportedCars;
    private int range = 5;

    CarTransport(double[] position, int capacity) {
        super(position, 2, Color.decode("#da09cd"), 55, "CarTransport");
        ramp = new Ramp();
        ramp.raise();
        transportedCars = new Container<>(capacity, position, range);
    }

    public void move() {
        super.move();
        transportedCars.updatePosition(this.getPosition());
    }

    public double speedFactor() {
        if (this.ramp.getAngle() == 90) {
            return enginePower * 0.02;
        }
        return 0;
    }

    public void raiseRamp() {
        if (getCurrentSpeed() == 0) {
            ramp.raise();
        }
    }

    public void lowerRamp() {
        if (getCurrentSpeed() == 0) {
            ramp.lower();
        }
    }

    public void load(PassengerCar car) {
        if (ramp.getAngle() == 0) {
            transportedCars.load(car);
        }
    }


    public Car unload() {
        if (ramp.getAngle() == 0) {
            int index = transportedCars.numberOfItems();
            double[] unloadPosition = {this.getPosition()[0] + index, this.getPosition()[1]};
            Car last = transportedCars.unload(index);
            last.setPosition(unloadPosition);
            return last;
        }
        System.out.println("Can't unload car, ramp is not lowered");
        return null;
    }

    public int numberOfItems() {
        return transportedCars.numberOfItems();
    }

}
