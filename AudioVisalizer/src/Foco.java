import javax.swing.*;
import java.awt.*;

public class Foco extends JComponent {



    public Foco (){
        super();
        setPreferredSize(new Dimension(100,100  ));
    }



    @Override
    protected  void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.white);
        int diameter = Math.min(getWidth(), getHeight());
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;
        g.fillOval(x,y,diameter,diameter);
    }
}
