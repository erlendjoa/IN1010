import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class TreBegreOgEnBall {
    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); } 
        catch (Exception e) {System.exit(1); }

        JFrame vindu = new JFrame("Tre Begre Og En Ball");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        vindu.add(panel);

        String resultat = "???";
        JLabel resultatLabel = new JLabel(resultat);
        resultatLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 16));

        // Lag knapper og add Actionlistener LoftBeger
        JButton[] buttonArr = {new JButton("1"), new JButton("2"), new JButton("3")};
        Random random = new Random();
        int trueInt = random.nextInt(3);
        for (int i = 0; i < buttonArr.length; i++) {
            if (i == trueInt) {
                buttonArr[i].addActionListener(new LoftBeger(true, resultatLabel));
            } else {
                buttonArr[i].addActionListener(new LoftBeger(false, resultatLabel));
            }
            panel.add(buttonArr[i]);
        }
        panel.add(resultatLabel);
        
        vindu.pack();
        vindu.setLocationRelativeTo(null);
        vindu.setVisible(true);
    }
}