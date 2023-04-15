import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame {

        public MyFrame() {
            this.setTitle("Window Title");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(true);  // Prevent frame from being resized or not.
            this.setSize(720,720); // Set size of window;
            this.getContentPane().setBackground(new Color(50,50,50));  // Change background color.
            
            this.setLocationRelativeTo(null);
            this.setVisible(true);
    
            ImageIcon img = new ImageIcon("xcx.jpg"); // Create image icon.
            this.setIconImage(img.getImage());
        }
}
