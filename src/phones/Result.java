package phones;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Result {

    private BufferedImage phoneImage;
    private MobilePhone mp;
    public String brand;
    public String phoneName;
    public String price;

    public Result(MobilePhone mp) {
        try {
            phoneImage = ImageIO.read(new File(mp.getImage()));
            brand = mp.getBrand();
            phoneName = mp.getName();
            price = mp.getPrice();
            this.mp = mp;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public BufferedImage getBufferedImage() {
        return phoneImage;
    }

    public MobilePhone getMP(){
        return mp;
    }
    
}
