import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GruppeGui {

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); }
        catch (Exception e) { System.exit(1); }

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);


        JPanel rutenett = new JPanel();
        for (int i = 0; i < 9; i++) {
            JButton button  = new JButton("" + i);
            button.setPreferredSize(new Dimension(50,50));
            button.setHorizontalAlignment(JLabel.CENTER);
            button.setVerticalAlignment(JLabel.CENTER);
            button.setBorder(BorderFactory.createLineBorder(Color.GREEN));

            button.addActionListener(new Stopper());
            rutenett.add(button);
        }
        frame.add(rutenett);

    }
    
}