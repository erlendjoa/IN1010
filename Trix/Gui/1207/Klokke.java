import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.LocalTime;

public class Klokke {

    public static String naa() {
        LocalTime t = LocalTime.now();
        return String.format("%02d:%02d:%02d",
        t.getHour(), t.getMinute(), t.getSecond());
    }

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); } 
        catch (Exception e) {System.exit(1); }

        JFrame vindu = new JFrame("Java Klokke");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        vindu.add(panel);

        JButton klokkeKnapp = new JButton(naa());
        panel.add(klokkeKnapp);
        Thread traad = new Thread(new OppdaterTrad(klokkeKnapp));
        traad.start();

        vindu.pack();
        vindu.setLocationRelativeTo(null);
        vindu.setVisible(true);
    }

}