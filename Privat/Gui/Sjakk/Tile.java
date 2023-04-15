import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tile extends JButton {

    Piece piece;
    String name;
    Color color;
    
    public Tile(String name, boolean colorIndicator) {
        this.name = name;

        JLabel nameLabel = new JLabel(name);
        setLayout(new BorderLayout());
        add(nameLabel);

        if (colorIndicator) {
            this.color = new Color(200,180,138);
            setBackground(color);
        } else {
            this.color = new Color(64,60,50);
            setBackground(color);
        }
    }
}
