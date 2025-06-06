import javax.swing.*;
import java.awt.*;

public class GameInfo extends JPanel {
    public GameInfo(AllGame app, Game game) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel topPanel = new JPanel(new BorderLayout());
        JButton backButton = new JButton("<-");
        backButton.setPreferredSize(new Dimension(60, 30));
        backButton.addActionListener(e -> {
            app.setContentPane(new GameCategory(app));
            app.revalidate();
            app.repaint();
        });
        topPanel.add(backButton, BorderLayout.WEST);
        add(topPanel);

        JLabel titleLabel = new JLabel(game.getName(), JLabel.CENTER);
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(titleLabel);
        add(Box.createVerticalStrut(20));

        JTextArea introArea = new JTextArea(game.getDescription());
        introArea.setEditable(false);
        introArea.setLineWrap(true);
        introArea.setWrapStyleWord(true);
        introArea.setBackground(Color.WHITE);
        introArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        introArea.setPreferredSize(new Dimension(300, 150));
        add(introArea);
        add(Box.createVerticalStrut(20));

        JTextArea tipsArea = new JTextArea("게임 팁:\n" + game.getTips());
        tipsArea.setEditable(false);
        tipsArea.setBackground(new Color(245, 245, 245));
        tipsArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        tipsArea.setPreferredSize(new Dimension(300, 80));
        add(tipsArea);
        add(Box.createVerticalStrut(20));

        JButton reviewButton = new JButton("게임 리뷰");
        reviewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        reviewButton.addActionListener(e -> {
            app.setContentPane(new Review(app, game));
            app.revalidate();
            app.repaint();
        });
        add(reviewButton);
    }
}
