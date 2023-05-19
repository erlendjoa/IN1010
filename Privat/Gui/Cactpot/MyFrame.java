import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame {
    
    public MyFrame() {
        setTitle("Window Title");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);  // Prevent frame from being resized or not.
        setPreferredSize(new Dimension(720, 720)); // Set size of window;
        getContentPane().setBackground(new Color(50,50,50));  // Change background color.
        setLocationRelativeTo(null);

        setLayout(null);
        setVisible(true);
    }
}
