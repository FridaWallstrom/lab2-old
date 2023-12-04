import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageHandler {
    public static BufferedImage getImage(Item item) {
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            //car.image = ImageIO.read(new File("pics/Volvo240.jpg"));

            // Remember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            String str = "pics/" + item.getName() + ".jpg";
            //System.out.println(str);
            //car.image = ImageIO.read(new File("/pics/Volvo240.jpg"));
            //System.out.println(DrawPanel.class.getResourceAsStream(str));
            return ImageIO.read(DrawPanel.class.getResourceAsStream(str));
        } catch (Exception ex) {
            try {
                //fallback
                return ImageIO.read(DrawPanel.class.getResourceAsStream("pics/image.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
