import java.awt.*;

public class Board {

    private int w, h;
    private int[][] cells;

    public Board(int w, int h){
        this.w = w;
        this.h = h;
        cells = new int[17][15];

        for (int r = 0; r < 17; r++) {
            for (int c = 0; c < 15; c++) {
                if((r % 2 == 0 && c % 2 == 0) || (r % 2 == 1 && c % 2 == 1))
                    cells[r][c] = 0;
                else cells[r][c] = 1;
            }
        }
    }

    public void draw(Graphics2D g2){

        //background
        g2.setColor(new Color(98, 137, 64));
        g2.fillRect(0, 0, 650, 650);

        //top bar
        g2.setColor(new Color(84, 116, 54));
        g2.fillRect(0, 0, 650, 70);

        //grid color
        for (int r = 0; r < 17; r++) {
            for (int c = 0; c < 15; c++) {
                if (cells[r][c] == 0) {
                    g2.setColor(new Color(179, 214, 101));
                    g2.fillRect(r*w + 27, c*w + 97, w, h);
                }
                if(cells[r][c] == 1) {
                    g2.setColor(new Color(164, 199, 94));
                    g2.fillRect(r*w + 27, c*w + 97, w, h);
                }
            }
        }
    }
}
