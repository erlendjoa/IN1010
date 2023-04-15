import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main2 {
    
    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); } 
        catch (Exception e) {System.exit(1); }

        ImageIcon amogSus = new ImageIcon("sus.png");
        JLabel amogSusLabel = new JLabel("Hi");
        amogSusLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        amogSusLabel.setIcon(amogSus);
        amogSusLabel.setVerticalAlignment(JLabel.BOTTOM);
        amogSusLabel.setHorizontalAlignment(JLabel.CENTER);
        //amogSusLabel.setBounds(0,0,150,150);

        JPanel cyanPanel = new JPanel(); 
        cyanPanel.setBackground(Color.CYAN);
        cyanPanel.setBounds(0,0,250,250);
        cyanPanel.setLayout(new BorderLayout()); // can set to null and choose bounds with JLabel.setBounds(int,int,int,int).
        
        JPanel magentaPanel = new JPanel();
        magentaPanel.setBackground(Color.MAGENTA);
        magentaPanel.setBounds(250,0,250,250);
        
        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.GREEN);
        greenPanel.setBounds(0,250,500,250);


        cyanPanel.add(amogSusLabel);

        MyFrame frame = new MyFrame();
        frame.add(cyanPanel);
        frame.add(magentaPanel);
        frame.add(greenPanel);

        
    }
}
