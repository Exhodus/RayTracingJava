import javax.swing.*;
import java.awt.*;

public class Objeto extends JComponent {

    public Objeto(){
        super();
    }
    @Override
    protected  void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        int diameter = Math.min(getWidth(), getHeight());
        int x = (getWidth() - diameter);
        int y = (getHeight() - diameter);
        g.fillRect(x,y,diameter,diameter);
    }
}
