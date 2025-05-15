import javax.swing.*;

public class SnakeMain extends JPanel{

    public SnakeMain(){
        super();

    }

    public static void main(String[] args) {
        JFrame window = new JFrame("");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        window.setBounds(0, 0, 400,  450 + 28); // title bar is 28 pixels!
        JPanel panel = new JPanel();

        panel.setFocusable(true);
        panel.grabFocus();
        window.add(panel);
        window.setVisible(true);
        window.setResizable(false);
    }
}
