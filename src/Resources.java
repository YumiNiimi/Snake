import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Resources {
        // to add an image to the environment:
        // 1. put the file into the res folder.
        // 2. Declare a variable before the static block.
        // 3. Initialize the variable by copying and pasting and modifying the
        //    ImageIO line.

    public static BufferedImage apple, snake;

    static{
        try{
            apple = ImageIO.read(new File("./res/apple.png"));

            //added a snake image so it can have a hitbox for intersects method
            snake = ImageIO.read(new File("./res/snake.png"));

        }catch(Exception e){e.printStackTrace();}
    }
}
