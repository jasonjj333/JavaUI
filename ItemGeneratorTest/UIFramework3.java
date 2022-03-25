package ItemGeneratorTest;


import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import java.awt.geom.RoundRectangle2D;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

public class UIFramework3 implements ActionListener, MouseListener {
    static String CYCLENUMBERDEFAULT = "030";
    static String MAXITEMSDEFAULT = "20";
    static Color BACKGROUNDCOLOR = new Color(6, 44, 48);
    static Color FOREGROUNDCOLOR = new Color(5, 89, 91);
    static Color TEXTCOLOR = new Color(245, 245, 245);
    static Color DARKCOLOR = new Color(61,61,61,255);
    static Color DARKTEXTCOLOR = new Color(158,158,158);
    JFrame itemGeneratorFrame;
    JFileChooser openDirectory;
    int response;
    String selectedLocation;
    JPanel titlePanel;
    JPanel customizationPanel;
    OvalCheck cycleNumberBox;
    JTextField cycleNumberField;
    OvalCheck maxItemsBox;
    JTextField maxItemsField;
    OvalCheck aifBox;
    OvalButton executeButton;
    JLabel outputLocationLabel;
    JComboBox<String> outputLocationChoices;
    boolean cycleNumberFirstTime = true;
    boolean maxItemsFirstTime = true;
    JLabel logoLabel;
    JLabel localLabel;
    ImageIcon executeSelectedIcon;
    JLabel textIconLabel;
    JButton closeButton;
    Font openSans16;
    ImageIcon checkIcon;
    JPanel dragPanel;
    JLabel minimizeButton;

    public UIFramework3() {

        //Initialize Global Variables
        response = JFileChooser.CANCEL_OPTION;
        selectedLocation = "";
        itemGeneratorFrame = new JFrame();
        openDirectory = new JFileChooser();
        titlePanel = new JPanel();
        customizationPanel = new JPanel();
        cycleNumberBox = new OvalCheck(OvalCheck.SHAPE_CAPSULE,OvalCheck.HORIZONTAL, FOREGROUNDCOLOR, FOREGROUNDCOLOR, FOREGROUNDCOLOR, TEXTCOLOR);
        cycleNumberField = new JTextField(5);
        maxItemsBox = new OvalCheck(OvalCheck.SHAPE_CAPSULE,OvalCheck.HORIZONTAL, FOREGROUNDCOLOR, FOREGROUNDCOLOR, FOREGROUNDCOLOR, TEXTCOLOR);
        maxItemsField = new JTextField(5);
        aifBox = new OvalCheck(OvalCheck.SHAPE_CAPSULE,OvalCheck.HORIZONTAL, FOREGROUNDCOLOR, FOREGROUNDCOLOR, FOREGROUNDCOLOR, TEXTCOLOR);
        executeButton = new OvalButton(OvalButton.SHAPE_CAPSULE,OvalButton.HORIZONTAL, FOREGROUNDCOLOR, FOREGROUNDCOLOR, FOREGROUNDCOLOR, TEXTCOLOR);
        outputLocationLabel = new JLabel();
        outputLocationChoices = new JComboBox<String>();
        logoLabel = new JLabel();
        localLabel = new JLabel();
        textIconLabel = new JLabel();
        closeButton = new JButton();
        dragPanel = new JPanel();
        minimizeButton = new JLabel();

        //Local Variables
        int componentHeight = 0;
        int verticalGap = 20;
        //Icon Font Open Sans
        //Create Images/Icons
        ImageIcon argoIcon = new ImageIcon(".\\ItemGeneratorTest\\Images\\RealArgoIcon.png");
        ImageIcon argoLogo = new ImageIcon(".\\ItemGeneratorTest\\Images\\ArgoLogo.png");
        checkIcon = new ImageIcon(".\\ItemGeneratorTest\\Images\\CheckIcon.png");
        logoLabel.setIcon(argoLogo);

        //Fonts
        try {
            openSans16 = Font.createFont(Font.TRUETYPE_FONT, new File(".\\ItemGeneratorTest\\Fonts\\OpenSans-Regular.ttf")).deriveFont(16f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(".\\ItemGeneratorTest\\Fonts\\OpenSans-Regular.ttf")));
        }
        catch(IOException | FontFormatException e) {
        
        }
        
        //Item Generator Frame
        //Set size should be 1000 x 600 but due to only small subset of features
        //added so far, dimensions are reduced
        itemGeneratorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        itemGeneratorFrame.setLayout(null);
        itemGeneratorFrame.setIconImage(argoIcon.getImage());
        itemGeneratorFrame.setUndecorated(true);
        //itemGeneratorFrame.setShape(new RoundRectangle2D.Double(10, 10, 100, 100, 50, 50));
        itemGeneratorFrame.setSize(1000,600);
        itemGeneratorFrame.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        itemGeneratorFrame.setLocationRelativeTo(null);

