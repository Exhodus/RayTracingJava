import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {

    private Foco foco;
    private Objeto obj;
    private Rayo ray;
    private ArrayList<Rayo> rayos;
    private int[] cubo = new int[4];

    public Board (JFrame ventana){
        super();
        setLayout(null);
        this.setBackground(Color.black);
        foco = new Foco();
        foco.setBounds(100,100,100,100);
        add(foco);

        obj = new Objeto();
        obj.setBounds(500, 250, 500, 250);

        System.out.println(obj.getY() + " " +(obj.getY()+obj.getHeight()));


        add(obj);

        rayos = new ArrayList<>();
        generarRayos(ventana , rayos);



    }

    private void generarRayos(JFrame ventana, ArrayList<Rayo> rayos) {
        int centroX = foco.getX() + foco.getWidth() / 2;
        int centroY = foco.getY() + foco.getHeight() / 2;

        int radio = Math.max(ventana.getWidth(), ventana.getHeight()); // Longitud máxima de los rayos

        int objX = obj.getX();
        int objY = obj.getY();
        int objWidth = obj.getWidth();
        int objHeight = obj.getHeight();

        rayos.clear();

        for (double i = 0; i < 360; i++) {
            double angle = Math.toRadians(i);
            int finalX = (int) (centroX + radio * Math.cos(angle));
            int finalY = (int) (centroY + radio * Math.sin(angle));

            // Calcular intersección con los bordes del objeto
            int intersectX = finalX;
            int intersectY = finalY;

            if (finalX > objX && finalX < objX + objWidth && finalY > objY && finalY < objY + objHeight) {
               if()

            }
            if (intersectX >= objX && intersectX <= objX + objWidth &&
                    intersectY >= objY && intersectY <= objY + objHeight) {
               finalX = intersectX;
               finalY = intersectY;
            }
            rayos.add(new Rayo(centroX, centroY, finalX, finalY));
        }

        repaint();
    }

    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        g.setColor(Color.YELLOW);

        // Dibuja todos los rayos
        for (Rayo rayo : rayos) {
            g.drawLine(rayo.initialX, rayo.initialY, rayo.finalX, rayo.finalY);
        }
    }

    private int calcularAlturaVentana (JFrame ventana, Foco foco){
        int devuelta = 0;
        int finalFoco = foco.getX() + foco.getHeight();
        devuelta = (ventana.getHeight() - 1) - finalFoco;
        return devuelta;
    }


    private int calcularFinalVentana (JFrame ventana, Foco foco){
        int devuelta = 0;
        int finalFoco = foco.getX() + foco.getWidth();
        devuelta = (ventana.getWidth() - 1) - finalFoco;
        return devuelta;
    }
}

