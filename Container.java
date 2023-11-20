import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Container<T extends Item> {

    /**
     * A list of type T(which needs to extend Item)
     */
    private ArrayList<T> containedItems;
    private int capacity;
    double[] position;

    int range;

    public Container(int capacity, double[] position, int range) {
        this.capacity = capacity;
        containedItems = new ArrayList<T>();
        this.position = position;
        this.range = range;
    }

    /**
     * Adds an item to the container, if it isn't full
     */
    public void load(T item) {
        if (Point2D.distance(position[0], position[1], item.getPosition()[0], item.getPosition()[1]) <= range) {
            if (containedItems.size() < capacity) {
                containedItems.add(item);
                item.setPosition(position);
                return;
            }
        }
        System.out.println("Couldn't add car :(");
    }

    /**
     * Removes an item from the container
     * @param index, the position of which an item should be removed from the container
     * @return returns the removed item
     */
    public T unload(int index) {
        T last = containedItems.get(index - 1);
        containedItems.remove(index - 1);
        return last;
    }

    /**
     * Updates the position of the objects inside the container to a new position
     * @param position the new position
     */
    public void updatePosition(double[] position) {
        for (T item : containedItems) {
            item.setPosition(position);
        }
        this.position = position;
    }

    /**
     * returns the number of items in the container
     * @return the number of items in the container
     */
    public int numberOfItems() {
        return containedItems.size();
    }

}
