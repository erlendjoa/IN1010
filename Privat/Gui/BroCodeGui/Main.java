import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Main {

    public static void main(String[] args) {

        ImageIcon img = new ImageIcon("keroGrips.jpg");
        JLabel label = new JLabel();    
        label.setText("Bro, do you even code?");    // OR this.
        label.setForeground(Color.PINK);
        label.setFont(new Font("MV Boli", Font.BOLD, 20));

        Border border = BorderFactory.createLineBorder(Color.PINK,5);
        label.setOpaque(true);  // display background
        label.setBorder(border);

        label.setIcon(img);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setIconTextGap(5);

        MyFrame myFrame = new MyFrame();
        myFrame.add(label);
    }
}