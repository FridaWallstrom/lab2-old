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

public class CarUpdater {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    Timer timer = new Timer(delay, new TimerListener());

    // A list of cars, modify if needed
    Collection<Car> cars = new ArrayList<>();
    Collection<HasTurbo> saabs = new ArrayList<>();
    Collection<HasBed> scanias = new ArrayList<>();


    //static CarUpdater cc = new CarUpdater();

    private Collection<UpdateObserver> observers = new ArrayList<>();
    //methods:


    public CarUpdater(){
        timer.start();
    }

    /**
     * if the @param car is out of bounds it switches the direction to the opposite
     * @param car
     */
    public void stopCarFromGoingOutOfBounds(Car car){
        if (checkIfCarIsOutOfBounds(car)){
            car.stopEngine();
            car.setPosition(new double[] {
                    Math.clamp(car.getPosition()[0], 0.1, 800 - ImageHandler.getImage(car).getWidth()) -0.1,
                    Math.clamp(car.getPosition()[1],0.1, 660 - ImageHandler.getImage(car).getHeight() -0.1)});
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
        return car.getPosition()[0] > 800 - ImageHandler.getImage(car).getWidth() || car.getPosition()[1] > 660 - ImageHandler.getImage(car).getHeight()
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

                for (UpdateObserver observer:observers){
                    observer.actOnTickUpdate();
                }
            }
        }
    }
    public void addObserver(UpdateObserver observer){
        observers.add(observer);
    }


    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCar(Scania scania) {
        cars.add(scania);
        scanias.add(scania);
    }

    public void addCar(Saab95 saab) {
        cars.add(saab);
        saabs.add(saab);
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
        for (HasTurbo car : saabs) {
            car.setTurboOn();
        }
    }

    void turboOff() {
        for (HasTurbo car : saabs) {
            car.setTurboOff();
        }
    }

    void scaniaRaiseBed(int angle){
        for (HasBed car : scanias){
            car.raiseRamp(angle);
        }
    }

    void scaniaLowerBed(int angle){
        for (HasBed car : scanias){
            car.lowerRamp(angle);
        }
    }
}

