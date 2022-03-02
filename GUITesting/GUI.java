package GUITesting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements ActionListener {
    int count = 0;
    JLabel label;
    JFrame frame;
    JPanel panel;
    public GUI(){
        frame = new JFrame();
        panel = new JPanel();
        label = new JLabel("Number of clicks: 0");
        JButton button = new JButton();
        button.addActionListener(this);

        button.add(label);
        //create border with dimensions (top, bottom, left, right)
        panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 100, 300));
        // panel.setLayout(new GridLayout(0,1));
        //add button
        panel.add(button);

        //General setup for frame
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Test GUI");
        frame.setBounds(500,150,500,500);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new GUI();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("Number of clicks: " + count);
        
    }
}
