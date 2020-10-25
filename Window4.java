import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window4 implements ActionListener {
	private JFrame frame;
    private JPanel panel;
    private JButton ok;

    public Window4() {

        panel = new JPanel();
        frame = new JFrame("Error");
        frame.setSize(170,125);
        frame.setResizable(false);
        frame.add(panel);

        panel.setLayout(null);

        JLabel message1 = new JLabel("Please enter");
        message1.setBounds(45,18,125,25);
        panel.add(message1);

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
            frame.setVisible(false);
            frame = null;
     	}
    }

   
}
