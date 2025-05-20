import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Resources {
        // to add an image to the environment:
        // 1. put the file into the res folder.
        // 2. Declare a variable before the static block.
        // 3. Initialize the variable by copying and pasting and modifying the
        //    ImageIO line.

    public static BufferedImage apple;

    static{
        try{
            apple = ImageIO.read(new File("./res/apple.png"));

        }catch(Exception e){e.printStackTrace();}
    }
}
