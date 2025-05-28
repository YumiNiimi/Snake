import java.awt.*;
import java.awt.image.BufferedImage;

public class Snake extends Sprite {

    int direction;
    public static final int down = 1, up = 2, left = 3, right = 4;

    public Snake(Point location) {
        super(Resources.apple, location, false);
    }

    public void draw(Graphics2D g2) {
        g2.setColor(new Color(80, 144, 225));
        g2.fillRoundRect(200, 325, 50, 25, 15, 15);
    }

    public void move() {

        //if(dir = down)
        //translate / move (0, 4) (4 = speed)
    }

    public void changDir(int direction){
        this.direction = direction;
    }

}
