import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DescriptionBox implements ActionListener {

	private JFrame frame;
    private JPanel panel;
    private JButton submit;
    private JTextField d;
    private Date date_start, date_finish;
    private int hr, min, sec;
    private boolean isWork, isInterrupted;

    public DescriptionBox(Date started, int hr, int min, int sec, boolean isWork, boolean isInterrupted, boolean isPaused) {

        this.date_start = new Date(System.currentTimeMillis() - 3600000*hr - 60000*min - 1000*sec);
        date_finish = new Date(System.currentTimeMillis());
        
        if (started != null && isPaused == true) {
            this.date_start = started;
        }

        this.hr = hr;
        this.min = min;
        this.sec = sec;
        this.isWork = isWork;
        this.isInterrupted = isInterrupted;

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

        d = new JTextField();
        d.setBounds(20,90,510,30);
        panel.add(d);


        frame.setVisible(true);
    }

    private void create_csv() throws IOException {

        String getValue = d.getText();

        String pattern = "MM/dd/yyyy HH:mm:ss z";

        DateFormat df = new SimpleDateFormat(pattern);

        String before = df.format(date_start);
        String now = df.format(date_finish);

        FileWriter pw = new FileWriter("productivity_data.csv", true);
        pw.append("\n");
        pw.append(before);
        pw.append(",");
        pw.append(now);
        pw.append(",");

        String s1;
        if (this.isWork == true) {
            s1 = "Work";
        } else {
            s1 = "Break";
        }

        pw.append(s1);
        pw.append(",");
        if (isInterrupted == true) {
            pw.append("yes");
        } else {
            pw.append("no");
        }
        pw.append(",");
        pw.append("" + this.hr);
        pw.append(",");
        pw.append("" + this.min);
        pw.append(",");
        pw.append("" + this.sec);
        pw.append(",");
        pw.append("\"");
        pw.append(getValue);
        pw.append("\"");

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
            frame.dispose();
            new Init_Window();
        }
        
    }

}