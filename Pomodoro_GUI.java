import javax.swing.*;
import java.awt.*;

public class Pomodoro_GUI {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void create_window() {
        //Create and set up the window.
        JFrame f = new JFrame("Panel Example");
        JPanel panel = new JPanel();

        panel.setBounds(40,80,200,200);    
        panel.setBackground(Color.gray);  
        JButton b1 = new JButton("Button 1");     
        b1.setBounds(50,160,80,30);    
        b1.setBackground(Color.GREEN);
        b1.setForeground(Color.RED);
        b1.setOpaque(true);
        panel.add(b1);

        f.add(panel);  
        f.setSize(400,400);    
        f.setLayout(null);    
        f.setVisible(true);     
        
    }

    public static void main(String[] args) {
        create_window();
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        // javax.swing.SwingUtilities.invokeLater(new Runnable() {
        //     public void run() {
        //         createAndShowGUI();
        //     }
        // });
    }
}