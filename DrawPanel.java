import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car car : CarUpdater.cc.cars) {
            int x = (int) Math.round(car.getPosition()[0]);
            int y = (int) Math.round(car.getPosition()[1]);
            g.drawImage(ImageHandler.getImage(car), x, y, null); // see javadoc for more info on the parameters
        }
    }
}
