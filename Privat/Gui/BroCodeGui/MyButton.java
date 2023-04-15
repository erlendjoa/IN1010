import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyButton extends JButton {
    public MyButton() {
        ImageIcon img = new ImageIcon("sus.png");
        setIcon(img);
        setHorizontalTextPosition(JButton.RIGHT);
        setVerticalTextPosition(JButton.CENTER);
        setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        setIconTextGap(10);
        setForeground(Color.MAGENTA);
        setBackground(Color.LIGHT_GRAY);
        setBorder(BorderFactory.createEtchedBorder());

        setBounds(30,30,0,0);
        setSize(150,150);
        addActionListener(e -> System.out.println("poo"));
        setFocusable(false);
        setText("Hi");
    }
}
