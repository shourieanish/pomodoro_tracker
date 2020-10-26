import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Window1 implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JButton work;
    private JButton brk;

    public Window1() {


        panel = new JPanel();
        frame = new JFrame("Pomodoro Tracker");
        frame.setSize(250,325);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);

        panel.setLayout(null);

        JLabel label = new JLabel("Productivity Tracker");
        label.setFont(new Font("Times New Roman", Font.BOLD, 22));
        label.setBounds(25,10,200,20);
        panel.add(label);

        work = new JButton("Start Working");
        work.setBounds(50,120,150,75);
        work.addActionListener(this); 
        panel.add(work);

        brk = new JButton("Take a Break");
        brk.setBounds(50,205,150,75);
        brk.addActionListener(this); 
        panel.add(brk);


        frame.setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == work) {
            frame.setVisible(false);
            frame = null;
            Window2 w2 = new Window2(true);
        } else if (e.getSource() == brk) {
            frame.setVisible(false);
            frame = null;
            Window2 w2 = new Window2(false);
        }
    }

    public static void main(String[] args) {
        new Window1();
    }
    
}