import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Action implements ActionListener {
    
    private int count;
    private JLabel label;

    public Action(JLabel label) {
        count = 0;
        this.label = label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("Nr of Clicks: " + count);
    }
}
