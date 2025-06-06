import javax.swing.*;

public class ProfileMenu extends JPopupMenu {
    public ProfileMenu(AllGame app) {
        if (app.loggedInUser == null) {
            JMenuItem signup = new JMenuItem("회원가입");
            signup.addActionListener(e -> new Sign_up(app));
            JMenuItem login = new JMenuItem("로그인");
            login.addActionListener(e -> new Log_in(app));
            add(signup); add(login);
        } else {
            if ("manager".equals(app.loggedInUser.getId())) {
                JMenuItem manage = new JMenuItem("요청 목록");
                manage.addActionListener(e -> new ManageRequest(app));
                add(manage);
            } else {
                JMenuItem request = new JMenuItem("게임 정보 요청");
                request.addActionListener(e -> new RequestGame(app));
                add(request);
            }
            JMenuItem logout = new JMenuItem("로그아웃");
            logout.addActionListener(e -> {
                app.loggedInUser = null;
                JOptionPane.showMessageDialog(app, "로그아웃 되었습니다.");
                app.setContentPane(new Main(app));
                app.revalidate();
            });
            add(logout);
        }
    }
}
