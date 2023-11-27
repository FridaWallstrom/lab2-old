import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

/**
 * This class represents the Controller part in the MVC pattern.
 * Its responsibilities are to listen to the View and responds in an appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    Collection<Car> cars = new ArrayList<>();
    Collection<Saab95> saabs = new ArrayList<>();
    Collection<Scania> scanias = new ArrayList<>();


    static CarController cc = new CarController();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        addCar(new Volvo240(new double[] {0,0}));
        addCar(new Saab95(new double[]{100, 200}));
        addCar(new CarTransport(new double[]{100, 100}, 5));
        addCar(new Scania(new double[] {200,200}));



        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0");

        // Start the timer
        cc.timer.start();
    }

    /**
     * if the @param car is out of bounds it switches the direction to the opposite
     * @param car
     */
    public void stopCarFromGoingOutOfBounds(Car car){
        if (checkIfCarIsOutOfBounds(car)){
            car.stopEngine();
            car.setPosition(new double[] {
                    Math.clamp(car.getPosition()[0], 0.1, 800 - car.image.getWidth()) -0.1,
                    Math.clamp(car.getPosition()[1],0.1, 660 - car.image.getHeight() -0.1)});
            car.direction -= Math.PI;
            car.startEngine();
        }
    }

    /**
     * Checks if a @param car is out of bounds or not
     * @param car
     * @return if the car is out of bounds it returns TRUE and if it is in bounds it returns FALSE
     */
    public boolean checkIfCarIsOutOfBounds(Car car){
        return car.getPosition()[0] > 800 - car.image.getWidth() || car.getPosition()[1] > 660 - car.image.getHeight()
                || car.getPosition()[0] < 0|| car.getPosition()[1] < 0;
    }
    /**
     * Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                stopCarFromGoingOutOfBounds(car);
                car.move();
//                int x = (int) Math.round(car.getPosition()[0]);
//                int y = (int) Math.round(car.getPosition()[1]);
//                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
                frame.setVisible(true);
            }
        }
    }

    static void addCar(Car car) {
        cc.cars.add(car);
    }

    static void addCar(Scania scania) {
        cc.cars.add(scania);
        cc.scanias.add(scania);
    }

    static void addCar(Saab95 saab) {
        cc.cars.add(saab);
        cc.saabs.add(saab);
    }


    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brakeSpeed = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brakeSpeed);
        }
    }

    void startAll() {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    void stopAll() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }

    void turboOn() {
        for (Saab95 car : saabs) {
            car.setTurboOn();
        }
    }

    void turboOff() {
        for (Saab95 car : saabs) {
            car.setTurboOff();
        }
    }

    void scaniaRaiseBed(int angle){
        for (Scania car : scanias){
            car.raiseRamp(angle);
        }
    }

    void scaniaLowerBed(int angle){
        for (Scania car : scanias){
            car.lowerRamp(angle);
        }
    }
}

