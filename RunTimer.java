import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class RunTimer implements ActionListener {

	private JFrame frame;
    private JPanel panel;
    private JButton start, stop, reset, interrupt;
    private JLabel sec_label, min_label, hr_label, colon1, colon2;
    private int tm, tm_init;
    private Timer timer;
    private boolean isWork, isPaused = false, got_start_time = false, timer_started = false;
    private Date date_start;

    public RunTimer(int hr, int min, int sec, boolean isWork) {

        this.isWork = isWork;

        tm = hr*3600 + min*60 + sec;
        tm_init = tm;

        panel = new JPanel();
        panel.setLayout(null);
        frame = new JFrame("Timer");
        frame.setSize(250,325);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);

        colon1 = new JLabel(":");
        colon1.setFont(new Font("Times New Roman", Font.PLAIN, 44));
        colon1.setBounds(86,37,150,50);
        panel.add(colon1);

        colon2 = new JLabel(":");
        colon2.setFont(new Font("Times New Roman", Font.PLAIN, 44));
        colon2.setBounds(152,37,150,50);
        panel.add(colon2);

        hr_label = new JLabel("");
        if (hr <= 9) {
            hr_label.setText("0" + hr);
        } else {
            hr_label.setText("" + hr);
        }
        hr_label.setFont(new Font("Times New Roman", Font.PLAIN, 44));
        hr_label.setBounds(40,40,150,50);
        panel.add(hr_label);

        min_label = new JLabel("");
        if (min <= 9) {
            min_label.setText("0" + min);
        } else {
            min_label.setText("" + min);
        }
        min_label.setFont(new Font("Times New Roman", Font.PLAIN, 44));
        min_label.setBounds(105,40,150,50);
        panel.add(min_label);

        sec_label = new JLabel("");
        if (sec <= 9) {
            sec_label.setText("0" + sec);
        } else {
            sec_label.setText("" + sec);
        }
        sec_label.setFont(new Font("Times New Roman", Font.PLAIN, 44));
        sec_label.setBounds(170,40,150,50);
        panel.add(sec_label);

        start = new JButton("Start");
        start.setBounds(15,145,110,65);
        start.addActionListener(this); 
        panel.add(start);

        stop = new JButton("Pause");
        stop.setBounds(125,145,110,65);
        stop.addActionListener(this); 
        panel.add(stop);

        reset = new JButton("Reset");
        reset.setBounds(15,210,110,65);
        reset.addActionListener(this); 
        panel.add(reset);

        interrupt = new JButton("Interrupt");
        interrupt.setBounds(125,210,110,65);
        interrupt.addActionListener(this); 
        panel.add(interrupt);

        frame.setVisible(true);

        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tm == 0){
                    Sound f = new Sound();
                    f.playSound();
                    timer.stop();
                    frame.dispose();
                    new DescriptionBox(date_start, hr, min, sec, isWork, false, isPaused);
                } else {
                    tm --;
                    int hr_temp = (int) tm/3600;
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
            if (got_start_time == false) {
                date_start = new Date(System.currentTimeMillis()+1000);
                got_start_time = true;
            }
            timer.start();
    		timer_started = true;
     	} else if (e.getSource() == stop) {
            if (got_start_time == true) {
                isPaused = true;
            }
     		timer.stop();
     		timer_started = false;
     	} else if (e.getSource() == reset) {
            timer.stop();
            frame.dispose();
            new SetTimer(isWork);
        } else if (e.getSource() == interrupt) {
            timer.stop();
            frame.dispose();
            int tm_worked = tm_init - tm;
            int hr_left = (int) tm_worked/3600;
            int min_left = (int) (tm_worked - (hr_left*3600))/60;
            int sec_left = tm_worked%60;
            new DescriptionBox(date_start, hr_left, min_left, sec_left, isWork, true, isPaused);
        }
    }

   
}
