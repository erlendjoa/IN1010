import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Place implements ActionListener {

    Piece piece;

    public Place(Piece piece) {
        this.piece = piece;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.piece = piece;
        setIcon(piece.icon);
    }
}
