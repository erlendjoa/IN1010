import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Nei implements ActionListener {

    String svar;
    Thread hovedtrad;

    public Nei(String svar, Thread hovedtrad) {
        this.svar = svar;
        this.hovedtrad = hovedtrad;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        svar = "n";
        hovedtrad.interrupt();
    }
}
