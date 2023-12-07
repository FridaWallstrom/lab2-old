public class MainCarApp {

    public static void main(String[] args) {
        // Instance of this class
        CarUpdater cu = new CarUpdater();
        ControlHandler controlHandler = new ControlHandler(cu);
        ControlPanel cp = new ControlPanel(CarView.X, CarView.Y, controlHandler);
        DrawPanel drawPanel = new DrawPanel(CarView.X, CarView.Y - 240, cu.cars);

        cu.addCar(ItemFactory.createVolvo240(new double[] {0,0}));
        cu.addCar(ItemFactory.createSaab95(new double[]{100, 200}));
        cu.addCar(ItemFactory.createCarTransport(new double[]{100, 100}, 5));
        cu.addCar(ItemFactory.createScania(new double[] {200,200}));

        // The frame that represents this instance View of the MVC pattern
        // Start a new view and send a reference of self

        CarView cw = new CarView("CarSim 1.0", cp, drawPanel);
        cu.addObserver(cw);
    }
}