        //Title Panel
        itemGeneratorFrame.add(titlePanel);
        titlePanel.setBounds(0,0,1000,100);
        titlePanel.setLayout(null);
        titlePanel.setBackground(FOREGROUNDCOLOR);
        titlePanel.add(logoLabel);
        logoLabel.setBounds(30,0, 100, 100);

        //makes window able to be dragged
        titlePanel.add(dragPanel);
        dragPanel.setBounds(0,0,900,100);
        PanelDragListener panelDragListener = new PanelDragListener(dragPanel,itemGeneratorFrame);
        dragPanel.addMouseListener(panelDragListener);
        dragPanel.addMouseMotionListener(panelDragListener);
        dragPanel.setOpaque(false);

        //Close Button
        titlePanel.add(closeButton);
        closeButton.setBounds(titlePanel.getWidth()-50, 0, 50,30);
        closeButton.setText("X");
        closeButton.setFont(openSans16);
        closeButton.setForeground(TEXTCOLOR);
        //closeButton.setIcon(closeIcon);
        closeButton.setOpaque(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setBorderPainted(false);
        closeButton.setFocusable(false);
        closeButton.addActionListener(this);

        //Minimize Button
        titlePanel.add(minimizeButton);
        minimizeButton.setBounds(closeButton.getX()-30,-2,30,30);
        minimizeButton.setText("__");
        minimizeButton.setFont(openSans16);
        minimizeButton.setForeground(TEXTCOLOR);
        minimizeButton.setOpaque(false);
        minimizeButton.setFocusable(false);
        minimizeButton.addMouseListener(this);


        //Customization Panel
        itemGeneratorFrame.add(customizationPanel);
        customizationPanel.setBounds(0,100,1000,500);
        customizationPanel.setBackground(BACKGROUNDCOLOR);
        customizationPanel.setLayout(null);

        //Output Location
        customizationPanel.add(outputLocationLabel);
        customizationPanel.add(outputLocationChoices);
        customizationPanel.add(localLabel);
        outputLocationLabel.setBounds(10, componentHeight+verticalGap, 220, 20);
        outputLocationLabel.setText("Select Output Location");
        outputLocationLabel.setFont(openSans16);
        outputLocationLabel.setForeground(TEXTCOLOR);
        //outputLocationLabel.setIcon(selectLocationIcon);
        componentHeight += outputLocationLabel.getHeight()+verticalGap;

        outputLocationChoices.setBounds(20,componentHeight+verticalGap,100,36);
        outputLocationChoices.setBackground(new Color(59,59,59,255));
        outputLocationChoices.setForeground(TEXTCOLOR);
        outputLocationChoices.setFont(openSans16);
        outputLocationChoices.setModel(new DefaultComboBoxModel<>(new String[] { "Choose..", "Local", "Database" }));
        outputLocationChoices.setToolTipText("Select the output location");
        outputLocationChoices.addActionListener(this);
        outputLocationChoices.setFocusable(false);

        localLabel.setBounds((int)outputLocationChoices.getLocation().getX()+outputLocationChoices.getWidth()+10, componentHeight+verticalGap, 100, 36);
        localLabel.setFont(openSans16);
        localLabel.setForeground(TEXTCOLOR);
        localLabel.setText("");

        componentHeight += outputLocationChoices.getHeight()+verticalGap;

        //Cycle Number
        customizationPanel.add(cycleNumberBox);
        customizationPanel.add(cycleNumberField);
        cycleNumberBox.setBounds(15,componentHeight+verticalGap,190,36);
        cycleNumberBox.setText("Cycle Number");
        cycleNumberBox.setForeground(TEXTCOLOR);
        cycleNumberBox.setFont(openSans16);
        cycleNumberBox.setRadius(.16);
        cycleNumberBox.setBorderThickness(0);
        cycleNumberBox.setHorizontalAlignment(JCheckBox.CENTER);

        //cycleNumberBox.setOpaque(false);
        //cycleNumberBox.setIcon(cycleNumberNotSelectedIcon);
        //cycleNumberBox.setSelectedIcon(cycleNumberSelectedIcon);
        cycleNumberBox.addActionListener(this);

        cycleNumberField.setBounds(220,componentHeight+verticalGap,60,36);
        cycleNumberField.setBackground(new Color(59,59,59,255));
        cycleNumberField.setCaretColor(FOREGROUNDCOLOR);
        cycleNumberField.setForeground(DARKTEXTCOLOR);
        cycleNumberField.setText("030");
        cycleNumberField.setEditable(false);
        cycleNumberField.setFont(openSans16);
        cycleNumberField.setBorder(BorderFactory.createEmptyBorder());
        cycleNumberField.addMouseListener(this);
        cycleNumberField.setHorizontalAlignment(JCheckBox.RIGHT);
        //textIconLabel.setBounds(cycleNumberField.getX() + cycleNumberField.getWidth(), cycleNumberField.getY(), 36,36);
        //textIconLabel.setIcon(textFieldDisabledIcon);
        //textIconLabel.setBackground(Color.WHITE);

        componentHeight += cycleNumberBox.getHeight()+verticalGap;

        
        //Max Items
        customizationPanel.add(maxItemsBox);
        customizationPanel.add(maxItemsField);

        maxItemsBox.setBounds(15,componentHeight + verticalGap, 190, 36);
        maxItemsBox.setText("Max Items");
        maxItemsBox.setFont(openSans16);
        maxItemsBox.setForeground(TEXTCOLOR);
        maxItemsBox.setRadius(.16);
        maxItemsBox.setBorderThickness(0);
        maxItemsBox.setHorizontalAlignment(JCheckBox.CENTER);
        maxItemsBox.addActionListener(this);
        

        maxItemsField.setBounds(220,componentHeight+verticalGap,60,36);
        maxItemsField.setFont(openSans16);
        maxItemsField.setText("20");
        maxItemsField.setBackground(new Color(59,59,59,255));
        maxItemsField.setCaretColor(FOREGROUNDCOLOR);
        maxItemsField.setForeground(DARKTEXTCOLOR);
        maxItemsField.setEditable(false);
        maxItemsField.setBorder(BorderFactory.createEmptyBorder());
        maxItemsField.setHorizontalAlignment(JCheckBox.RIGHT);
        maxItemsField.addMouseListener(this);

        componentHeight += maxItemsBox.getHeight()+verticalGap;

        //AIF Debits Only Check Box
        //Dimensions of icon 177x36 px
        customizationPanel.add(aifBox);
        aifBox.setBounds(15,componentHeight + verticalGap, 190, 36);
        aifBox.setOpaque(false);
        aifBox.setText("AIF");
        aifBox.setIcon(checkIcon);
        aifBox.setFont(openSans16);
        aifBox.setHorizontalAlignment(JCheckBox.CENTER);
        aifBox.setForeground(TEXTCOLOR);
        aifBox.setRadius(.16);
        aifBox.setBorderThickness(0);
        aifBox.addActionListener(this);

        componentHeight += aifBox.getHeight()+verticalGap;

        //Execute Button
        customizationPanel.add(executeButton);

        executeButton.setBounds(16, componentHeight + verticalGap, 190, 36);
        executeButton.setText("Execute");
        executeButton.setFont(openSans16);
        executeButton.setForeground(TEXTCOLOR);
        executeButton.setBorderThickness(0);
        executeButton.setRadius(.16);
        executeButton.setBorder(BorderFactory.createEmptyBorder());
        executeButton.addActionListener(this);
        executeButton.setFocusable(false);

        componentHeight += executeButton.getHeight()+verticalGap;



        itemGeneratorFrame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == minimizeButton) {
            itemGeneratorFrame.setState(JFrame.ICONIFIED);
        }
        if(e.getSource() == cycleNumberField) {
            if(cycleNumberFirstTime && cycleNumberBox.isSelected()) {
                cycleNumberFirstTime = false;
                cycleNumberField.setText("");
            }
        }
        if(e.getSource() == maxItemsField) {
            if(maxItemsFirstTime && maxItemsBox.isSelected()) {
                maxItemsFirstTime = false;
                maxItemsField.setText("");
            }
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == closeButton) {
            itemGeneratorFrame.setVisible(false); //you can't see me!
            itemGeneratorFrame.dispose(); //Destroy the JFrame object
        }
        if(e.getSource() == cycleNumberBox) {
            if(cycleNumberBox.isSelected()) {
                cycleNumberField.setForeground(TEXTCOLOR);
                cycleNumberField.setEditable(true);
                cycleNumberBox.setColorNormal(TEXTCOLOR);
                cycleNumberBox.setForeground(FOREGROUNDCOLOR);
                cycleNumberBox.setColorHighlighted(TEXTCOLOR);
            }
            else {
                cycleNumberField.setForeground(DARKTEXTCOLOR);
                cycleNumberField.setEditable(false);
                cycleNumberBox.setColorNormal(FOREGROUNDCOLOR);
                cycleNumberBox.setForeground(TEXTCOLOR);
                cycleNumberBox.setColorHighlighted(FOREGROUNDCOLOR);
            }
        }
        if(e.getSource() == maxItemsBox) {
            if(maxItemsBox.isSelected()) {
                maxItemsField.setForeground(TEXTCOLOR);
                maxItemsField.setEditable(true);
                maxItemsBox.setColorNormal(TEXTCOLOR);
                maxItemsBox.setForeground(FOREGROUNDCOLOR);
                maxItemsBox.setColorHighlighted(TEXTCOLOR);
            }
            else {
                maxItemsField.setForeground(DARKTEXTCOLOR);
                maxItemsField.setEditable(false);
                maxItemsBox.setColorNormal(FOREGROUNDCOLOR);
                maxItemsBox.setForeground(TEXTCOLOR);
                maxItemsBox.setColorHighlighted(FOREGROUNDCOLOR);
            }
        }
        if(e.getSource() == aifBox) {
            if(aifBox.isSelected()) {
                aifBox.setColorNormal(TEXTCOLOR);
                aifBox.setForeground(FOREGROUNDCOLOR);
                aifBox.setColorHighlighted(TEXTCOLOR);
            }
            else {
                aifBox.setColorNormal(FOREGROUNDCOLOR);
                aifBox.setForeground(TEXTCOLOR);
                aifBox.setColorHighlighted(FOREGROUNDCOLOR);
            }
        }
        if(e.getSource() == executeButton) {
            boolean valid = true;
            //need to validate
            if(cycleNumberBox.isSelected()){
                try {
                    if(cycleNumberField.getText().equals("")) {
                        cycleNumberField.setText(CYCLENUMBERDEFAULT);
                    }
                    int d = Integer.parseInt(cycleNumberField.getText());
                } catch (NumberFormatException nfe) {
                    System.out.println("Cycle Number needs to be an Integer.");
                    valid = false;
                }
            }
            if(maxItemsBox.isSelected()) {
                try {
                    if(maxItemsField.getText().equals("")) {
                        maxItemsField.setText(MAXITEMSDEFAULT);
                    }
                    int f = Integer.parseInt(maxItemsField.getText());
                } catch (NumberFormatException nfe) {
                    System.out.println("Max Items needs to be an Integer.");
                    valid = false;
                }
            }
            if(outputLocationChoices.getSelectedIndex() == 0) {
                System.out.println("Please select output location.");
                valid = false;
            }

            if(valid) {
                System.out.println("Executing...");
                String output = "";
                output += ".\\bin\\ItemGenerator ";
                if(outputLocationChoices.getSelectedIndex()==2) {
                    System.out.println("Database Selected.");
                    output+= "-p \"Database\" ";
                }
                else if(response == JFileChooser.APPROVE_OPTION && !selectedLocation.equals("")) {
                    System.out.println("Local location: " + selectedLocation);
                    output += "-p "+ selectedLocation;
                }
                if(cycleNumberBox.isSelected() && !cycleNumberField.getText().equals("")) {
                    System.out.println("Cycle Number: " + cycleNumberField.getText());
                    output += " -c "+ cycleNumberField.getText();
                }
                else {
                    output += " -c "+ CYCLENUMBERDEFAULT;
                }
                if(maxItemsBox.isSelected()&& !maxItemsField.getText().equals("")) {
                    System.out.println("Max Items: " + maxItemsField.getText());
                    output += " --maxitems "+maxItemsField.getText();
                }
                else {
                    output += " --maxitems "+MAXITEMSDEFAULT;
                }
                if(aifBox.isSelected()) {
                    System.out.println("AIF is selected.");
                    output += " --aif";
                }

                System.out.print("CMD Command: " + output + "\n");
            }
        }
        if(e.getSource() == outputLocationChoices) {
            if(outputLocationChoices.getSelectedIndex() == 1) {
                openDirectory.setCurrentDirectory(new File("."));
                openDirectory.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                response = openDirectory.showOpenDialog(null);
                if(response == JFileChooser.APPROVE_OPTION) {
                    selectedLocation = openDirectory.getSelectedFile().getAbsolutePath();
                    localLabel.setText(selectedLocation);
                }
                else {
                    outputLocationChoices.setSelectedIndex(0);
                }
            }
            else if(outputLocationChoices.getSelectedIndex() == 2) {
                localLabel.setText("");
                selectedLocation = "";
                //implement code for when location output: database is selected.
            }
            else if(outputLocationChoices.getSelectedIndex() == 0) {
                localLabel.setText("");
                selectedLocation = "";
            }
        }
    }
    

    
}

