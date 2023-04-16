import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class AddCard implements ActionListener {

	ArrayList<Card> deck;
	ArrayList<Card> hand;
	JPanel topPanel;
	
	
	public AddCard(ArrayList<Card> deck, ArrayList<Card> hand, JPanel topPanel) {
		this.deck = deck;
		this.hand = hand;
		this.topPanel = topPanel;
	}

	public void actionPerformed(ActionEvent e) {
		Random rnd = new Random();
		int randInt = rnd.nextInt(deck.size());
		System.out.println("Adding card " + deck.get(randInt) + " with randInt: " + randInt);
		hand.add(deck.remove(randInt));
    }
}


