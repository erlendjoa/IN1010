import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main3 {

    public static void main(String[] args) {
    try { UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); } 
    catch (Exception e) {System.exit(1); }    

    
    MyButton button = new MyButton();


    MyFrame frame = new MyFrame();
    frame.add(button);
    }
}
