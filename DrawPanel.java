import java.awt.*;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    Iterable<? extends Item> itemsToDraw;
    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, Collection<? extends Item> items) { //generic typ kräver wildcard (om subtypspolymorfism)
        this.itemsToDraw = items;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Item item : itemsToDraw) {
            int x = (int) Math.round(item.getPosition()[0]);
            int y = (int) Math.round(item.getPosition()[1]);
            g.drawImage(ImageHandler.getImage(item), x, y, null); // see javadoc for more info on the parameters
        }
    }
}
