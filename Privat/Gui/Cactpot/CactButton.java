import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CactButton extends JButton {

    int num;
    
    public CactButton(int num) {
        this.num = num;

        setHorizontalTextPosition(JButton.RIGHT);
        setVerticalTextPosition(JButton.CENTER);
        setForeground(Color.BLACK);
        setBackground(Color.WHITE);

        setText("X");
        setSize(100,100);

        addActionListener(new RevealCact(this));
    }
}
