public class Item {
    /**
     * The position of the car
     */
    private double[] position;

    public Item(double[] position) {
        this.position = position;
    }

    public double[] getPosition() {
        return position;
    }

    protected void setPosition(double[] position) {
        this.position = position;
    }

}
