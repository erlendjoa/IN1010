import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame {
        public MyFrame() {
            setTitle("Window Title");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);  // Prevent frame from being resized or not.
            setSize(720,720); // Set size of window;
            getContentPane().setBackground(new Color(50,50,50));  // Change background color.
            setLocationRelativeTo(null);
    
            ImageIcon img = new ImageIcon("keroGrips.jpg"); // Create image icon.
            setIconImage(img.getImage());
            
            setLayout(null);
            setVisible(true);
        }
}
