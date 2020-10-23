import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pomodoro_GUI implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JButton tomato;
    private JButton brk;

    public Pomodoro_GUI() {

        panel = new JPanel();
        frame = new JFrame("Pomodoro Tracker");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(panel);

        panel.setLayout(null);

        JLabel label = new JLabel("Collect as many tomatoes as possible!");
        label.setBounds(50,20,150,25);
        panel.add(label);

        tomato = new JButton("Start tomato");
        tomato.setBounds(75,350,150,25);
        tomato.addActionListener(this); 
        panel.add(tomato);


        brk = new JButton("Start tomato");
        brk.setBounds(30,150,150,25);
        brk.addActionListener(this); 
        panel.add(brk);

        // JButton b2 = new JButton("Start tomato");
        // b2.setBounds(75,375,165,25);
        // panel.add(b2);

        // JButton b2 = new JButton("Kobe");
        // b1.setBounds(200,75,165,25);
        // panel.add(b1);

        frame.setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == tomato) {
            System.out.println("kobe");
        } else if (e.getSource() == brk) {
            System.out.println("lebron");
        }
    }

    public static void main(String[] args) {
        new Pomodoro_GUI();  
    }
    
}