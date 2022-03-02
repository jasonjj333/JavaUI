package GUITesting;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GuiTest2 {
    public static void main(String[] args) {
    // JFrame = GUI window to add components to
    myFrame frame = new myFrame();
    // JLabel = GUI display area for a string of text, an image, or both
    JLabel label = new JLabel(); //create a label
    //label.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT, CENTER, RIGHT of icon
    //label.setVerticalTextPosition(JLabel.TOP); //set text TOP, CENTER, BOTTOM of icon
    label.setForeground(Color.WHITE); //changes font color
    label.setFont(new Font("Arial", Font.PLAIN, 20));
    label.setText("Item Generator"); //set text of label
    label.setVerticalAlignment(JLabel.TOP); //set vertical position of label
    label.setHorizontalAlignment(JLabel.CENTER); //set horizontal position of label
    //label.setBounds(150,0,250,250); //set x,y position within frame and dimensions
    

    frame.add(label);
    frame.setVisible(true);
    //frame.pack(); //frame size will adjust to fit all labels in frame

    }   
}
