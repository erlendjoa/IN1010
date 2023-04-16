import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); } 
        catch (Exception e) {System.exit(1); }


        ArrayList<Card> deck = new ArrayList<>();
        ArrayList<Card> dealerHand = new ArrayList<>();
        ArrayList<Card> playerHand = new ArrayList<>();
        int dealerScore = 0;
        int playerScore = 0;

        for (int i = 0; i < 20; i++) {
            deck.add(new Card("ace.png", 1));
        }
        

        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(800,800));
        mainPanel.setBackground(new Color(84, 121, 80));

        JPanel topPanel = new JPanel();
        JPanel botPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        topPanel.setPreferredSize(new Dimension(800,350));
        botPanel.setPreferredSize(new Dimension(800,350));
        bottomPanel.setPreferredSize(new Dimension(800, 80));
        topPanel.setBackground(new Color(112, 162, 107));
        botPanel.setBackground(new Color(112, 162, 107));
        bottomPanel.setBackground(new Color(56, 83, 53));

        JPanel dealerPanel = new JPanel();
        JPanel playerPanel = new JPanel();
        dealerPanel.setPreferredSize(new Dimension(500,200));
        playerPanel.setPreferredSize(new Dimension(500,200));
        dealerPanel.setBounds(0,0,0,0);


        dealerPanel.setLayout(new GridLayout(0,1));
        playerPanel.setLayout(new GridLayout(0,1));
        /*
        for (int i = 1; i <= 5; i++) {
            dealerPanel.setLayout(new GridLayout(0,i));
            JLabel dlabel = new JLabel();
            dlabel.setIcon(new ImageIcon("ace.png"));
            dealerPanel.add(dlabel);
        }
        for (int i = 1; i <= 5; i++) {
            playerPanel.setLayout(new GridLayout(0,i));
            JLabel plabel = new JLabel();
            plabel.setIcon(new ImageIcon("ace.png"));
            playerPanel.add(plabel);
        }
         */

        JButton addCardButton = new JButton("ADD");
        addCardButton.addActionListener(new AddCard(deck, playerHand, topPanel));
        bottomPanel.add(addCardButton);

        JLabel playerScoreLabel = new JLabel(Integer.toString(playerScore));
        bottomPanel.add(playerScoreLabel);

        topPanel.add(dealerPanel);
        botPanel.add(playerPanel, BorderLayout.CENTER);
        mainPanel.add(topPanel);
        mainPanel.add(botPanel);
        mainPanel.add(bottomPanel);
        JFrame frame = new JFrame();
        frame.add(mainPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setBackground(Color.DARK_GRAY);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

        Thread thread1 = new Thread(new UpdateBoard(playerHand, topPanel));
        Thread scoreUpdater = new Thread(new UpdateScore(playerScoreLabel, playerHand, playerScore));
        thread1.start(); scoreUpdater.start();
    }
}