import java.awt.*;
import java.util.ArrayList;

public class Snake extends Sprite {

    int dir;
    public static final int down = 1, up = 2, left = 3, right = 4;
    private ArrayList<SnakeBodyPart> snakeBody;


    public Snake(Point location) {

        super(Resources.apple, location, false);
        snakeBody = new ArrayList<>();
        for (int i = 0; i < 80; i += 4) {
            snakeBody.add(new SnakeBodyPart(75 + i, 344));
        }
        dir = -1;
    }

    public void draw(Graphics2D g2) {
       // loop to draw all parts in list
        for(SnakeBodyPart p : snakeBody)
            p.draw(g2);
    }


    public void move() {
//        while(snakeBody.size() > 1) {
        if(dir != -1) {
            snakeBody.remove(0);
            SnakeBodyPart head = snakeBody.getLast();
            if (dir == down) {
                snakeBody.add(new SnakeBodyPart(head.getX(), head.getY() + 4));
            }
            if (dir == up) {
                snakeBody.add(new SnakeBodyPart(head.getX(), head.getY() - 4));

            }
            if (dir == left) {
                snakeBody.add(new SnakeBodyPart(head.getX() - 4, head.getY()));
            }
            if (dir == right) {
                snakeBody.add(new SnakeBodyPart(head.getX() + 4, head.getY()));
            }
        }
//        }
    }

    public void changDir(int dir){
        this.dir = dir;
    }

}
