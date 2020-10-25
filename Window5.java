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
    private Date date_start;
    private Date date_finish;
    private int sec = 0;
    private int min = 0;
    private int hr = 0;

    public Window5(int hr, int min, int sec, boolean isWork) {
        date_start = new Date(System.currentTimeMillis() - hr*3600000 - min*60000 - sec*1000);
        date_finish = new Date(System.currentTimeMillis());

        this.hr = hr;
        this.min = min;
        this.sec = sec;

        panel = new JPanel();
        frame = new JFrame("Finished");
        frame.setSize(350,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);

        submit = new JButton("Start");
        submit.setBounds(95,175,150,25);
        submit.addActionListener(this); 
        panel.add(submit);


        frame.setVisible(true);
    }

    // private void create_csv(int hr, int min, int sec) throws IOException {

    //     String pattern = "MM/dd/yyyy HH:mm:ss";

    //     DateFormat df = new SimpleDateFormat(pattern);

    //     String before = df.format(date_start);
    //     String now = df.format(date_finish);

    //     FileWriter pw = new FileWriter("data.csv", true);
    //     pw.append(before);
    //     pw.sappend(",");
    //     pw.append(now);
    //     pw.append(",");
    //     pw.append(""+hr);
    //     pw.append("\n");
    //     pw.flush();
    //     pw.close();


    // }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            // try {
            //     create_csv(hr,min,sec);
            // } catch (IOException ex) {
            //     System.out.println("Error");
            // }
            System.out.println("LeBron");
        }
        
    }
}