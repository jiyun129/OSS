import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class AllGame extends JFrame {
    List<Game> gameList = new ArrayList<>();
    List<String> requestedGames = new ArrayList<>();
    List<Users> usersList = new ArrayList<>();
    Users loggedInUser = null;

    public AllGame() {
        setTitle("게임에 모든 것");
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        gameList.add(new Game("발로란트", "전략적 FPS 게임", "에임이 중요함", "정말 재미있어요!", "users1"));
        gameList.add(new Game("마인크래프트", "건축과 생존을 즐기는 샌드박스 게임", "나무 먼저 획득하기", "창의력 키우기에 최고입니다.", "users2"));
        gameList.add(new Game("리그 오브 레전드", "팀 전략 MOBA 게임", "라인전 집중", "화가 나지만 끊을 수 없어요.", "users3"));
        usersList.add(new Users("manager", "manager", "관리자"));

        setContentPane(new Main(this));
        revalidate();
        repaint();

        setVisible(true);
    }

    public static void main(String[] args) {
        new AllGame();
    }
}
