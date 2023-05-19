import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui {

    public void createGui(Cactpot cp) {
        JFrame frame = new JFrame("Button Grid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 3)); // GridLayout with 3 rows and 3 columns

        for (int num : cp.cacts) {
            CactButton button = new CactButton(num);
            buttonPanel.add(button);
        }

        frame.add(buttonPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
