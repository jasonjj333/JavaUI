package ItemGeneratorTest;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

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

public class UIFramework2 implements ActionListener, MouseListener {
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

    public UIFramework2() {
        response = JFileChooser.CANCEL_OPTION;
        selectedLocation = "";
        itemGeneratorFrame = new JFrame();
        openDirectory = new JFileChooser();
        titlePanel = new JPanel();
        customizationPanel = new JPanel();
        cycleNumberBox = new JCheckBox();
        cycleNumberField = new JTextField();
        maxItemsBox = new JCheckBox();
        maxItemsField = new JTextField();
        aifDebitsOnlyBox = new JCheckBox();
        executeButton = new JButton();
        outputLocationLabel = new JLabel();
        outputLocationChoices = new JComboBox<String>();

        itemGeneratorFrame.setLocationRelativeTo(null);
        itemGeneratorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        itemGeneratorFrame.setBackground(Color.white);
        
        titlePanel.setBackground(new Color(161,61,61));

        customizationPanel.setBackground(new Color(255, 255, 255));
        customizationPanel.setForeground(new Color(255, 255, 255));

        cycleNumberBox.setBackground(new java.awt.Color(255, 255, 255));
        cycleNumberBox.setFont(new java.awt.Font("Bahnschrift", 0, 12));
        cycleNumberBox.setForeground(new java.awt.Color(161, 61, 61));
        cycleNumberBox.setFocusable(false);
        cycleNumberBox.setText("Cycle Number");
        cycleNumberBox.addActionListener(this);

        cycleNumberField.setFont(new Font("Bahnschrift", 0, 10));
        cycleNumberField.setForeground(new Color(102, 102, 102));
        cycleNumberField.setText("ex) 030");
        cycleNumberField.setCaretColor(new Color(204, 204, 204));
        cycleNumberField.setDisabledTextColor(new Color(204, 204, 204));
        cycleNumberField.setEditable(false);
        cycleNumberField.addMouseListener(this);

        maxItemsBox.setBackground(new Color(255, 255, 255));
        maxItemsBox.setFont(new Font("Bahnschrift", 0, 12));
        maxItemsBox.setForeground(new Color(161, 61, 61));
        maxItemsBox.setText("Max Items");
        maxItemsBox.setFocusable(false);
        maxItemsBox.addActionListener(this);

        maxItemsField.setFont(new Font("Arial", 0, 10)); // NOI18N
        maxItemsField.setForeground(new Color(102, 102, 102));
        maxItemsField.setText("ex) 20");
        maxItemsField.setCaretColor(new Color(204, 204, 204));
        maxItemsField.setDisabledTextColor(new Color(204, 204, 204));
        maxItemsField.setEditable(false);
        maxItemsField.addMouseListener(this);

        aifDebitsOnlyBox.setBackground(new Color(255, 255, 255));
        aifDebitsOnlyBox.setFont(new Font("Bahnschrift", 0, 12)); // NOI18N
        aifDebitsOnlyBox.setForeground(new Color(161, 61, 61));
        aifDebitsOnlyBox.setText("AIF Debits Only");
        aifDebitsOnlyBox.setFocusable(false);
        aifDebitsOnlyBox.addActionListener(this);

        executeButton.setBackground(new Color(255, 255, 255));
        executeButton.setFont(new Font("Bahnschrift", 0, 12)); // NOI18N
        executeButton.setForeground(new Color(161, 61, 61));
        executeButton.setText("Execute");
        executeButton.addActionListener(this);
        executeButton.setFocusable(false);

        outputLocationLabel.setFont(new Font("Bahnschrift", 0, 12)); // NOI18N
        outputLocationLabel.setForeground(new Color(161, 61, 61));
        outputLocationLabel.setText("Output Location");

        outputLocationChoices.setForeground(new Color(161, 61, 61));
        outputLocationChoices.setModel(new DefaultComboBoxModel<>(new String[] { "Choose..", "Local", "Database" }));
        outputLocationChoices.setToolTipText("Select the output location");
        outputLocationChoices.addActionListener(this);
        outputLocationChoices.setFocusable(false);

        GroupLayout customizationPanelLayout = new GroupLayout(customizationPanel);
        customizationPanel.setLayout(customizationPanelLayout);
        customizationPanelLayout.setHorizontalGroup(
            customizationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, customizationPanelLayout.createSequentialGroup()
                .addContainerGap(218, Short.MAX_VALUE)
                .addComponent(executeButton)
                .addGap(196, 196, 196))
            .addGroup(customizationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customizationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(outputLocationChoices, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputLocationLabel, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                    .addGroup(customizationPanelLayout.createSequentialGroup()
                        .addComponent(cycleNumberBox)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cycleNumberField, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
                    .addGroup(customizationPanelLayout.createSequentialGroup()
                        .addComponent(maxItemsBox, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(maxItemsField, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
                    .addComponent(aifDebitsOnlyBox, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        customizationPanelLayout.setVerticalGroup(
            customizationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(customizationPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(outputLocationLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outputLocationChoices, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(customizationPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(cycleNumberBox)
                    .addComponent(cycleNumberField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customizationPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(maxItemsBox)
                    .addComponent(maxItemsField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aifDebitsOnlyBox)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 337, Short.MAX_VALUE)
                .addComponent(executeButton)
                .addGap(42, 42, 42))
        );

        GroupLayout titlePanelLayout = new GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addComponent(customizationPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                .addGap(0, 64, Short.MAX_VALUE)
                .addComponent(customizationPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        GroupLayout layout = new GroupLayout(itemGeneratorFrame.getContentPane());
        itemGeneratorFrame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        ImageIcon argoFrameIcon = new ImageIcon("D:\\JavaUI\\ItemGeneratorTest\\RealArgoIcon.png");
        itemGeneratorFrame.setIconImage(argoFrameIcon.getImage());
        itemGeneratorFrame.setVisible(true);
        itemGeneratorFrame.pack();
        itemGeneratorFrame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        if(e.getSource() == cycleNumberBox) {
            if(cycleNumberBox.isSelected()) {
                cycleNumberField.setEditable(true);
            }
            else {
                cycleNumberField.setEditable(false);
            }
        }
        if(e.getSource() == maxItemsBox) {
            if(maxItemsBox.isSelected()) {
                maxItemsField.setEditable(true);
            }
            else {
                maxItemsField.setEditable(false);
            }
        }
        if(e.getSource() == executeButton) {
            System.out.println("Executing...");
            if(response == JFileChooser.APPROVE_OPTION && !selectedLocation.equals("")) {
                System.out.println("Local location: " + selectedLocation);
            }
            if(cycleNumberBox.isSelected()) {
                System.out.println("Cycle Number: " + cycleNumberField.getText());
            }
            if(maxItemsBox.isSelected()) {
                System.out.println("Max Items: " + maxItemsField.getText());
            }
            if(aifDebitsOnlyBox.isSelected()) {
                System.out.println("AIF Debits Only is selected.");
            }
        }
        if(e.getSource() == outputLocationChoices) {
            if(outputLocationChoices.getSelectedIndex() == 1) {
                openDirectory.setCurrentDirectory(new File("."));
                openDirectory.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                response = openDirectory.showOpenDialog(null);
                if(response == JFileChooser.APPROVE_OPTION) {
                    selectedLocation = openDirectory.getSelectedFile().getAbsolutePath();
                }
            }
        }
        
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
}
