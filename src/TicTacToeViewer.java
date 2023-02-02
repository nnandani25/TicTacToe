import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
public class TicTacToeViewer extends JFrame{
    // TODO: Complete this class

    private TicTacToe t;
    private Image x;
    private Image o;

    private Square s;
    public final int WINDOW_WIDTH = 800;
    public final int WINDOW_HEIGHT = 800;

    public final int BOARD_HEIGHT = 522;
    public final int BOARD_WIDTH = 522;
    public TicTacToeViewer(TicTacToe t)
    {
        this.t = t;
        x = new ImageIcon("Resources/X.png").getImage();
        o = new ImageIcon("Resources/O.png").getImage();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TicTacToe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }
    public void paint(Graphics g)
    {
        //t.getBoard();
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                s = new Square(i,j, this);
                s.draw(g);
            }
        }



    }
}
