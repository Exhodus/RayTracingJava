import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowListener;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Window window = new Window();
        window.setSize(1250,900);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Board board = new Board(window);
        window.add(board);



        window.setVisible(true);


    }
}