import javax.swing.*;
import java.awt.*;

public class Review extends JPanel {
    public Review(AllGame app, Game game) {
        setLayout(new BorderLayout());

        JPanel top = new JPanel(new BorderLayout());
        JButton back = new JButton("<-");
        back.setPreferredSize(new Dimension(60, 30));
        JLabel title = new JLabel(game.getName(), JLabel.CENTER);
        title.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        top.add(back, BorderLayout.WEST);
        top.add(title, BorderLayout.CENTER);
        add(top, BorderLayout.NORTH);

        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        if (game.getReviewList().isEmpty()) {
            center.add(new JLabel("아직 리뷰가 없습니다."));
        } else {
            for (String r : game.getReviewList()) {
                JTextArea area = new JTextArea(r);
                area.setLineWrap(true);
                area.setWrapStyleWord(true);
                area.setEditable(false);
                area.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                area.setBackground(new Color(245, 245, 245));
                area.setMaximumSize(new Dimension(300, 80));
                center.add(area);
                center.add(Box.createVerticalStrut(10));
            }
        }

        JScrollPane scrollPane = new JScrollPane(center);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);

        if (app.loggedInUser != null) {
            JPanel bottom = new JPanel(new BorderLayout());
            JTextField reviewInput = new JTextField();
            JButton submit = new JButton("리뷰 등록");
            submit.addActionListener(e -> {
                String review = reviewInput.getText().trim();
                if (!review.isEmpty()) {
                    game.addReview(app.loggedInUser.getNickname() + ": " + review);
                    app.setContentPane(new Review(app, game));
                    app.revalidate();
                }
            });
            bottom.add(reviewInput, BorderLayout.CENTER);
            bottom.add(submit, BorderLayout.EAST);
            add(bottom, BorderLayout.SOUTH);
        }

        back.addActionListener(e -> {
            app.setContentPane(new GameInfo(app, game));
            app.revalidate();
            app.repaint();
        });

    }
}
