import java.util.HashMap;

public class ControlHandler {
    CarUpdater cu; //lägg till i uml
    ControlHandler(CarUpdater cu) {
        this.cu = cu;
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cu.cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brakeSpeed = ((double) amount) / 100;
        for (Car car : cu.cars) {
            car.brake(brakeSpeed);
        }
    }

    void startAll() {
        for (Car car : cu.cars) {
            car.startEngine();
        }
    }

    void stopAll() {
        for (Car car : cu.cars) {
            car.stopEngine();
        }
    }


    void turboOn() {
        for (Car car : cu.cars) {
            if (car instanceof HasTurbo) {
                ((HasTurbo) car).setTurboOn(); //castar till en hasturbo

            }
        }
    }

    void turboOff() {
        for (Car car : cu.cars) {
            if (car instanceof HasTurbo) {
                ((HasTurbo) car).setTurboOff();
            }
        }
    }

    void RaiseBed(int angle) {
        for (Car car : cu.cars) {
            if (car instanceof HasBed) {
                ((HasBed) car).raiseRamp(angle);
            }
        }
    }

    void LowerBed(int angle) {
        for (Car car : cu.cars) {
            if (car instanceof HasBed) {
                ((HasBed) car).lowerRamp(angle);
            }
        }
    }
    /**
    Updates view once after removing a car
     */
    void removeCarAndUpdate(){
        if (!cu.cars.isEmpty()) {
            cu.cars.remove(0);
            for (UpdateObserver obs : cu.observers){
                obs.actOnTickUpdate();
            }
        }
    }

    void addCar(){
        HashMap<Integer, String> items = new HashMap<Integer, String>();
        items.put(1, "Scania");
        items.put(2, "Saab95");
        items.put(3, "Volvo240");
        items.put(4, "CarTransport");
        int item = (int)Math.floor(Math.random() * 5 + 1);
        int position = (int)Math.floor(Math.random() * (510) + 1);

        if (cu.cars.size() < 10) {
            if (item == 1)
                cu.cars.add(ItemFactory.createScania(new double[] {position,position}));
            else if (item == 2)
                cu.cars.add(ItemFactory.createSaab95(new double[] {position,position}));
            else if (item == 3)
                cu.cars.add(ItemFactory.createVolvo240(new double[] {position,position}));
            else if (item == 4)
                cu.cars.add(ItemFactory.createCarTransport(new double[] {position,position}, 5));
        }
    }

}
