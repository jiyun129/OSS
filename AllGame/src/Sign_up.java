import javax.swing.*;
import java.awt.*;

public class Sign_up extends JDialog {
    public Sign_up(AllGame app) {
        super(app, "회원가입", true);
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));

        JTextField id = new JTextField();
        JPasswordField pw = new JPasswordField();
        JTextField nickname = new JTextField();

        add(new JLabel("아이디")); add(id);
        add(new JLabel("비밀번호")); add(pw);
        add(new JLabel("닉네임")); add(nickname);

        JButton signup = new JButton("가입하기");
        signup.addActionListener(e -> {
            if (id.getText().isBlank() || pw.getPassword().length == 0 || nickname.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, "다시 입력해주세요");
                return;
            }
            app.usersList.add(new Users(id.getText(), new String(pw.getPassword()), nickname.getText()));
            JOptionPane.showMessageDialog(this, "회원가입 완료");
            dispose();
        });

        add(new JLabel()); add(signup);
        setVisible(true);
    }
}
