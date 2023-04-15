import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Piece {
    
    String name;
    String player;
    ImageIcon icon;

    public Piece(String name, String player, ImageIcon icon) {
        this.name = name;
        this.player = player;
        this.icon = icon;
    }
}
