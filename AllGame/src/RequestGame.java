import javax.swing.*;

public class RequestGame {
    public RequestGame(AllGame app) {
        String game = JOptionPane.showInputDialog(app, "요청할 게임 이름은?");
        if (game == null || game.isBlank()) return;
        boolean exists = app.gameList.stream().anyMatch(g -> g.getName().equals(game));
        if (exists) {
            JOptionPane.showMessageDialog(app, game + " 게임은 이미 있습니다!");
        } else {
            app.requestedGames.add(game);
            JOptionPane.showMessageDialog(app, "요청 완료");
        }
    }
}
