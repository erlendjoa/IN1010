import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiTest {

    int count = 0;
    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); } 
        catch (Exception e) {System.exit(1); }
    
        JFrame frame = new JFrame("GUI TEST");
        JPanel panel = new JPanel();

        JButton button = new JButton("ClickMe");
        JLabel label = new JLabel("Nr of Clicks: 0");
        Action action = new Action(label);
        button.addActionListener(action);

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));

        panel.add(label);
        panel.add(button);
        frame.add(panel, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}