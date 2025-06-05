import java.awt.*;

public class SnakeBodyPart {

    private int x, y;

    public SnakeBodyPart(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g2){
        //if straight
        g2.setColor(new Color(80, 144, 225));
        g2.fillRoundRect(x, y, 30, 30, 35, 35);

        //if dir changes

    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle getHitBox() {
        return new Rectangle(x, y, 30, 30);
    }
}
