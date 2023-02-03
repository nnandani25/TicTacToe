import javax.swing.*;
import java.awt.*;
public class TicTacToeViewer extends JFrame{
    // TODO: Complete this class

    private TicTacToe t;
    private Image x;
    private Image o;

    private Square s;
    public final int WINDOW_WIDTH = 800;
    public final int WINDOW_HEIGHT = 800;
    public final int BOARD_HEIGHT = 174;
    public final int BOARD_WIDTH = 174;
    public TicTacToeViewer(TicTacToe t)
    {
        this.t = t;
        x = new ImageIcon("Resources/X.png").getImage();
        o = new ImageIcon("Resources/O.png").getImage();
        //images[1] = new ImageIcon("Resources/O.png").getImage();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TicTacToe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }
    @Override
    public void paint(Graphics g)
    {
        //g.drawString("1", 225, 120);
        g.setFont(new Font("TimesRoman", Font.ITALIC, 40));
        int x = 225;
        int y = 120;
        int y2 = 200;

        Square[][] sq = t.getBoard();
        for(int i = 0; i < sq.length; i++)
        {
            g.setFont(new Font("TimesRoman", Font.ITALIC, 40));
            g.setColor(Color.red);
            g.drawString(""+i, x, y);
            x +=180;
            for(int j = 0; j < sq[0].length; j++)
            {
                g.setColor(Color.black);
                sq[i][j].draw(g, this);
            }
            g.setFont(new Font("TimesRoman", Font.ITALIC, 40));
            g.setColor(Color.red);
            g.drawString(""+i, 120, y2);
            y2+=200;
        }

        if(t.checkTie())
        {
            g.setColor(Color.black);
            g.setFont(new Font("TimesRoman", Font.ITALIC, 100));
            g.drawString("ITS A TIE!", 200, 750);
        }

    }
    public Image getImageX()
    {
        return x;
    }

    public Image getImageO()
    {
        return o;
    }

}

