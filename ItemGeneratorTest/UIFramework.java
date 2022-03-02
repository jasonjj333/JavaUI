
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UIFramework {
    public UIFramework() {
        //JFrame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Item Generator Test");
        frame.setFont(new Font("Arial",Font.BOLD, 20));
        frame.setBounds(500,150,450,600);
        frame.setLayout(null);
        
        //ImageIcon
        ImageIcon argoIcon = new ImageIcon("RealArgoIcon.png");
        frame.setIconImage(argoIcon.getImage());

        //Customization Panel
        JPanel custPanel = new JPanel();
        custPanel.setBounds(0,0,450, 500);
        custPanel.setBackground(Color.RED);
        

        //Execute Panel
        JPanel exPanel = new JPanel();
        exPanel.setBounds(0,500,450,100);
        exPanel.setBackground(Color.blue);

        //Execute Button
        JButton executeButton = new JButton();
        executeButton.setBounds(50,50, 150, 75);
        executeButton.setText("Execute");
        executeButton.setFocusable(false);
        // executeButton.setBackground(Color.WHITE);
        // executeButton.setBorder(BorderFactory.createEtchedBorder());
        exPanel.add(executeButton);

        frame.add(custPanel);
        frame.add(exPanel);
        frame.setVisible(true);
    }
}
