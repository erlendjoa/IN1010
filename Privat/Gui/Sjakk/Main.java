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

        JPanel board = new JPanel();
        board.setLayout(new GridLayout(8,8));
        board.setPreferredSize(new Dimension(600,600));
        
        Tile[] squares = new Tile[64];
        int squareCounter = 0;
        for (int i = 7; i >= 0; i--) {
            isLightTile = !isLightTile;
            for (int ii = 1; ii < 9; ii++) {
                isLightTile = !isLightTile;
                squares[squareCounter] = new Tile(names[i] + ii, isLightTile);
                squares[squareCounter].addMouseListener(squares[squareCounter]);
                board.add(squares[squareCounter]);
                squareCounter++;
            }
        }

        // STARTUP POSITION
        for (Tile tile : squares) {
            String pieceName;

            if (tile.label.getName().equals("B1") || tile.label.getName().equals("B2") || tile.label.getName().equals("B3") || tile.label.getName().equals("B4")
            || tile.label.getName().equals("B5") || tile.label.getName().equals("B6") || tile.label.getName().equals("B7") || tile.label.getName().equals("B8")) {
            pieceName = "Pawn";
            playerColor = "white";
            tile.setPiece(new Piece(pieceName, playerColor, new ImageIcon("Assets/" + playerColor + pieceName + ".png")));
            }
            // TODO: Implement the other start position for all pieces.
        }   


        JFrame frame = new JFrame();
        frame.setBackground(Color.DARK_GRAY);
        frame.setSize(800,800);
        frame.add(board);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}