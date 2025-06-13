import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Snake extends Sprite {

    int dir;
    public static final int down = 1, up = 2, left = 3, right = 4;
    private ArrayList<SnakeBodyPart> snakeBody;
    private BufferedImage image;

    public Snake(/*BufferedImage image,*/) {

        //added image bc snake up/down/left/right so eyes change
        super(Resources.snake, new Point(91, 345), false);
        snakeBody = new ArrayList<>();
        for (int i = 0; i < 80; i += 4) {
            snakeBody.add(new SnakeBodyPart(91 + i, 345));
        }
        dir = -1;
    }

    public void draw(Graphics2D g2) {
       // loop to draw all parts in list
        for(SnakeBodyPart p : snakeBody)
            p.draw(g2);


        //trying to get the head to draw over the body
        g2.drawImage(image, snakeBody.getLast().getX(), snakeBody.getLast().getY(), null);


    }

    public void reset(){
        snakeBody.removeAll(snakeBody);
    }


    public void move() {
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

    }


    public void changDir(int dir, int x){
        if(x%9 == 0)
            this.dir = dir;
    }

    public Rectangle getHitBox(){
        return snakeBody.getLast().getHitBox();

    }

    public int getHeadX(){
        return snakeBody.getLast().getX();
    }

    public int getHeadY(){
        return snakeBody.getLast().getY();
    }

    public int getDir(){
        return dir;
    }

    public void grow(){
        for (int i = 0; i < 5; i++) {
            snakeBody.add(0, new SnakeBodyPart(snakeBody.getFirst().getX(), snakeBody.getFirst().getY()));
        }
    }

}
