package knowledge;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Result {

    private Information[] informations;
    private SimpleInformation simpleInformation;
    private BufferedImage phoneImage;

    public Result() {
        try {
            phoneImage = ImageIO.read(new File("smartphone-samsung-s8.jpg"));
            simpleInformation = new SimpleInformation("Samsung", "S8", "RM1999");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public SimpleInformation getSimpleInformation() {
        return simpleInformation;
    }

    public BufferedImage getBufferedImage() {
        return phoneImage;
    }

    public Information[] getInformations() {
        return informations;
    }

}
