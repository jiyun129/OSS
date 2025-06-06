import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main extends JPanel {
    public Main(AllGame app) {
        setLayout(new BorderLayout());

        JPanel top = new JPanel(new BorderLayout());
        JButton profileBtn = new JButton("프로필");
        top.add(profileBtn, BorderLayout.EAST);
        profileBtn.addActionListener(e -> new ProfileMenu(app).show(profileBtn, 0, profileBtn.getHeight()));
        add(top, BorderLayout.NORTH);

        Random random = new Random();
        Game randomGame = app.gameList.get(random.nextInt(app.gameList.size()));
        JLabel recomGame = new JLabel("오늘의 추천 게임은: " + randomGame.getName(), JLabel.CENTER);
        recomGame.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        add(recomGame, BorderLayout.CENTER);

        JPanel bottom = new JPanel();
        JButton catalogBtn = new JButton("게임 카탈로그");
        catalogBtn.setPreferredSize(new Dimension(250, 60));
        catalogBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        bottom.add(catalogBtn);
        catalogBtn.addActionListener(e -> {
            app.setContentPane(new GameCategory(app));
            app.revalidate();
            app.repaint();
        });
        add(bottom, BorderLayout.SOUTH);
    }
}
