package knowledge;

import classes.MobilePhone;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Result {

    private Information[] informations;
    private SimpleInformation simpleInformation;
    private BufferedImage phoneImage;
    private MobilePhone mp;

    public Result(MobilePhone mp) {
        try {
            phoneImage = ImageIO.read(new File(mp.getImage()));
            simpleInformation = new SimpleInformation(mp.getBrand(), mp.getName(), mp.getPrice());
            this.mp = mp;
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
    
    public MobilePhone getMP(){
        return mp;
    }
    
}
