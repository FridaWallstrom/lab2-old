public class Workshop<T extends Car> extends Item {
    //*

    private Container<T> container;

    /**
     * Creates a workshop with a container
     *
     * @param position the position of the workshop
     * @param capacity the max number of items in the container
     * @param range    the max range between the item anc container during load
     */
    public Workshop(double[] position, int capacity, int range) {
        super(position);
        container = new Container<>(capacity, position, range);
    }

    /**
     * Loads a car into container
     *
     * @param car
     */
    public void load(T car) {
        container.load(car);
    }

    /**
     * unloads a car from a certain index
     *
     * @return
     */
    public T unload(int index) {
        return container.unload(index);
    }

    public int numberOfItems() {
        return container.numberOfItems();
    }
}
