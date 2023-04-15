import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tile extends JPanel implements MouseListener {

    public Piece piece;
    public JLabel label;
    public Color color;
    
    public Tile(String name, boolean colorIndicator) {
        label = new JLabel(name);
        label.setName(name);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        setLayout(new BorderLayout());
        add(label);

        if (colorIndicator) {
            this.color = new Color(200,180,138);
            setBackground(color);
        } else {
            this.color = new Color(94,90,70);
            setBackground(color);
        }
    }

    public void setPiece(Piece newPiece) {
        piece = newPiece;
        label.setIcon(piece.icon);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(piece.name);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
