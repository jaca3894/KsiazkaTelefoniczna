import javax.swing.*;
import java.awt.*;

public class Okno
{
    public static class panelKontaktu extends JPanel
    {
        panelKontaktu(int height, JFrame frame, Color color, String index, String name)
        {
            setBounds(100, height, 600,100);
            setVisible(true);
            setBackground(color);

            Box box = Box.createVerticalBox();

            JLabel index1 = new JLabel(index);
            index1.setVisible(true);
            box.add(index1);
            this.add(Box.createVerticalStrut(90));

            JLabel name1 = new JLabel(name);
            name1.setVisible(true);
            box.add(name1);
            this.add(Box.createVerticalStrut(50));
            this.add(box);

            frame.add(this);
            frame.pack();
        }
    }
    public static class MyFrame extends JFrame {
        public MyFrame() {
            super("Tytuł okna");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            setSize(800, 800);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (dim.width - getWidth()) / 2;
            int y = (dim.height - getHeight()) / 2;
            setLocation(x, y);

            new panelKontaktu(100, this, Color.gray, "1", "artur");
            new panelKontaktu(300, this, Color.green, "2", "marcin");
            new panelKontaktu(500, this, Color.yellow, "3", "andrzej");
            new panelKontaktu(700, this, Color.red, "4", "wiktoria");

            add(new Label());
        }
    }
}
