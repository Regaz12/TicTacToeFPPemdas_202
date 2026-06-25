import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private Player currentPlayer;
    private PlayerService playerService;
    private GameLogic gameLogic;
    private JButton[] buttons;

    public GameFrame(Player player) {
        this.currentPlayer = player;
        this.playerService = new PlayerService();
        this.gameLogic = new GameLogic();

        setTitle("Tic-Tac-Toe Game");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 3));
        buttons = new JButton[9];

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 60));
            buttons[i].setFocusPainted(false);
            final int index = i;
            buttons[i].addActionListener(e -> handlePlayerMove(index));
            panel.add(buttons[i]);
        }

        add(panel, BorderLayout.CENTER);
        
        JButton btnBack = new JButton("Back to Main Menu");
        btnBack.addActionListener(e -> {
            MainMenuFrame menuFrame = new MainMenuFrame(currentPlayer);
            menuFrame.setVisible(true);
            this.dispose();
        });
        add(btnBack, BorderLayout.SOUTH);
    }

    private void handlePlayerMove(int index) {
        if (gameLogic.makeMove(index, 'X')) {
            buttons[index].setText("X");

            if (gameLogic.checkWinner('X')) {
                finishGame("WIN");
                return;
            }

            if (gameLogic.isDraw()) {
                finishGame("DRAW");
                return;
            }

            // Computer move
            int compIndex = gameLogic.computerMove();
            if (compIndex != -1) {
                gameLogic.makeMove(compIndex, 'O');
                buttons[compIndex].setText("O");

                if (gameLogic.checkWinner('O')) {
                    finishGame("LOSE");
                    return;
                }
                
                if (gameLogic.isDraw()) {
                    finishGame("DRAW");
                }
            }
        }
    }

    private void finishGame(String result) {
        playerService.updateStatistics(currentPlayer, result);
        JOptionPane.showMessageDialog(this, "Game result: " + result);

        MainMenuFrame menuFrame = new MainMenuFrame(currentPlayer);
        menuFrame.setVisible(true);
        this.dispose();
    }
}
