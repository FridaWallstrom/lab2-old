import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        for (Car car : CarController.cc.cars) {
            try {
                // You can remove the "pics" part if running outside of IntelliJ and
                // everything is in the same main folder.
                //car.image = ImageIO.read(new File("pics/Volvo240.jpg"));

                // Remember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
                // if you are starting in IntelliJ.
                String str = "pics/" + car.getModelName() + ".jpg";
                //System.out.println(str);
                //car.image = ImageIO.read(new File("/pics/Volvo240.jpg"));
                //System.out.println(DrawPanel.class.getResourceAsStream(str));
                car.image = ImageIO.read(DrawPanel.class.getResourceAsStream(str));
                System.out.println(car.image);

            } catch (Exception ex) {
                try {
                    car.image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/image.png"));
                } catch (IOException e) {
                   e.printStackTrace();
                }
            }
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car car : CarController.cc.cars) {
            int x = (int) Math.round(car.getPosition()[0]);
            int y = (int) Math.round(car.getPosition()[1]);
            g.drawImage(car.image, x, y, null); // see javadoc for more info on the parameters
        }
    }
}
