import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window2 implements ActionListener, ItemListener {
	private JFrame frame;
    private JPanel panel;
    private JButton start;
    private JButton back;
    private int sec = 0;
    private int min = 0;
    private int hr = 0;
    private JComboBox<Integer> sec_list = new JComboBox<Integer>();
    private JComboBox<Integer> min_list = new JComboBox<Integer>();
    private JComboBox<Integer> hr_list = new JComboBox<Integer>();
    private boolean isWork;

    public Window2(boolean isWork) {


        this.isWork = isWork;

        panel = new JPanel();
        frame = new JFrame("Set Timer");
        frame.setSize(350,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);

        panel.setLayout(null);

        JLabel label = new JLabel("Set Timer");
        label.setFont(new Font("Times New Roman", Font.BOLD, 22));
        label.setBounds(124,50,250,25);
        panel.add(label);

        JLabel hr_label = new JLabel("Hours");
        hr_label.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        hr_label.setBounds(58,95,150,25);
        panel.add(hr_label);

        JLabel min_label = new JLabel("Minutes");
        min_label.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        min_label.setBounds(142,95,150,25);
        panel.add(min_label);

        JLabel sec_label = new JLabel("Seconds");
        sec_label.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        sec_label.setBounds(225,95,150,25);
        panel.add(sec_label);

        start = new JButton("Start");
        start.setBounds(95,175,150,25);
        start.addActionListener(this); 
        panel.add(start);

        back = new JButton("Back");
        back.setBounds(12,10,50,35);
        back.addActionListener(this); 
        panel.add(back);


        for (int i=0; i<60; i++) {
        	sec_list.addItem(i);
        }

		sec_list.setSelectedIndex(0);
		sec_list.addItemListener(this);
		sec_list.setSize(75,75);
		sec_list.setLocation(215,98);
		sec_list.setEditable(true);
    	sec_list.setVisible(true);
    	sec_list.setEditable(false);
		panel.add(sec_list);


        for (int i=0; i<60; i++) {
        	min_list.addItem(i);
        }

		min_list.setSelectedIndex(0);
		min_list.addItemListener(this);
		min_list.setSize(75,75);
		min_list.setLocation(130,98);
		min_list.setEditable(true);
    	min_list.setVisible(true);
    	min_list.setEditable(false);
		panel.add(min_list);

        for (int i=0; i<24; i++) {
            hr_list.addItem(i);
        }

        hr_list.setSelectedIndex(0);
        hr_list.addItemListener(this);
        hr_list.setSize(75,75);
        hr_list.setLocation(40,98);
        hr_list.setEditable(true);
        hr_list.setVisible(true);
        hr_list.setEditable(false);
        panel.add(hr_list);


        frame.setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {
            Window4 w4;
            if (3600*hr + 60*min + sec == 0) {
                w4 = new Window4();
            } else {
                w4 = null;
                frame.setVisible(false);
                frame = null;
                Window3 w3 = new Window3(hr, min, sec, isWork);
            }
     	} else if (e.getSource() == back) {
            frame.setVisible(false);
            frame = null;
            Window1 w1 = new Window1();
        }
    }

    public void itemStateChanged(ItemEvent e1) {
        if (e1.getSource() == sec_list) {
        	sec = (Integer)sec_list.getSelectedItem();
        } else if (e1.getSource() == min_list){
        	min = (Integer)min_list.getSelectedItem();
        } else if (e1.getSource() == hr_list){
            hr = (Integer)hr_list.getSelectedItem();
        }
    }
    
}
