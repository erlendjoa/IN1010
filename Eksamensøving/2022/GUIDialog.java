import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIDialog implements Dialog {

    JLabel spoersmaal;
    JButton jaButton;
    JButton neiButton;
    String svar;
    Thread hovedtrad = Thread.currentThread();

    public GUIDialog() {
        try { UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); } 
        catch (Exception e) {System.exit(1); }

        JFrame vindu = new JFrame("JA eller NEI");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        spoersmaal = new JLabel();
        jaButton = new JButton("JA");
        neiButton = new JButton("NEI");
        jaButton.addActionListener(new Ja(svar, hovedtrad));
        neiButton.addActionListener(new Nei(svar, hovedtrad));


        vindu.add(spoersmaal);
        vindu.add(jaButton);
        vindu.add(neiButton);

        vindu.pack();
        vindu.setLocationRelativeTo(null);
        vindu.setVisible(true);
    }
    
    public boolean svarJaEllerNei(String s){
        spoersmaal.setText(s);
        try {
            Thread.sleep(1000000);  
        } catch (InterruptedException e) {}
            if (svar.equals("j")) {
                return true;
            } else if (svar.equals("n")) {
                return false;
            }
        return false;
    }
}
