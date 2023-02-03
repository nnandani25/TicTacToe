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
    private final int SQUARE_WIDTH = 180;
    private int width = 130;


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

    // Draws a single square and takes in a TicTacToeViewer object in order to have access to the images.
    public void draw(Graphics g, TicTacToeViewer b)
    {
        // Gets the x and y coordinates of the square.
        int y = width + (row * SQUARE_WIDTH);
        int x = width + (col * SQUARE_WIDTH);

        // Sets the color to black and draws the square.
        g.setColor(Color.black);
        g.drawRect(x, y, SQUARE_WIDTH, SQUARE_WIDTH);

        // If the square is a winning square, it turns the background green and prints who wins.
        if(this.isWinningSquare == true)
        {
            // Turns the background of the winning squares green.
            g.setColor(Color.green);
            g.fillRect(x, y, SQUARE_WIDTH, SQUARE_WIDTH);
            g.setColor(Color.black);

            // Checks if the winner is X and if so it redraws the X's on top of the green background.
            // Prints that X wins.
            if(marker.equals(TicTacToe.X_MARKER))
            {
                g.drawImage(b.getImages()[0], x, y, SQUARE_WIDTH, SQUARE_WIDTH, b);
                g.setColor(Color.black);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
                g.drawString("X WINS!", (SQUARE_WIDTH + 30), 750);
                g.drawRect(x, y, SQUARE_WIDTH, SQUARE_WIDTH);
            }

            // Checks if the winner is O and if so it redraws the O's on top of the green background.
            // Prints that O wins.
            else if(marker.equals(TicTacToe.O_MARKER))
            {
                g.drawImage(b.getImages()[1], x, y, SQUARE_WIDTH, SQUARE_WIDTH, b);
                g.setColor(Color.black);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
                g.drawString("O WINS!", (SQUARE_WIDTH + 30), 750);
                g.drawRect(x, y, SQUARE_WIDTH, SQUARE_WIDTH);
            }
        }

        // If the square isn't a winning square, it checks if the square is an X and if it is, it draws
        // The X image.
        else if(marker.equals(TicTacToe.X_MARKER))
        {
            g.drawImage(b.getImages()[0], x, y, SQUARE_WIDTH, SQUARE_WIDTH, b);
        }

        // Checks if the square is an O and if it is, it draws the O image.
        else if(marker.equals(TicTacToe.O_MARKER))
        {
            g.drawImage(b.getImages()[1], x, y, SQUARE_WIDTH, SQUARE_WIDTH, b);
        }
    }
}
