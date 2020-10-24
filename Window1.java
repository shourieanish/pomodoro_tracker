import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window1 implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JButton tomato;
    private JButton brk;

    public Window1() {

        panel = new JPanel();
        frame = new JFrame("Pomodoro Tracker");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);

        panel.setLayout(null);

        JLabel label = new JLabel("Collect as many tomatoes as possible!");
        label.setBounds(50,20,150,25);
        panel.add(label);

        tomato = new JButton("Start tomato");
        tomato.setBounds(75,350,150,25);
        tomato.addActionListener(this); 
        panel.add(tomato);


        brk = new JButton("Take break");
        brk.setBounds(30,150,150,25);
        brk.addActionListener(this); 
        panel.add(brk);


        frame.setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == tomato) {
            Window2 w2 = new Window2();
        } else {
            ;
        }
    }

    public static void main(String[] args) {
        new Window1();
    }
    
}