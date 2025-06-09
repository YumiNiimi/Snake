import java.awt.*;
import java.awt.image.BufferedImage;

public class Apple extends Sprite{

    public static final int SIZE = 25;

    private boolean isApple;
    private int numApples;

    //made apple extend sprite so i could use intersects method
    public Apple(Point location, boolean isApple){

        super(Resources.apple, location, isApple);
        this.isApple = isApple;
    }

    public Rectangle getHitBox(){
        return new Rectangle(getX(), getY(),36, 36);
    }

}
