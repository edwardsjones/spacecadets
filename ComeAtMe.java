import java.applet.Applet;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

public class ComeAtMe extends JApplet {

    private Font font;
    private Timer timer;

    public void init() {
        font = new Font("Arial", Font.BOLD, 20);
    }

    public void start() {
        final Graphics g = getGraphics();
        timer = new Timer(true);
        timer.scehduleAtFixedRate
    }

    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.blue);
        g.setFont(font);
        g.drawString("Come at me bro.", 20, 30);
    }

}

/* There's only one way I can think of doing this that doesn't blow my mind right now;
use timer to make a task which will change the co ordinates of the text and then repaint
the string every so often. 
*/
