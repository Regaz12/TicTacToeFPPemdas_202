import javax.swing.*;
import java.awt.*;

public class StatisticsFrame extends JFrame {
    public StatisticsFrame(Player player) {
        setTitle("My Statistics");
        setSize(250, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Username:"));
        panel.add(new JLabel(player.getUsername()));

        panel.add(new JLabel("Wins:"));
        panel.add(new JLabel(String.valueOf(player.getWins())));

        panel.add(new JLabel("Losses:"));
        panel.add(new JLabel(String.valueOf(player.getLosses())));

        panel.add(new JLabel("Draws:"));
        panel.add(new JLabel(String.valueOf(player.getDraws())));

        panel.add(new JLabel("Score:"));
        panel.add(new JLabel(String.valueOf(player.getScore())));

        add(panel);
    }
}
