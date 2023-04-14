import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OppdaterTrad implements Runnable {

    JButton klokkeKnapp;

    public OppdaterTrad(JButton klokkeKnapp) {
        this.klokkeKnapp = klokkeKnapp;
    }

    @Override
    public void run() {
        while (true) {
            try {
                klokkeKnapp.setText(Klokke.naa());
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}