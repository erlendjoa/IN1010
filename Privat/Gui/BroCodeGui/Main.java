import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Main {

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); } 
        catch (Exception e) {System.exit(1); }

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
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setIconTextGap(5);

        label.setBounds(20,20,500,500);   // Set x,y,width,height of label in frame

        MyFrame myFrame = new MyFrame();
        myFrame.setLayout(null);
        myFrame.add(label);

        //myFrame.pack();
        myFrame.setVisible(true);
    }
}