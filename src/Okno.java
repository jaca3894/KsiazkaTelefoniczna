import javax.swing.*;
import java.awt.*;

public class Okno
{
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
            JPanel tlo = new JPanel();
            tlo.setBackground(Color.gray);
            tlo.setVisible(true);
            add(tlo);
            //----------------------------------------------
            JPanel kontakt1 = new JPanel();
            kontakt1.setBounds(100,50, 600,100);
            kontakt1.setBackground(Color.yellow);
            kontakt1.setVisible(true);
            //----------------------------------------------
            JLabel label = new JLabel("kontakt nr: 1", SwingConstants.CENTER);
            label.setVisible(true);
            label.setBounds(350,50,100,10);
            add(label);
            add(kontakt1);
            JLabel label2 = new JLabel("kontakt nr: 2", SwingConstants.CENTER);
            label2.setVisible(true);
            label2.setBounds(350,200,100,10);
            add(label2);
            JLabel label3 = new JLabel("kontakt nr: 3", SwingConstants.CENTER);
            label3.setVisible(true);
            label3.setBounds(350,350,100,10);
            add(label3);

            // y: +150
            //----------------------------------------------
            JPanel kontakt2 = new JPanel();
            kontakt2.setBounds(100,200,600,100);
            kontakt2.setBackground(Color.red);
            kontakt2.setVisible(true);
            add(kontakt2);
            //----------------------------------------------
            JPanel kontakt3 = new JPanel();
            kontakt3.setBounds(100,350,600,100);
            kontakt3.setBackground(Color.gray);
            kontakt3.setVisible(true);
            add(kontakt3);
            //----------------------------------------------
            JPanel kontakt4 = new JPanel();
            kontakt4.setBounds(100,500,600,100);
            kontakt4.setBackground(Color.yellow);
            kontakt4.setVisible(true);
            add(kontakt4);

            //----------------------------------------------

        }
    }
}
