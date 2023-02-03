import javax.swing.*;
import java.awt.*;
public class TicTacToeViewer extends JFrame
{
    // TODO: Complete this class
    private TicTacToe t;
    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 800;
    private final int ALL_SQUARE_WIDTH = 540;
    private final int SQUARE_WIDTH = 180;
    private Image[] images;
    private Square[][] sq;
    public TicTacToeViewer(TicTacToe t)
    {
        // Initializes the TicTacToe object.
        this.t = t;

        // Initializes the Image array and fills it with the x and o images.
        images = new Image[2];
        images[0] = new ImageIcon("Resources/X.png").getImage();
        images[1] = new ImageIcon("Resources/O.png").getImage();

        // Sets up the windows: close operation, title, size, and visibility.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TicTacToe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    // Paints the grid and is overrided because there is already a default paint method.
    @Override
    public void paint(Graphics g)
    {
        // Gets the width of the space between the window and the board and adds the length of half of
        // A square in order for reach the center of the first square.
        int x = ((WINDOW_WIDTH - ALL_SQUARE_WIDTH)/2) + SQUARE_WIDTH/2;

        // Gets the width of the blank space at the top and subtracts 20, so the numbers can be placed
        // Above the board's line.
        int y = ((WINDOW_WIDTH - ALL_SQUARE_WIDTH)/2) - 20;

        // Sets the square 2D array to the board array from the TicTacToe class.
        sq = t.getBoard();

        // Traverses the 2D board array.
        for(int i = 0; i < sq.length; i++)
        {
            // Sets the font and prints the numbers on the side of the board.
            g.setFont(new Font("TimesRoman", Font.ITALIC, 40));
            g.setColor(Color.red);
            g.drawString(""+i, x, y);

            // Does y-20, because the columns have slightly different dimensions than the rows.
            g.drawString(""+i, y - 20, x);

            // Increases x by the width of each individual square each time so the numbers are above
            // Each square.
            x += SQUARE_WIDTH;

            // Continues to traverse through the array and draws each individual square.
            for(int j = 0; j < sq[0].length; j++)
            {
                g.setColor(Color.black);
                sq[i][j].draw(g, this);
            }
        }

        // Checks if there is a tie and if there is prints it.
        if(t.checkTie())
        {
            g.setColor(Color.black);
            g.setFont(new Font("TimesRoman", Font.ITALIC, 100));
            g.drawString("IT'S A TIE!", SQUARE_WIDTH, (WINDOW_WIDTH - 50));
        }

    }

    // Returns the image 2D array.
    public Image[] getImages()
    {
        return images;
    }

}

