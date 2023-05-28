import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ja implements ActionListener {

    String svar;
    Thread hovedtrad;

    public Ja(String svar, Thread hovedtrad) {
        this.svar = svar;
        this.hovedtrad = hovedtrad;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        svar = "j";
        hovedtrad.interrupt();
    }
}
