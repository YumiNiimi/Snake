import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class SnakeMain extends JPanel{

    private Timer timer;

    private Snake snake;

    private ArrayList<Apple> apples;

    private int framecounter;

    private Board board;

    private boolean dead;

    private boolean[] keys;


    public SnakeMain(int w, int h){
        setSize(w, h);

        framecounter = 0;

        board = new Board(36, 36);

        snake = new Snake(/*Resources.snake,*/);

        apples = new ArrayList<>();
        apples.add(0, new Apple(new Point(13*36+20, 7*36+90), true));

        dead = false;

        timer = new Timer(1000/60, e->update());
        timer.start();

        setupKeyListener();
    }


    public void update(){
        framecounter++;

        if (snake.getHitBox().intersects(apples.get(0).getHitBox())) {
            snake.grow();
            apples.remove(0);
            apples.add(new Apple((new Point((int) (Math.random() * 17) * 36 + 20, ((int) (Math.random() * 15)) * 36 + 90)), true));
        }

        if(keys[KeyEvent.VK_W] || keys[KeyEvent.VK_UP])
            snake.changDir(2, framecounter);
        if(keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN])
            snake.changDir(1, framecounter);
        if(keys[KeyEvent.VK_A] || keys[KeyEvent.VK_LEFT])
            snake.changDir(3, framecounter);
        if(keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT])
            snake.changDir(4, framecounter);

        snake.move();

        if(snake.getHeadX() < 15){
            if(snake.getDir() == 3)
                dead = true;
        }
        if(snake.getHeadX() > 605) {
            if(snake.getDir() == 4)
                dead = true;
        }
        if(snake.getHeadY() < 87){
            if(snake.getDir() == 2)
                dead = true;
        }
        if(snake.getHeadY() > 603) {
            if(snake.getDir() == 1)
                dead = true;
        }

        if(dead) {
            snake.reset();
            snake = new Snake(/*Resources.snake,*/);
        }

        repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Georgia", Font.PLAIN, 80));

        board.draw(g2);

        for(Apple a : apples)
            a.draw(g2);

        snake.draw(g2);

        g2.drawImage(Resources.snake, snake.getX()*36+20, snake.getY()*36+90, null);
        }


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
