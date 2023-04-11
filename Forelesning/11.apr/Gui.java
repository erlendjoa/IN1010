import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui {

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); } 
        catch (Exception e) {System.exit(1); }

        JFrame vindu = new JFrame("yomakkaflow");

        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // Avslutt når bruker trykker på exit knapp.

        JPanel panel = new JPanel();    // Lag et panel/vindu.
        vindu.add(panel);   // Initier panel.

        vindu.pack();   // Pakk alt innholdet i vinduet pent sammen.
        vindu.setLocationRelativeTo(null);  // Sett plassering på skjerm;

        vindu.setVisible(true); // Vis vinduet på skjermen;


        String bruker = System.getProperty("user.name");    
        JLabel hilsen = new JLabel("Hallo, " + bruker + "!");   // JLabel oppretter tekst-objekt.
        panel.add(hilsen);

        JButton knapp = new JButton("exit");  // JButton oppretter knapp-objekt.
        panel.add(knapp);

        class Stopper implements ActionListener {   // Opprett og Override ActionListener.actionPerformed() kall ved trykk.
            @Override
            public void actionPerformed (ActionEvent e) {
                System.exit(0); 
            } 
        }
        knapp.addActionListener(new Stopper()); // Koble funksjon til knapp;
    }
}