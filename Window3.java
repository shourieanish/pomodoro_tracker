import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.util.TimerTask;

public class Window3 implements ActionListener {
	private JFrame frame;
    private JPanel panel;
    private JButton start;
    private JButton stop;
    private JButton reset;
    private int tm;
    private boolean timer_started = false;
    private Timer timer;

    public Window3(int min, int sec) {

        tm = min*60 + sec;
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tm == 0){
                    ;
                } else {
                    tm --;
                    sec_label.setText(tm);
                    System.out.println(tm);
                }
            }
        });

        panel = new JPanel();
        frame = new JFrame("Timer");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);

        panel.setLayout(null);

        JLabel min_label = new JLabel("");
        min_label.setBounds(50,20,150,25);
        panel.add(min_label);

        JLabel sec_label = new JLabel("");
        sec_label.setBounds(180,200,150,25);
        panel.add(sec_label);

        start = new JButton("Start");
        start.setBounds(75,350,150,25);
        start.addActionListener(this); 
        panel.add(start);

        stop = new JButton("Pause");
        stop.setBounds(30,150,150,25);
        stop.addActionListener(this); 
        panel.add(stop);

        reset = new JButton("Reset");
        reset.setBounds(50,200,150,25);
        reset.addActionListener(this); 
        panel.add(reset);


        frame.setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start && timer_started == false) {
            timer.start();
    		timer_started = true;
     	} else if (e.getSource() == stop) {
     		timer.stop();
     		timer_started = false;
     	} else if (e.getSource() == reset) {
            timer.stop();
            frame.setVisible(false);
            Window2 w2 = new Window2();
        }
    }


    
}
