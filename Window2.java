import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window2 implements ActionListener {
	private JFrame frame;
    private JPanel panel;
    private JButton timer;
    private JButton tomato;

    public Window2() {

        panel = new JPanel();
        frame = new JFrame("Timer");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);

        panel.setLayout(null);

        JLabel label = new JLabel("Cheese!");
        label.setBounds(50,20,150,25);
        panel.add(label);

        tomato = new JButton("Start tomato");
        tomato.setBounds(75,350,150,25);
        tomato.addActionListener(this); 
        panel.add(tomato);

        frame.setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == tomato) {
            System.out.println("Lebron");
        } else {
            ;
        }
    }
}
