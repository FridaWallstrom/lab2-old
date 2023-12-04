public class Item {
    /**
     * The position of the car
     */
    private double[] position;

    public String name;

    public Item(double[] position, String name) {
        this.position = position;
        this.name = name;
    }

    public double[] getPosition() {
        return position;
    }

    protected void setPosition(double[] position) {
        this.position = position;
    }

    public String getName(){
        return name;
    }

}
