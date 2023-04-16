import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class UpdateScore implements Runnable {

    JLabel label;
    ArrayList<Card> hand;
    int score;

    public UpdateScore(JLabel label, ArrayList<Card> hand, int score) {
        this.label = label;
        this.hand = hand;
        this.score = score;
    }
    
    @Override
    public void run() {
        try {
            score = 0;
            for (Card card : hand) {
                score += card.value;
            }
            label.setText(Integer.toString(score)); 
            Thread.sleep(100);
        } catch(InterruptedException e) {}

    }
}
