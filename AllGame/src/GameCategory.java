import javax.swing.*;
import java.awt.*;

public class GameCategory extends JPanel {
    public GameCategory(AllGame app) {
        setLayout(new BorderLayout());

        JPanel top = new JPanel(new BorderLayout());
        JButton back = new JButton("<-");
        JButton search = new JButton("검색");
        top.add(back, BorderLayout.WEST);
        top.add(search, BorderLayout.EAST);
        add(top, BorderLayout.NORTH);

        JPanel list = new JPanel();
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));

        for (Game g : app.gameList) {
            JButton b = new JButton(g.getName());
            b.addActionListener(e -> {
                app.setContentPane(new GameInfo(app, g));
                app.revalidate();
                app.repaint();
            });
            list.add(b);
        }

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);

        back.addActionListener(e -> {
            app.setContentPane(new Main(app));
            app.revalidate();
            app.repaint();
        });

        search.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(app, "검색할 게임명:");
            if (name != null && !name.isBlank()) {
                String input = name.trim().replaceAll("\\s+", "").toLowerCase();
                for (Game g : app.gameList) {
                    String gameName = g.getName().replaceAll("\\s+", "").toLowerCase();
                    if (gameName.equals(input)) {
                        app.setContentPane(new GameInfo(app, g));
                        app.revalidate();
                        app.repaint();
                        return;
                    }
                }
                JOptionPane.showMessageDialog(app, name + " 게임은 존재하지 않습니다!");
            }
        });
    }
}
