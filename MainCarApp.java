public class MainCarApp {

    public static void main(String[] args) {
        // Instance of this class
        CarUpdater cc = new CarUpdater();
        cc.addCar(ItemFactory.createVolvo240(new double[] {0,0}));
        cc.addCar(ItemFactory.createSaab95(new double[]{100, 200}));
        cc.addCar(ItemFactory.createCarTransport(new double[]{100, 100}, 5));
        cc.addCar(ItemFactory.createScania(new double[] {200,200}));

        // The frame that represents this instance View of the MVC pattern
        // Start a new view and send a reference of self
        cc.addObserver(new CarView("CarSim 1.0", cc));//ska flyttas till carviews construktor
    }
}
