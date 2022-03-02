package ItemGeneratorTest;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UIFramework implements ActionListener {
    JFrame frame;
    JButton executeButton;
    JPanel custPanel;
    JPanel exPanel;
    public UIFramework() {
        //JFrame
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Item Generator Test");
        frame.setFont(new Font("Arial",Font.BOLD, 20));
        frame.setBounds(500,150,450,600);
        frame.setLayout(null);
        
        //ImageIcon
        ImageIcon argoIcon = new ImageIcon("RealArgoIcon.png");
        frame.setIconImage(argoIcon.getImage());

        //Customization Panel
        custPanel = new JPanel();
        custPanel.setBounds(0,0,450, 500);
        custPanel.setBackground(new Color(161, 61, 61));
        
        

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
        frame.add(custPanel);
        frame.add(exPanel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==executeButton){
            System.out.println("Item Generator executed.");
        }
        
    }
}
