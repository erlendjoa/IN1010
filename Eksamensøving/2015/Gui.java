import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui {
    
    public Gui() {
        try { UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); } 
        catch (Exception e) {System.exit(1); }

        JFrame frame = new JFrame();

        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(10,10));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                HRute hRute = new HRute();
                hRute.setPreferredSize(new Dimension(50,50));
            }
        }


        frame.add(grid);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
