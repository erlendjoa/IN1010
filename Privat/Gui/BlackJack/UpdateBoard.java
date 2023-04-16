import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class UpdateBoard implements Runnable {
    
    ArrayList<Card> hand;
    JPanel panel;

    public UpdateBoard(ArrayList<Card> hand, JPanel panel) {
        this.hand = hand;
        this.panel = panel;
    }

    @Override
    public void run() {
        while (true) {
             try {
                for (int i = 0; i < hand.size(); i++) {
                    panel.setLayout(new GridLayout(0,i+1)); // Set the number of columns in the grid layout to i+1

                    JLabel label = new JLabel("TEST");
                    label.setPreferredSize(new Dimension(100, 150)); // Set the preferred size of the label to display the image
                    label.setIcon(new ImageIcon(hand.get(i).icon));
                    
                    panel.add(label);
                    }
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
    }
}