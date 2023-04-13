import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sjakkbrett {
    public static void main(String[] args) {
    try { UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); } 
    catch (Exception e) {System.exit(1); }

    JFrame vindu = new JFrame("sjakkbrett");

    vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // Avslutt når bruker trykker på exit knapp.

    JPanel brett = new JPanel();
    vindu.add(brett);

    brett.setLayout(new GridLayout(8,8));
    for (int rx = 8;  rx >= 1;  rx--) {
        for (int kx = 1;  kx <= 8;  kx++) {
            Rute r;
            if ((rx+kx) % 2 == 1) 
                r = new Hvite();
            else
                r = new Sorte();
            r.initGUI();
            brett.add(r);
        }
    }
    vindu.pack();
    vindu.setLocationRelativeTo(null);
    vindu.setVisible(true);
    }


    
}

abstract class Rute extends JLabel {

    void initGUI() {
        setPreferredSize(new Dimension(50,50));
        setOpaque(true);
    }
}

class Hvite extends Rute {
    
    @Override
    void initGUI() {
        super.initGUI();
        setBackground(Color.WHITE);
    }
}

class Sorte extends Rute {

    @Override
    void initGUI() {
        super.initGUI();
        setBackground(Color.BLACK);
    }
}