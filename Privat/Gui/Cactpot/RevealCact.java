import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RevealCact implements ActionListener {
    
    CactButton button;

    public RevealCact(CactButton button) {
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Clicked");
        button.setText(Integer.toString(button.num));
    }
}
