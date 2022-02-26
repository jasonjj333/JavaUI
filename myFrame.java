import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class myFrame extends JFrame{
    
    myFrame() {
        // JFrame = GUI window to add components to
        this.setTitle("GUI Test 2"); //sets title of this
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit application
        this.setResizable(false); //prevent this from being resized
        this.setSize(500,500); //sets x, y dimensions of this
        this.setVisible(true);
        ImageIcon image = new ImageIcon("ArgoIcon.png"); //create image icon
        this.setIconImage(image.getImage()); //change icon on this
        this.getContentPane().setBackground(new Color(180, 20, 80)); //change color of background
        
        
        //this.setLayout(null);
    }
}
