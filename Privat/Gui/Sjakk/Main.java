import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {

    public static String[] names = {"A", "B", "C", "D", "E", "F", "G", "H"};
    public static boolean isLightTile = true;

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); } 
        catch (Exception e) {System.exit(1); }

        Piece[] allPieces = new Piece[32];

        int pieceCounter = 0;
        String playerColor = "white";
        String[] pieceNames = {"King", "Queen", "Bishop", "Rook", "Knight", "Pawn"};
        for (int i = 0; i <= 1; i++) {
            for (String pieceName : pieceNames) {
                if (pieceName == "King") {
                    allPieces[pieceCounter] = new Piece(pieceName, playerColor, new ImageIcon("Assets/" + playerColor + pieceName + ".png"));
                    pieceCounter++;
                    System.out.println(pieceCounter + " la til " + pieceName);
                } else if (pieceName == "Queen") {
                    allPieces[pieceCounter] = new Piece(pieceName, playerColor, new ImageIcon("Assets/" + playerColor + pieceName + ".png"));
                    pieceCounter++;
                    System.out.println(pieceCounter + " la til " + pieceName);
                } else if (pieceName == "Bishop") {
                    for (int ii = 0; ii < 2; ii++) {
                        allPieces[pieceCounter] = new Piece(pieceName, playerColor, new ImageIcon("Assets/" + playerColor + pieceName + ".png"));
                        pieceCounter++;
                        System.out.println(pieceCounter + " la til " + pieceName);
                    }
                } else if (pieceName == "Rook") {
                    for (int ii = 0; ii < 2; ii++) {
                        allPieces[pieceCounter] = new Piece(pieceName, playerColor, new ImageIcon("Assets/" + playerColor + pieceName + ".png"));
                        pieceCounter++;
                        System.out.println(pieceCounter + " la til " + pieceName);
                    }
                } else if (pieceName == "Knight") {
                    for (int ii = 0; ii < 2; ii++) {
                        allPieces[pieceCounter] = new Piece(pieceName, playerColor, new ImageIcon("Assets/" + playerColor + pieceName + ".png"));
                        pieceCounter++;
                        System.out.println(pieceCounter + " la til " + pieceName);
                    }
                } else if (pieceName == "Pawn") {
                    for (int ii = 0; ii < 8; ii++) {
                        allPieces[pieceCounter] = new Piece(pieceName, playerColor, new ImageIcon("Assets/" + playerColor + pieceName + ".png"));
                        pieceCounter++;
                        System.out.println(pieceCounter + " la til " + pieceName);
                    }
                }
            }
            playerColor = "black";
        }

        JPanel brett = new JPanel();
        brett.setLayout(new GridLayout(8,8));
        brett.setPreferredSize(new Dimension(600,600));
        
        Tile[] squares = new Tile[64];
        int squareCounter = 0;
        for (int i = 7; i >= 0; i--) {
            isLightTile = !isLightTile;
            for (int ii = 1; ii < 9; ii++) {
                isLightTile = !isLightTile;
                squares[squareCounter] = new Tile(names[i] + ii, isLightTile);
                squares[squareCounter].addActionListener(new Place(null));
                brett.add(squares[squareCounter]);
                squareCounter++;
            }
        }

        JFrame frame = new JFrame();
        frame.setBackground(Color.DARK_GRAY);
        frame.setSize(800,800);
        frame.add(brett);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}