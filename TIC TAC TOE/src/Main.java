import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args){
        // Making a Window
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TicTacToe game = new TicTacToe();

        frame.add(game);

        frame.setVisible(true);
    }
}
