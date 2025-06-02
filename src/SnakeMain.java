import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class SnakeMain extends JPanel{


    public static final int WIDTH=600, HEIGHT=600;

    private Timer timer;

    private Snake snake;
    private ArrayList<Apple> apples;

    private int lives;
    private int n;

    private int framecounter;
    private Board board;



    public SnakeMain(int w, int h){
        setSize(w, h);
        n = 0;
        lives = 3;
        framecounter = 0;
        board = new Board(36, 36);
        snake = new Snake(new Point(1, 1));

            //how to add a new snake
            //sprites.add(new Turtle(Resources.turtle, new Point(410, 118), -3));
            //adding a snake
            //snake = new Sprite(Resources.snake, new Point(280, 568));

        timer = new Timer(1000/60, e->update());
        timer.start();
        setupKeyListener();
    }

        // called every frame (60 times per second by default) by the timer
    public void update(){
        framecounter++;
        // update any time-based changes here
//        for(Sprite sprite: snakeBody) {
//                sprite.move();
//        }

        boolean dead = false;

    //if the snake hits itself
//        if(snake.intersects(snake)) {
//            dead = true;
//        }

            //if the snake hits the wall
//        if (snake.getX() < 5 || snake.getX() > 595) {
//            dead = true;
//            //snake.setImage(Resources.snake);
//            snake.setX(280);
//            snake.setY(568);
//        }

        if(keys[KeyEvent.VK_W] || keys[KeyEvent.VK_UP])
            snake.changDir(2, framecounter);
        if(keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN])
            snake.changDir(1, framecounter);
        if(keys[KeyEvent.VK_A] || keys[KeyEvent.VK_LEFT])
            snake.changDir(3, framecounter);
        if(keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT])
            snake.changDir(4, framecounter);
        snake.move();
        repaint();
    }

        @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
            // all drawing happens here.
            // Best practice is to NOT change the state of any instance fields
            // so the graphics can update at any time
        g2.setColor(Color.BLACK);

//        for(Sprite sprite : snakeBody)
//            sprite.draw(g2);

        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Georgia", Font.PLAIN, 80));

        if(lives <= 0) {
            g2.drawString("GAME OVER", 60, 320);
        }
        if(n == 5) {
            g2.drawString("YOU WIN", 110, 300);
        }
        board.draw(g2);
        snake.draw(g2);

        }

    private boolean[] keys;

    public void setupKeyListener(){
        keys = new boolean[255];
        addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            keys[key] = true;

        }
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            keys[key] = false;
        }
        });
        }


    public static void main(String[] args) {
        JFrame window = new JFrame("");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        window.setBounds(420, 0, 650,  650 + 28); // title bar is 28 pixels!
        JPanel panel = new SnakeMain(650, 650);

        panel.setFocusable(true);
        panel.grabFocus();
        window.add(panel);
        window.setVisible(true);
        window.setResizable(false);
    }
}
