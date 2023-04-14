import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoftBeger implements ActionListener {

    boolean harBall;
    JLabel resultatLabel;

    public LoftBeger(boolean harBall, JLabel  resultatLabel) {
        this.harBall = harBall;
        this.resultatLabel = resultatLabel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (harBall) {
            resultatLabel.setText("OK");
        } else {
            resultatLabel.setText("NEI"); 
        }
    }
}