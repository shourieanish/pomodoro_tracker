import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
Error message that pops up if the timer is set to 
0 hr, 0 min, 0 sec
*/

public class ErrorMessage implements ActionListener {
	private JFrame frame;
    private JPanel panel;
    private JButton ok;

    public ErrorMessage() {

        panel = new JPanel();
        panel.setLayout(null);
        frame = new JFrame("Error");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(170,125);
        frame.setResizable(false);
        frame.add(panel);

        JLabel message1 = new JLabel("Please enter");
        message1.setBounds(45,18,125,25);
        panel.add(message1);

        // splitting label into two lines
        JLabel message2 = new JLabel("a valid time.");
        message2.setBounds(45,32,125,25);
        panel.add(message2);

        ok = new JButton("OK");
        ok.setBounds(34,60,100,25);
        ok.addActionListener(this); 
        panel.add(ok);

        frame.setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {
            frame.dispose();
     	}
    }

   
}
