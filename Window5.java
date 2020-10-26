import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Window5 implements ActionListener {
	private JFrame frame;
    private JPanel panel;
    private JButton submit;
    private JTextField d;
    private Date date_start;
    private Date date_finish;
    private int sec;
    private int min;
    private int hr;
    private boolean isWork;

    public Window5(int hr, int min, int sec, boolean isWork) {
        date_start = new Date(System.currentTimeMillis() - hr*3600000 - min*60000 - sec*1000);
        date_finish = new Date(System.currentTimeMillis());

        this.hr = hr;
        this.min = min;
        this.sec = sec;
        this.isWork = isWork;

        panel = new JPanel();
        frame = new JFrame("Finished");
        frame.setSize(550,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);

        panel.setLayout(null);

        JLabel finish = new JLabel("Describe what you did");
        finish.setBounds(195,52,200,50);
        finish.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        panel.add(finish);

        submit = new JButton("Submit");
        submit.setBounds(235,128,100,50);
        submit.addActionListener(this); 
        panel.add(submit);

        d = new JTextField("Description");
        d.setBounds(20,90,510,30);
        panel.add(d);


        frame.setVisible(true);
    }

    private void create_csv() throws IOException {

        String getValue = d.getText();

        String pattern = "MM/dd/yyyy HH:mm:ss";

        DateFormat df = new SimpleDateFormat(pattern);

        String before = df.format(date_start);
        String now = df.format(date_finish);

        FileWriter pw = new FileWriter("productivity_data.csv", true);
        pw.append(before);
        pw.append(",");
        pw.append(now);
        pw.append(",");
        String s;
        if (this.isWork == true) {
            s = "Work";
        } else {
            s = "Break";
        }
        pw.append(s);
        pw.append(",");
        pw.append(""+this.hr);
        pw.append(",");
        pw.append(""+this.min);
        pw.append(",");
        pw.append(""+this.sec);
        pw.append(",");
        pw.append(getValue);

        pw.append("\n");
        pw.flush();
        pw.close();

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            try {
                create_csv();
            } catch (IOException ex) {
                System.out.println("Error");
            }
            frame.setVisible(false);
            frame = null;
            Window1 w1 = new Window1();
        }
        
    }

}