import java.awt.*;

public class Board {

    private int w, h;

    public Board(int w, int h){
        this.w = w;
        this.h = h;
    }

    public void draw(Graphics2D g2){

        g2.setColor(new Color(98, 137, 64));
        g2.fillRect(0, 0, 600, 650);
        g2.setColor(new Color(84, 116, 54));
        g2.fillRect(0, 0, 650, 70);
        g2.setColor(new Color(179, 214, 101));
        g2.fillRect(35, 95, w, h);
    }
}
