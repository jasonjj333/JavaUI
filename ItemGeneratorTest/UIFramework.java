package ItemGeneratorTest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class UIFramework implements ActionListener {
    JFrame frame;
    JButton executeButton;
    JPanel custPanel;
    JPanel exPanel;

    JPanel cycleNumberPanel;
    JCheckBox cycleNumberBox;
    JTextPane cycleNumberField;

    JPanel maxItemPanel;
    JCheckBox maxItemBox;
    JTextPane maxItemField;

    public UIFramework() {
        //JFrame
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Item Generator Test");
        frame.setFont(new Font("Arial",Font.BOLD, 20));
        frame.setBounds(500,150,450,600);
        frame.setLayout(null);
        frame.setResizable(false);

        //ImageIcon
        ImageIcon argoIcon = new ImageIcon("RealArgoIcon.png");
        frame.setIconImage(argoIcon.getImage());

        //Customization Panel
        custPanel = new JPanel();
        custPanel.setBounds(0,0,450, 500);
        custPanel.setBackground(new Color(161, 61, 61));
        custPanel.setLayout(null);

        //*****CUSTOMIZATION PANEL FEATURES*****
        //Cycle Number
        cycleNumberPanel = new JPanel();
        cycleNumberPanel.setBounds(0,0,200,150);
        cycleNumberPanel.setBackground(new Color(161, 61, 61));

        cycleNumberBox = new JCheckBox();
        cycleNumberBox.setText("Cycle Number");
        cycleNumberBox.setFocusable(false);
        cycleNumberBox.addActionListener(this);
        cycleNumberBox.setBounds(0,0,100,50);
        cycleNumberBox.setForeground(Color.white);
        cycleNumberBox.setBackground(new Color(161, 61, 61));

        cycleNumberField = new JTextPane();
        cycleNumberField.setPreferredSize(new Dimension(50,20));
        cycleNumberField.setVisible(false);

        cycleNumberPanel.add(cycleNumberBox);
        cycleNumberPanel.add(cycleNumberField);

        //Max Item

        maxItemPanel = new JPanel();
        maxItemPanel.setBounds(0,200,200,150);
        maxItemPanel.setBackground(Color.blue);

        maxItemBox = new JCheckBox();
        maxItemBox.setText("Max Item");
        maxItemBox.setFocusable(false);
        maxItemBox.addActionListener(this);
        maxItemBox.setBounds(0,0,100,50);
        maxItemBox.setForeground(Color.white);
        maxItemBox.setBackground(new Color(161, 61, 61));

        maxItemField = new JTextPane();
        maxItemField.setPreferredSize(new Dimension(50,20));
        maxItemField.setVisible(false);

        //Execute Panel
        exPanel = new JPanel();
        exPanel.setBounds(0,500,450,100);
        exPanel.setBackground(new Color(161, 61, 61));

        //Execute Button
        executeButton = new JButton();
        executeButton.setBounds(50,50, 150, 75);
        executeButton.setText("Execute");
        executeButton.setFocusable(false);
        executeButton.addActionListener(this);
        // executeButton.setBackground(Color.WHITE);
        // executeButton.setBorder(BorderFactory.createEtchedBorder());
        exPanel.add(executeButton);


        //add to frame and execute
        custPanel.add(cycleNumberPanel);
        frame.add(custPanel);
        frame.add(exPanel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==executeButton){
            System.out.println("Item Generator executed.");
            if(cycleNumberBox.isSelected()) {
                System.out.println("Cycle Number: " + cycleNumberField.getText());
            }
        }
        if(e.getSource() == cycleNumberBox) {
            if(cycleNumberBox.isSelected())
                cycleNumberField.setVisible(true);
            else
                cycleNumberField.setVisible(false);
            //frame.setVisible(true);
        }
        
    }
}
