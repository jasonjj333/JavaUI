package GUITesting;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class myFrame extends JFrame implements ActionListener{

    JButton button;
    
    myFrame() {

        //JButton
        button = new JButton();
        button.setBounds(200,100,100,50); //x,y,length, height
        button.addActionListener(this);
        //below code does not need to implement ActionListener and does not need seperate method
        //button.addActionListener(e -> System.out.println("You clicked it."));

        // JFrame = GUI window to add components to
        this.setTitle("GUI Test 2"); //sets title of this
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit application
        this.setResizable(false); //prevent this from being resized
        this.setSize(500,500); //sets x, y dimensions of this
        this.setVisible(true);
        ImageIcon image = new ImageIcon("ArgoIcon.png"); //create image icon
        this.setIconImage(image.getImage()); //change icon on this
        this.getContentPane().setBackground(new Color(180, 20, 80)); //change color of background
        this.add(button);
        
        
        this.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button) {
            System.out.println("You have clicked the button.");
        }
        
    }
}
