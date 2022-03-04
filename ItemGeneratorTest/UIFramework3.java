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

public class UIFramework3 implements ActionListener, MouseListener {
    
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

        //Local Variables
        ArrayList<Integer> componentHeights = new ArrayList<Integer>();

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
        logoLabel.setIcon(argoLogo);
        
        //Item Generator Frame
        itemGeneratorFrame.setSize(1000,600);
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

        //Cycle Number
        customizationPanel.add(cycleNumberBox);
        customizationPanel.add(cycleNumberField);

        cycleNumberBox.setBounds(0,10,190,36);
        componentHeights.add(cycleNumberBox.getHeight());
        cycleNumberBox.setOpaque(false);
        cycleNumberBox.setIcon(cycleNumberNotSelectedIcon);
        cycleNumberBox.setSelectedIcon(cycleNumberSelectedIcon);
        cycleNumberBox.addActionListener(this);

        cycleNumberField.setBounds(210,10,60,36);
        cycleNumberField.setBackground(new Color(59,59,59,255));
        cycleNumberField.setCaretColor(new Color(255,0,47,255));
        cycleNumberField.setForeground(new Color(255,0,47,255));
        cycleNumberField.setBorder(BorderFactory.createEmptyBorder());
        cycleNumberField.addMouseListener(this);
        
        //Max Items
        customizationPanel.add(maxItemsBox);
        customizationPanel.add(maxItemsField);

        maxItemsBox.setBounds(0, componentHeights.get(componentHeights.size()-1)+20, 190, 36);
        maxItemsBox.setOpaque(false);
        maxItemsBox.setIcon(maxItemsNotSelectedIcon);
        maxItemsBox.setSelectedIcon(maxItemsSelectedIcon);
        maxItemsBox.addActionListener(this);
        

        maxItemsField.setBounds(210,componentHeights.get(componentHeights.size()-1)+20,60,36);
        maxItemsField.setBackground(new Color(59,59,59,255));
        maxItemsField.setCaretColor(new Color(255,0,47,255));
        maxItemsField.setForeground(new Color(255,0,47,255));
        maxItemsField.setBorder(BorderFactory.createEmptyBorder());
        maxItemsField.addMouseListener(this);

        componentHeights.add(maxItemsBox.getHeight()+componentHeights.get(componentHeights.size()-1)+20);

        //AIF Debits Only Check Box
        //Dimensions of icon 177x36 px
        customizationPanel.add(aifDebitsOnlyBox);
        aifDebitsOnlyBox.setBounds(0,componentHeights.get(componentHeights.size()-1)+10, 200, 40);
        aifDebitsOnlyBox.setOpaque(false);
        aifDebitsOnlyBox.setIcon(aifNotSelectedIcon);
        aifDebitsOnlyBox.setSelectedIcon(aifSelectedIcon);






        itemGeneratorFrame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
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
        // TODO Auto-generated method stub
        
    }
}
