import javax.swing.*;
import java.awt.*;
/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;

    private int width = 150;


    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col) {
        this.row = row;
        this.col = col;
        //xi = new ImageIcon("Resources/X.png").getImage();

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }

    public void draw(Graphics g, TicTacToeViewer b)
    {
        int x = width + (row * b.BOARD_WIDTH);
        int y = width + (col * b.BOARD_WIDTH);
        g.setColor(Color.black);
        g.drawRect(x, y, b.BOARD_WIDTH, b.BOARD_HEIGHT);

        if(this.isWinningSquare == true)
        {
            g.setColor(Color.green);
            g.fillRect(y, x, b.BOARD_WIDTH, b.BOARD_HEIGHT);
            g.setColor(Color.black);
            if(marker.equals(TicTacToe.X_MARKER))
            {
                g.drawImage(b.getImageX(), y, x, b.BOARD_WIDTH, b.BOARD_HEIGHT, b);
                g.setColor(Color.black);
                g.setFont(new Font("TimesRoman", Font.ITALIC, 100));
                g.drawString("X WINS!", 250, 750);
                g.drawRect(x, y, b.BOARD_WIDTH, b.BOARD_HEIGHT);
            }
            else if(marker.equals(TicTacToe.O_MARKER))
            {
                g.drawImage(b.getImageO(), y, x, b.BOARD_WIDTH, b.BOARD_HEIGHT, b);
                g.setColor(Color.black);
                g.setFont(new Font("TimesRoman", Font.ITALIC, 100));
                g.drawString("O WINS!", 250, 750);
                g.drawRect(x, y, b.BOARD_WIDTH, b.BOARD_HEIGHT);
            }
        }

        else if(marker.equals(TicTacToe.X_MARKER))
        {
            g.drawImage(b.getImageX(), y, x, b.BOARD_WIDTH, b.BOARD_HEIGHT, b);
        }

        else if(marker.equals(TicTacToe.O_MARKER))
        {
            g.drawImage(b.getImageO(), y, x, b.BOARD_WIDTH, b.BOARD_HEIGHT, b);
        }
    }
}
