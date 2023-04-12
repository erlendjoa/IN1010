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

    vindu.setLayout(new GridLayout(8,8));


    vindu.pack();
    vindu.setLocationRelativeTo(null);
    vindu.setVisible(true);
    }
}