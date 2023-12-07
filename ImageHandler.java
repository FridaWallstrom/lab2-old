import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

public class ImageHandler {

    static HashMap<String, BufferedImage> imageBuffer = new HashMap<>();
    public static BufferedImage getImage(Item item) {

            if(imageBuffer.get(item.getName()) == null){
                try {
                    String str = "pics/" + item.getName() + ".jpg";
                    imageBuffer.put(item.getName(), ImageIO.read(DrawPanel.class.getResourceAsStream(str)));
                } catch (Exception ex) {
                    try {
                        //fallback
                        imageBuffer.put(item.getName(), ImageIO.read(DrawPanel.class.getResourceAsStream("pics/image.png")));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        return imageBuffer.get(item.getName());
        }
}
