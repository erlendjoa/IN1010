import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.xml.crypto.Data;

import java.util.Scanner;

public class Main {

    User user;
    DataBase dataBase;

    public static void main(String[] args) {
        Main main = new Main(args);
    }

    public Main(String[] args) {
        StartThreads threads = new StartThreads();
        dataBase = threads.main(new DataBase());
        
        createUser(args);
        createGui(); 
    }
        
    
    public void createUser(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("| Spotify Terminal |   Press Enter to continue: ");

        if (args[2].equals("premium")) {
            user = new PremiumUser(args[0], args[1]);
        } else {
            user = new FreeUser(args[0], args[1]);
        }
    }

    public void createGui() {
        SpotifyFrame frame = new SpotifyFrame();

        JPanel mainPanel = new JPanel(null);
        mainPanel.setPreferredSize(new Dimension(800,600));
        mainPanel.setBackground(new Color(30,30,30));

        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(200,400));
        leftPanel.setBackground(new Color(60,60,60));
        leftPanel.setBounds(30, 100, leftPanel.getPreferredSize().width, leftPanel.getPreferredSize().height);
        leftPanel.setBorder(BorderFactory.createEtchedBorder());

        mainPanel.add(leftPanel);

        JLabel artistsLabel = new JLabel(Integer.toString(dataBase.getArtists().size()));
        mainPanel.add(artistsLabel);

        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    
}
