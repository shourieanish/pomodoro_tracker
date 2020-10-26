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
    private JLabel sec_label;
    private JLabel min_label;
    private JLabel hr_label;
    private JLabel colon1;
    private JLabel colon2;
    private int tm;
    private int tm_init;
    private boolean timer_started = false;
    private Timer timer;
    private boolean isWork;

    public Window3(int hr, int min, int sec, boolean isWork) {

        this.isWork = isWork;

        tm = hr*3600 + min*60 + sec;
        tm_init = tm;

        panel = new JPanel();
        frame = new JFrame("Timer");
        frame.setSize(250,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);

        panel.setLayout(null);

        colon1 = new JLabel(":");
        colon1.setFont(new Font("Times New Roman", Font.PLAIN, 38));
        colon1.setBounds(90,46,150,50);
        panel.add(colon1);

        colon2 = new JLabel(":");
        colon2.setFont(new Font("Times New Roman", Font.PLAIN, 38));
        colon2.setBounds(155,46,150,50);
        panel.add(colon2);

        hr_label = new JLabel("");
        if (hr <= 9) {
            hr_label.setText("0" + hr);
        } else {
            hr_label.setText("" + hr);
        }
        hr_label.setFont(new Font("Times New Roman", Font.PLAIN, 38));
        hr_label.setBounds(43,46,150,50);
        panel.add(hr_label);

        min_label = new JLabel("");
        if (min <= 9) {
            min_label.setText("0" + min);
        } else {
            min_label.setText("" + min);
        }
        min_label.setFont(new Font("Times New Roman", Font.PLAIN, 38));
        min_label.setBounds(108,46,150,50);
        panel.add(min_label);

        sec_label = new JLabel("");
        if (sec <= 9) {
            sec_label.setText("0" + sec);
        } else {
            sec_label.setText("" + sec);
        }
        sec_label.setFont(new Font("Times New Roman", Font.PLAIN, 38));
        sec_label.setBounds(173,46,150,50);
        panel.add(sec_label);

        start = new JButton("Start");
        start.setBounds(50,120,150,75);
        start.addActionListener(this); 
        panel.add(start);

        stop = new JButton("Pause");
        stop.setBounds(50,200,150,75);
        stop.addActionListener(this); 
        panel.add(stop);

        reset = new JButton("Reset");
        reset.setBounds(50,280,150,75);
        reset.addActionListener(this); 
        panel.add(reset);


        frame.setVisible(true);

        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tm == 0){
                    timer.stop();
                    frame.setVisible(false);
                    frame = null;
                    Window5 w5 = new Window5(hr, min, sec, isWork);
                } else {
                    tm --;
                    int hr_temp = (int)tm/3600;
                    int min_temp = (int) (tm - (hr_temp*3600))/60;
                    if (hr_temp <= 9) {
                        hr_label.setText("0" +hr_temp);
                    } else {
                        hr_label.setText("" +hr_temp);
                    }
                    if (min_temp <= 9) {
                        min_label.setText("0" +min_temp);
                    } else {
                        min_label.setText("" +min_temp);
                    }
                    if ((tm%60) <= 9) {
                        sec_label.setText("0" + (tm%60));
                    } else {
                        sec_label.setText("" + (tm%60));
                    }
                }
            }
        });
        
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
            Window2 w2 = new Window2(isWork);
        }
    }

   
}
