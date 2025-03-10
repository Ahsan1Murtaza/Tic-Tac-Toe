import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JPanel {
    public int[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    JButton board[] = new JButton[9];
    JPanel panel = new JPanel();
    JLabel label = new JLabel();
    public boolean isCross = true;
    public int turn = isCross ? 1 : -1;

    public TicTacToe(){

        this.setLayout(new BorderLayout());

        label.setText("Tic Tac Toe  (Turn : X)");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));

        panel.setLayout(new GridLayout(3, 3));
        panel.setPreferredSize(new Dimension(400, 400));

        panel.setBackground(Color.BLACK);

        this.add(label, BorderLayout.NORTH);
        gamePlay();
        this.add(panel);

    }


    public boolean isValid(int i){
        return arr[i] == 0;
    }

    public void switchTurn(){
        isCross = !isCross;
        turn = isCross ? 1 : -1;
        label.setText("Tic Tac Toe  (Turn : " + (turn == 1 ? "X )" : "O )"));
    }

    public void show(){
        for (int i = 0; i < 9; i++){
            if (arr[i] == 1){
                board[i].setFont(new Font("Arial", Font.BOLD, 40));
                board[i].setText("X");
            }
            else if (arr[i] == -1) {
                board[i].setFont(new Font("Arial", Font.BOLD, 40));
                board[i].setText("O");
            }
        }
    }

    public boolean isWin(){
        // Checking for X
        if ((arr[0] == 1 && arr[1] == 1 && arr[2] == 1) || (arr[0] == 1 && arr[3] == 1 && arr[6] == 1) || (arr[6] == 1 && arr[7] == 1 && arr[8] == 1) || (arr[6] == 1 && arr[4] == 1 && arr[2] == 1) || (arr[2] == 1 && arr[5] == 1 && arr[8] == 1)|| (arr[0] == 1 && arr[4] == 1 && arr[8] == 1) || (arr[1] == 1 && arr[4] == 1 && arr[7] == 1)){
            JOptionPane.showMessageDialog(null, "X wins!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        // Checking for O
        else if ((arr[0] == -1 && arr[1] == -1 && arr[2] == -1) || (arr[0] == -1 && arr[3] == -1 && arr[6] == -1) || (arr[6] == -1 && arr[7] == -1 && arr[8] == -1) || (arr[6] == -1 && arr[4] == -1 && arr[2] == -1) || (arr[2] == -1 && arr[5] == -1 && arr[8] == -1)|| (arr[0] == -1 && arr[4] == -1 && arr[8] == -1) || (arr[1] == -1 && arr[4] == -1 && arr[7] == -1)) {
            JOptionPane.showMessageDialog(null, "O wins!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        return false;
    }

    public boolean isDraw(){
        boolean zeroFound = false;
        for (int i = 1; i < 9; i++){
            if (arr[i] == 0){
                zeroFound = true;
            }
        }
        return !zeroFound;
    }

    public void gamePlay(){

        for (int i = 0; i < 9; i++){
            JButton tile = new JButton();
            board[i] = tile;
            panel.add(tile);


            tile.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton clickedTile = (JButton) e.getSource();
                    for (int i = 0; i < 9; i++){
                        if (board[i] == clickedTile){
                            if (isValid(i)){
                                arr[i] = turn;
                                switchTurn();
                                show();
                                if (isWin()){
                                    for (int j = 0; j < 9; j++){
                                        board[j].setEnabled(false);
                                    }
                                    System.out.println("Game Finished");
                                    break;
                                }
                                if (isDraw()){
                                    for (int j = 0; j < 9; j++){
                                        board[j].setEnabled(false);
                                    }
                                    System.out.println("Game Draw");
                                    break;
                                }
                            }
                        }
                    }
                }
            });

        }
    }
}
