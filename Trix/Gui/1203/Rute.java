import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

abstract class Rute extends JLabel {

    void initGUI() {
        setPreferredSize(new Dimension(50,50));
        setOpaque(true);
    }
}

class Hvite extends Rute {
    
}
