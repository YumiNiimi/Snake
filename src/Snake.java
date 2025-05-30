import java.awt.*;
import java.awt.image.BufferedImage;

public class Snake extends Sprite {

    int dir;
    public static final int down = 1, up = 2, left = 3, right = 4;

    public Snake(Point location) {
        super(Resources.apple, location, false);
    }

    public void draw(Graphics2D g2) {
        g2.setColor(new Color(80, 144, 225));
        g2.fillRoundRect(125, 342, 100, 35, 35, 35);
    }

    public void move() {

        if(dir == down) {
            move(0, 4); //(4 = speed)
        }
        if(dir == up) {
            move(0, -4); //(4 = speed)
        }
        if(dir == left) {
            move(-4, 0); //(4 = speed)
        }
        if(dir == right) {
            move(4, 0); //(4 = speed)
        }
    }

    public void changDir(int dir){
        this.dir = dir;
    }

}
