import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.util.TimerTask;

public class Window2 implements ActionListener, ItemListener {
	private JFrame frame;
    private JPanel panel;
    private JButton start;
    private int min;
    private int sec;
    private JComboBox<Integer> sec_list = new JComboBox<Integer>();
    private JComboBox<Integer> min_list = new JComboBox<Integer>();

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



        for (int i=0; i<=60; i++) {
        	sec_list.addItem(i);
        }

		sec_list.setSelectedIndex(0);
		sec_list.addItemListener(this);
		sec_list.setSize(70,40);
		sec_list.setLocation(200,200);
		sec_list.setEditable(true);
    	sec_list.setVisible(true);
    	sec_list.setEditable(false);
		panel.add(sec_list);


        for (int i=0; i<=60; i++) {
        	min_list.addItem(i);
        }

		min_list.setSelectedIndex(0);
		min_list.addItemListener(this);
		min_list.setSize(70,40);
		min_list.setLocation(300,300);
		min_list.setEditable(true);
    	min_list.setVisible(true);
    	min_list.setEditable(false);
		panel.add(min_list);



        frame.setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {
            Window3 w3 = new Window3(min, sec);
            System.out.println("Lebron");
     	}
     	System.out.println("KObe");
    }

    public void itemStateChanged(ItemEvent e1) {
        if (e1.getSource() == sec_list) {
        	sec = (Integer)sec_list.getSelectedItem();
        } else if (e1.getSource() == min_list){
        	min = (Integer)min_list.getSelectedItem();
        }
    }
    
}
