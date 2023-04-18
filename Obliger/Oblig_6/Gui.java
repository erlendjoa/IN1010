import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui {

    public static void main(String[] args) {
        Gui gui = new Gui();
        gui.startGui(args[0]);
    }

    public void startGui(String antallCeller) {
        System.out.println(Double.parseDouble(antallCeller));
        System.out.println(Math.sqrt(Double.parseDouble(antallCeller)));
        System.out.println((int) Math.sqrt(Double.parseDouble(antallCeller)));

        int indexCeller = (int) Math.sqrt(Double.parseDouble(antallCeller));
        try { UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); } 
        catch (Exception e) {System.exit(1); }

        // Lag rutenett JPanel
        JPanel rutenettPanel = new JPanel();
        GridLayout rutenettGrid = new GridLayout(indexCeller, indexCeller);
        rutenettPanel.setLayout(rutenettGrid);
        
        // Lag the andre JPanel
        JPanel otherPanel = new JPanel();

        // Fyll inn rutenettGrid
        for (int i = 0; i < indexCeller; i++) {
            for (int j = 0; j < indexCeller; j++) {
                JButton celleButton = new JButton("0");
                celleButton.setBackground(Color.BLACK);
                celleButton.setForeground(Color.BLACK);
                rutenettPanel.add(celleButton, i, j);  
            }
        }

        // Fyll inn i det andre panelet
        Image img = new ImageIcon("sus.png").getImage().getScaledInstance(40,50, Image.SCALE_SMOOTH);
        JLabel gameOfLifeLabel = new JLabel("Game of Life!", new ImageIcon(img), 0);
        otherPanel.setBackground(new Color(50,50,50));

        gameOfLifeLabel.setFont(new Font("Comic Sans MS" , Font.BOLD, 24));
        gameOfLifeLabel.setIconTextGap(15);
        gameOfLifeLabel.setForeground(Color.BLACK);
        //otherPanel.setPreferredSize(new Dimension(0, 100));
        otherPanel.add(gameOfLifeLabel);
        
        
        // Lag og add elements til JFrame
        JFrame vindu = new JFrame();
        vindu.setLayout(new BorderLayout());
        vindu.add(rutenettPanel, BorderLayout.NORTH);
        vindu.add(otherPanel, BorderLayout.SOUTH);

        vindu.pack();
        vindu.setTitle("Game of Life");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vindu.setLocationRelativeTo(null);
        vindu.setResizable(true);
        vindu.getContentPane().setBackground(new Color(50,50,50));
        vindu.setVisible(true);
    }
}
