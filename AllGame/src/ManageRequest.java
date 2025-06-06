import javax.swing.*;
import java.awt.*;

public class ManageRequest extends JDialog {
    public ManageRequest(AllGame app) {
        super(app, "요청 목록", true);
        setSize(300, 150);
        if (app.requestedGames.isEmpty()) {
            JOptionPane.showMessageDialog(app, "요청된 게임이 없습니다.");
            return;
        }

        JComboBox<String> combo = new JComboBox<>(app.requestedGames.toArray(new String[0]));
        JButton add = new JButton("추가");
        JButton deny = new JButton("거부");

        add.addActionListener(e -> {
            String gameName = (String) combo.getSelectedItem();
            Game newGame = new Game(gameName, gameName + "에 대한 소개가 아직 없습니다.", "팁이 아직 등록되지 않았습니다.");
            app.gameList.add(newGame);
            app.requestedGames.remove(gameName);
            dispose();
            JOptionPane.showMessageDialog(app, "추가 완료");
        });

        deny.addActionListener(e -> {
            String game = (String) combo.getSelectedItem();
            app.requestedGames.remove(game);
            dispose();
            JOptionPane.showMessageDialog(app, "거부 완료");
        });

        setLayout(new FlowLayout());
        add(combo); add(add); add(deny);
        setVisible(true);
    }
}
