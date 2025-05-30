import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class SnakeMain extends JPanel{


    public static final int WIDTH=600, HEIGHT=600;

    private Timer timer;

    private Snake snake;
    private ArrayList<Snake> snakeBody;
    private ArrayList<Apple> apples;

    private int lives;
    private int n;

    private Board board;



    public SnakeMain(int w, int h){
        setSize(w, h);
        this.n = 0;
        this.lives = 3;

        board = new Board(35, 35);
        snake = new Snake(new Point(1, 1));
        snakeBody = new ArrayList<>();

            //how to add a new snake
            //sprites.add(new Turtle(Resources.turtle, new Point(410, 118), -3));
            //adding a snake
            //snake = new Sprite(Resources.snake, new Point(280, 568));

        timer = new Timer(1000/60, e->update());
//        timer.start();
        setupKeyListener();
    }

        // called every frame (60 times per second by default) by the timer
    public void update(){
            // update any time-based changes here
//        for(Sprite sprite: snakeBody) {
//                sprite.move();
//        }
        int dx = 0;
        if(keys[KeyEvent.VK_A] || keys[KeyEvent.VK_LEFT])
            dx = -1;
        if(keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT])
            dx = 1;
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

        for(Sprite sprite : snakeBody)
            sprite.draw(g2);

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
            if(key == KeyEvent.VK_W || key == KeyEvent.VK_UP)
                snake.changDir(2);
            if(key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN)
                snake.changDir(1);
            if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT)
                snake.changDir(3);
            if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT)
                snake.changDir(4);
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
