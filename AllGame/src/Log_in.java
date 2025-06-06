import javax.swing.*;
import java.awt.*;

public class Log_in extends JDialog {
    public Log_in(AllGame app) {
        super(app, "로그인", true);
        setSize(300, 150);
        setLayout(new GridLayout(3, 2));

        JTextField id = new JTextField();
        JPasswordField pw = new JPasswordField();

        add(new JLabel("아이디")); add(id);
        add(new JLabel("비밀번호")); add(pw);

        JButton login = new JButton("로그인");
        login.addActionListener(e -> {
            for (Users u : app.usersList) {
                if (u.getId().equals(id.getText()) && u.getPw().equals(new String(pw.getPassword()))) {
                    app.loggedInUser = u;
                    JOptionPane.showMessageDialog(this, "로그인 성공");
                    app.setContentPane(new Main(app));
                    app.revalidate();
                    dispose();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "로그인 실패");
        });

        add(new JLabel()); add(login);
        setVisible(true);
    }
}
