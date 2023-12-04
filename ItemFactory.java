public class ItemFactory {

    public static Saab95 createSaab95(double[] position){
        return new Saab95(position);
    }

    public static Volvo240 createVolvo240(double[] position) {
        return new Volvo240(position);
    }

    public static CarTransport createCarTransport(double[] position, int capacity) {
        return new CarTransport(position, capacity);
    }

    public static Scania createScania(double[] position) {
        return new Scania(position);
    }

    public static Workshop createWorkshop(double[] position,int capacity,int range, String name){
        return new Workshop(position, capacity, range, name);
    }

}
