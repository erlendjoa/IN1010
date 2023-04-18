import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class Kontroll {
    
    public static void main(String[] args) {
        Gui gui = new Gui();
        GameOfLife gameOfLife = new GameOfLife(args[0]);  
        Kontroll kontroll = new Kontroll(gui, gameOfLife, args[0]);
    }

    public Kontroll(Gui gui, GameOfLife gameOfLife, String antallCeller) {
        gui.startGui(antallCeller);

        while (true) {
            gameOfLife.verden.oppdatering();
            ArrayList<Character> celleStatusTegn = gameOfLife.verden.hentStatusPaaCeller();

            for (int i = 0; i < gui.celleButtonList.size(); i++) {
                JButton currentButton = gui.celleButtonList.get(i);
                char currentChar = celleStatusTegn.get(i);

                if (currentChar == 'O') {
                    currentButton.setBackground(Color.WHITE);
                    currentButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                } else {
                    currentButton.setBackground(Color.BLACK);
                    currentButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                }
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
        
    }
}
