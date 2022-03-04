package ItemGeneratorTest;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

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
import javax.swing.plaf.synth.SynthComboBoxUI;
import javax.swing.plaf.synth.SynthStyle;

public class UIFramework3 implements ActionListener, MouseListener {
    static String CYCLENUMBERDEFAULT = "030";
    static String MAXITEMSDEFAULT = "20";
    JFrame itemGeneratorFrame;
    JFileChooser openDirectory;
    int response;
    String selectedLocation;
    JPanel titlePanel;
    JPanel customizationPanel;
    JCheckBox cycleNumberBox;
    JTextField cycleNumberField;
    JCheckBox maxItemsBox;
    JTextField maxItemsField;
    JCheckBox aifDebitsOnlyBox;
    JButton executeButton;
    JLabel outputLocationLabel;
    JComboBox<String> outputLocationChoices;
    boolean cycleNumberFirstTime = true;
    boolean maxItemsFirstTime = true;
    JLabel logoLabel;
    JLabel localLabel;
    ImageIcon executeSelectedIcon;

    public UIFramework3() {

        //Initialize Global Variables
        response = JFileChooser.CANCEL_OPTION;
        selectedLocation = "";
        itemGeneratorFrame = new JFrame();
        openDirectory = new JFileChooser();
        titlePanel = new JPanel();
        customizationPanel = new JPanel();
        cycleNumberBox = new JCheckBox();
        cycleNumberField = new JTextField(5);
        maxItemsBox = new JCheckBox();
        maxItemsField = new JTextField();
        aifDebitsOnlyBox = new JCheckBox();
        executeButton = new JButton();
        outputLocationLabel = new JLabel();
        outputLocationChoices = new JComboBox<String>();
        logoLabel = new JLabel();
        localLabel = new JLabel();

        //Local Variables
        int componentHeight = 0;
        int verticalGap = 20;
        //Icon Font Open Sans
        //Website logomakr
        //Create Images/Icons
        ImageIcon argoIcon = new ImageIcon(".\\ItemGeneratorTest\\Images\\RealArgoIcon.png");
        ImageIcon argoLogo = new ImageIcon(".\\ItemGeneratorTest\\Images\\ArgoLogo.png");
        ImageIcon aifNotSelectedIcon = new ImageIcon(".\\ItemGeneratorTest\\Images\\AIFDebitsOnlyNotSelected.png");
        ImageIcon aifSelectedIcon = new ImageIcon(".\\ItemGeneratorTest\\Images\\AIFDebitsOnlySelected2.png");
        ImageIcon cycleNumberSelectedIcon = new ImageIcon(".\\ItemGeneratorTest\\Images\\CycleNumberSelected2.png");
        ImageIcon cycleNumberNotSelectedIcon = new ImageIcon(".\\ItemGeneratorTest\\Images\\CycleNumberNotSelected.png");
        ImageIcon maxItemsNotSelectedIcon = new ImageIcon(".\\ItemGeneratorTest\\Images\\MaxItemsNotSelected.png");
        ImageIcon maxItemsSelectedIcon = new ImageIcon(".\\ItemGeneratorTest\\Images\\MaxItemsSelected.png");
        ImageIcon selectLocationIcon = new ImageIcon(".\\ItemGeneratorTest\\Images\\SelectLocationIcon.png");
        ImageIcon executeIcon = new ImageIcon(".\\ItemGeneratorTest\\Images\\ExecuteIcon.png");
        ImageIcon executeSelectedIcon = new ImageIcon(".\\ItemGeneratorTest\\Images\\ExecuteSelectedIcon.png");
        logoLabel.setIcon(argoLogo);
        
        //Item Generator Frame
        //Set size should be 1000 x 600 but due to only small subset of features
        //added so far, dimensions are reduced
        itemGeneratorFrame.setSize(300,600);
        itemGeneratorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        itemGeneratorFrame.setLayout(null);
        itemGeneratorFrame.setIconImage(argoIcon.getImage());

        //Title Panel
        itemGeneratorFrame.add(titlePanel);
        titlePanel.setBounds(0,0,1000,100);
        titlePanel.setLayout(null);
        titlePanel.setBackground(new Color(255,0,47,255));
        titlePanel.add(logoLabel);
        logoLabel.setBounds(30,0, 100, 100);

        //Customization Panel
        itemGeneratorFrame.setLocationRelativeTo(null);
        itemGeneratorFrame.add(customizationPanel);
        customizationPanel.setBounds(0,100,1000,500);
        customizationPanel.setBackground(new Color(26,26,26,255));
        customizationPanel.setLayout(null);

        //Output Location
        customizationPanel.add(outputLocationLabel);
        customizationPanel.add(outputLocationChoices);
        customizationPanel.add(localLabel);
        outputLocationLabel.setBounds(10, componentHeight+verticalGap, 220, 15);
        outputLocationLabel.setIcon(selectLocationIcon);
        componentHeight += outputLocationLabel.getHeight()+verticalGap;

        outputLocationChoices.setBounds(20,componentHeight+verticalGap,100,36);
        outputLocationChoices.setBackground(new Color(59,59,59,255));
        outputLocationChoices.setForeground(new Color(255,0,47,255));
        outputLocationChoices.setFont(new Font("SansSerif", Font.PLAIN, 16));
        outputLocationChoices.setModel(new DefaultComboBoxModel<>(new String[] { "Choose..", "Local", "Database" }));
        outputLocationChoices.setToolTipText("Select the output location");
        outputLocationChoices.addActionListener(this);
        outputLocationChoices.setFocusable(false);

        localLabel.setBounds((int)outputLocationChoices.getLocation().getX()+outputLocationChoices.getWidth()+10, componentHeight+verticalGap, 100, 36);
        localLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        localLabel.setForeground(new Color(161, 61, 61));
        localLabel.setText("");

        componentHeight += outputLocationChoices.getHeight()+verticalGap;
        //Cycle Number
        customizationPanel.add(cycleNumberBox);
        customizationPanel.add(cycleNumberField);

        cycleNumberBox.setBounds(0,componentHeight+verticalGap,190,36);
        cycleNumberBox.setOpaque(false);
        cycleNumberBox.setIcon(cycleNumberNotSelectedIcon);
        cycleNumberBox.setSelectedIcon(cycleNumberSelectedIcon);
        cycleNumberBox.addActionListener(this);

        cycleNumberField.setBounds(210,componentHeight+verticalGap,60,36);
        cycleNumberField.setBackground(new Color(59,59,59,255));
        cycleNumberField.setCaretColor(new Color(255,0,47,255));
        cycleNumberField.setForeground(new Color(158, 158, 158));
        cycleNumberField.setText("030");
        cycleNumberField.setEditable(false);
        cycleNumberField.setFont(new Font("Open Sans", Font.PLAIN, 18));
        cycleNumberField.setBorder(BorderFactory.createEmptyBorder());
        cycleNumberField.addMouseListener(this);
        componentHeight += cycleNumberBox.getHeight()+verticalGap;
        
        //Max Items
        customizationPanel.add(maxItemsBox);
        customizationPanel.add(maxItemsField);

        maxItemsBox.setBounds(0,componentHeight + verticalGap, 190, 36);
        maxItemsBox.setOpaque(false);
        maxItemsBox.setIcon(maxItemsNotSelectedIcon);
        maxItemsBox.setSelectedIcon(maxItemsSelectedIcon);
        maxItemsBox.addActionListener(this);
        

        maxItemsField.setBounds(210,componentHeight+verticalGap,60,36);
        maxItemsField.setFont(new Font("Open Sans", Font.PLAIN, 18));
        maxItemsField.setText("20");
        maxItemsField.setDisabledTextColor(new Color(61,61,61,255));
        maxItemsField.setBackground(new Color(59,59,59,255));
        maxItemsField.setCaretColor(new Color(255,0,47,255));
        maxItemsField.setForeground(new Color(158, 158, 158));
        maxItemsField.setEditable(false);
        maxItemsField.setBorder(BorderFactory.createEmptyBorder());
        maxItemsField.addMouseListener(this);

        componentHeight += maxItemsBox.getHeight()+verticalGap;

        //AIF Debits Only Check Box
        //Dimensions of icon 177x36 px
        customizationPanel.add(aifDebitsOnlyBox);
        aifDebitsOnlyBox.setBounds(0,componentHeight + verticalGap, 200, 40);
        aifDebitsOnlyBox.setOpaque(false);
        aifDebitsOnlyBox.setIcon(aifNotSelectedIcon);
        aifDebitsOnlyBox.setSelectedIcon(aifSelectedIcon);
        aifDebitsOnlyBox.addActionListener(this);

        componentHeight += aifDebitsOnlyBox.getHeight()+verticalGap;

        //Execute Button
        customizationPanel.add(executeButton);

        executeButton.setBounds(16, componentHeight + verticalGap, 178, 32);
        executeButton.setOpaque(false);
        executeButton.setIcon(executeIcon);
        executeButton.setBackground(new Color(26,26,26,255));
        executeButton.setBorder(BorderFactory.createEmptyBorder());
        executeButton.addActionListener(this);
        executeButton.setFocusable(false);
        executeButton.setPressedIcon(executeSelectedIcon);

        componentHeight += executeButton.getHeight()+verticalGap;



        itemGeneratorFrame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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
        
        if(e.getSource() == cycleNumberBox) {
            if(cycleNumberBox.isSelected()) {
                cycleNumberField.setForeground(new Color(255,0,47,255));
                cycleNumberField.setEditable(true);
            }
            else {
                cycleNumberField.setForeground(new Color(158, 158, 158));
                cycleNumberField.setEditable(false);
            }
        }
        if(e.getSource() == maxItemsBox) {
            if(maxItemsBox.isSelected()) {
                maxItemsField.setForeground(new Color(255,0,47,255));
                maxItemsField.setEditable(true);
            }
            else {
                maxItemsField.setForeground(new Color(158, 158, 158));
                maxItemsField.setEditable(false);
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
                output += ".\\ItemGenerator ";
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
                if(aifDebitsOnlyBox.isSelected()) {
                    System.out.println("AIF Debits Only is selected.");
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

