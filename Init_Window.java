import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Init_Window implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JButton work, brk;

    public Init_Window() {

        panel = new JPanel();
        panel.setLayout(null);
        frame = new JFrame("Pomodoro");
        frame.setSize(250,325);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);

        JLabel label = new JLabel("Productivity Tracker");
        label.setFont(new Font("Times New Roman", Font.BOLD, 22));
        label.setBounds(25,18,200,25);
        panel.add(label);

        work = new JButton("Start Working");
        work.setBounds(50,119,150,75);
        work.addActionListener(this); 
        panel.add(work);

        brk = new JButton("Take a Break");
        brk.setBounds(50,203,150,75);
        brk.addActionListener(this); 
        panel.add(brk);

        frame.setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == work) {
            frame.dispose();
            new SetTimer(true);
        } else if (e.getSource() == brk) {
            frame.dispose();
            new SetTimer(false);
        }
    }

    public static void main(String[] args) {
        new Init_Window();
    }
    
}