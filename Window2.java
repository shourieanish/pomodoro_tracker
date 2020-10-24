import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.util.TimerTask;

public class Window2 implements ActionListener {
	private JFrame frame;
    private JPanel panel;
    private JButton start;
    private JButton stop;
    private int min = 24;
    private int sec = 24;
    private boolean timer_started = false;
    private Timer timer = new Timer(1000, new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if (sec == 0){
    				;
    			} else {
    				sec --;
    				System.out.println(sec);
    			}
    		}
    	});

    public Window2() {

        panel = new JPanel();
        frame = new JFrame("Set Time");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);

        panel.setLayout(null);

        JLabel label = new JLabel("Cheese!");
        label.setBounds(50,20,150,25);
        panel.add(label);

        start = new JButton("Start");
        start.setBounds(75,350,150,25);
        start.addActionListener(this); 
        panel.add(start);

        stop = new JButton("Stop");
        stop.setBounds(30,150,150,25);
        stop.addActionListener(this); 
        panel.add(stop);




        frame.setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start && timer_started == false) {
            timer.start();
    		timer_started = true;
     	} else if (e.getSource() == stop) {
     		timer.stop();
     		timer_started = false;
     	}
    }

    // private void start() {
    // 	Timer timer = new Timer(1000, new ActionListener() {
    // 		public void actionPerformed(ActionEvent e) {
    // 			sec --;
    // 			System.out.println(sec);
    // 		}
    // 	});
    // 	if (timer_started == false) {
    // 		timer.start();
    // 		timer_started = true;
    // 	}
    // }
    
}
