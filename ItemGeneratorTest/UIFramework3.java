package ItemGeneratorTest;


import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.GradientPaint;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicScrollBarUI;

import java.awt.geom.RoundRectangle2D;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;


public class UIFramework3 implements ActionListener, MouseListener {
    static String CYCLENUMBERDEFAULT = "1000";
    static String MAXITEMSDEFAULT = "10";
    static Color BACKGROUNDCOLOR = (Color.decode("#261C2C"));
    static Color FOREGROUNDCOLOR = Color.decode("#5C527F");
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
    JTextArea performanceText;
    JScrollPane performanceTextScroller;
    JProgressBar progress;

    OvalCheck runBox;
    OvalCheck randomAmountBox;
    OvalCheck imageOnlyBox;
    OvalCheck useTestDataBox;
    OvalCheck testDataSourceBox;
    JFileChooser testDataSourceChooser;
    OvalCheck customerItemCountBox;
    JTextField customerItemCountField;
    OvalCheck randomItemCountBox;
    OvalCheck singleBackgroundImageBox;
    OvalCheck skipBox;
    JTextField skipField;
    OvalCheck checkNumberBox;
    JTextField checkNumberField;
    OvalCheck aifDebitsOnlyBox;
    OvalCheck useImages;
    JFileChooser useImagesChooser;
    OvalCheck useDimensionsBox;
    JTextField useDimensionsField;
    OvalCheck recompressBox;
    OvalCheck useOasisCheckNumberBox;
    OvalCheck randomizeAccountsBox;
    OvalCheck upsideDownImageBox;
    OvalCheck noSignatureBox;
    OvalCheck noImageBox;
    OvalCheck noImageRecordBox;
    OvalCheck randomErrorsBox;
    OvalCheck randomErrorRateBox;
    JTextField randomErrorRateField;



    int progressCounter;
    ProgressUpdate updateThread = new ProgressUpdate("update1");
    public UIFramework3() {

        //Initialize Global Variables
        response = JFileChooser.CANCEL_OPTION;
        selectedLocation = "";
        itemGeneratorFrame = new JFrame();
        openDirectory = new JFileChooser();
        titlePanel = new JPanel()  {
            @Override
            protected void paintComponent(Graphics grphcs) {
                super.paintComponent(grphcs);
                Graphics2D g2d = (Graphics2D) grphcs;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(0, 0,
                        getBackground(), 0, getHeight(),
                        getBackground());
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight()); 
    
            }
    
        };
        customizationPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics grphcs) {
                super.paintComponent(grphcs);
                Graphics2D g2d = (Graphics2D) grphcs;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(0, 0,
                        getBackground().brighter(), 0, getHeight(),
                        getBackground().darker());
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight()); 
    
            }
    
        };
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
        performanceText = new JTextArea(500,300);
        progress = new JProgressBar();
        performanceTextScroller = new JScrollPane(performanceText);
        progressCounter = 0;
        //Local Variables
        int componentHeight = 0;
        int verticalGap = 20;
        //Icon Font Open Sans
        //Create Images/Icons
        ImageIcon argoIcon = new ImageIcon("./ItemGeneratorTest/Images/PurpleArgoIcon.png");
        checkIcon = new ImageIcon("./ItemGeneratorTest/Images/CheckIcon.png");

        //Fonts
        try {
            openSans16 = Font.createFont(Font.TRUETYPE_FONT, new File("./ItemGeneratorTest/Fonts/OpenSans-Regular.ttf")).deriveFont(16f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("./ItemGeneratorTest/Fonts/OpenSans-Regular.ttf")));
        }
        catch(IOException | FontFormatException e) {
        
        }
        //Style
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        openDirectory.updateUI();
        openDirectory.setOpaque(false);
        
        //Item Generator Frame
        //Set size should be 1000 x 600 but due to only small subset of features
        //added so far, dimensions are reduced
        itemGeneratorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        itemGeneratorFrame.setLayout(null);
        itemGeneratorFrame.setIconImage(argoIcon.getImage());
        itemGeneratorFrame.setUndecorated(true);
        itemGeneratorFrame.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        itemGeneratorFrame.setShape(new RoundRectangle2D.Double(0, 0, 1000, 600, 25, 25));
        itemGeneratorFrame.setSize(1000,600);
        itemGeneratorFrame.setLocationRelativeTo(null);

        //Title Panel
        itemGeneratorFrame.add(titlePanel);
        titlePanel.setBounds(0,0,1000,50);
        titlePanel.setLayout(null);
        titlePanel.setBackground(FOREGROUNDCOLOR);

        //makes window able to be dragged
        titlePanel.add(dragPanel);
        dragPanel.setBounds(0,0,titlePanel.getWidth()-100,titlePanel.getHeight());
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
        customizationPanel.setBounds(0,titlePanel.getHeight(),itemGeneratorFrame.getWidth(),itemGeneratorFrame.getHeight()-titlePanel.getHeight());
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
        cycleNumberField.setText(CYCLENUMBERDEFAULT);
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

        //performance text area
        performanceText.setEditable(false);
        performanceText.setFocusable(false);
        performanceTextScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        performanceTextScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        performanceTextScroller.setBorder(BorderFactory.createEmptyBorder());
        performanceTextScroller.getVerticalScrollBar().setBackground(BACKGROUNDCOLOR);
        performanceTextScroller.setFocusable(false);
        performanceTextScroller.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = FOREGROUNDCOLOR;
            }

            @Override
            protected void installComponents(){
                switch (scrollbar.getOrientation()) {
                case JScrollBar.VERTICAL:
                    incrButton = createIncreaseButton(SOUTH);
                    decrButton = createDecreaseButton(NORTH);
                    break;
            
                case JScrollBar.HORIZONTAL:
                    if (scrollbar.getComponentOrientation().isLeftToRight()) {    
                        incrButton = createIncreaseButton(EAST);
                        decrButton = createDecreaseButton(WEST);
                    } else {
                        incrButton = createIncreaseButton(WEST);
                        decrButton = createDecreaseButton(EAST);
                    }
                    break;
                }
                //scrollbar.add(incrButton); // Comment out this line to hide arrow
                //scrollbar.add(decrButton); // Comment out this line to hide arrow
                // Force the children's enabled state to be updated.
            scrollbar.setEnabled(scrollbar.isEnabled());
            }
        });
        customizationPanel.add(performanceTextScroller);
        performanceTextScroller.setBounds(380, 25, 600, 300);maxItemsField.setFont(openSans16);
        performanceText.setText("Performance Output:");
        performanceText.setBackground(new Color(59,59,59,255));
        performanceText.setCaretColor(FOREGROUNDCOLOR);
        performanceText.setForeground(DARKTEXTCOLOR);
        performanceText.setBorder(BorderFactory.createEmptyBorder());

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
                    performanceText.append("Cycle Number needs to be an Integer.");
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
                    performanceText.append("Max Items needs to be an Integer.");
                    valid = false;
                }
            }
            if(outputLocationChoices.getSelectedIndex() == 0) {
                System.out.println("Please select output location.");
                performanceText.append("Please select output location.");
                valid = false;
            }

            if(valid) {
                performanceText.setText("");
                System.out.println("Executing...");
                performanceText.append("Executing...");
                progress = new JProgressBar(0,Integer.parseInt(maxItemsField.getText()));
                progress.setStringPainted(true);
                progress.setForeground(FOREGROUNDCOLOR);
                progress.setBackground(new Color(59,59,59,255));
                progress.setBorder(BorderFactory.createEmptyBorder());
                progress.setFocusable(false);
                progress.setValue(0);
                customizationPanel.add(progress);
                progress.setBounds(performanceTextScroller.getX(), 350, 200, 20);
                
                ProgressUpdate updateThread = new ProgressUpdate("update1");
                updateThread.start();
                ExecuteUpdate executeThread = new ExecuteUpdate("execute1");
                executeThread.start();

                
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
    
    public void excCommand(String command) throws IOException {
        ProcessBuilder builder = new ProcessBuilder(
            "cmd.exe", "/c", command);
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) { break; }
                System.out.println(line);
                performanceText.append("\n" + line);
                progressCounter++;
                progress.setValue(progressCounter);
                
            }    
    }

    class ProgressUpdate implements Runnable {
        Thread updateProgress;
        private String updateProgressName;
        static volatile boolean exit = false;
        ProgressUpdate(String name) {
         updateProgressName = name;
        }

        @Override
        public void run() {
            System.out.println("Thread running" + updateProgressName);
            while(!exit){
                progress.setValue(progressCounter);
                progress.repaint();
            }
            System.out.println("Progress Thread closed.");
        }
        public void start() {
            System.out.println("Thread started");
            if (updateProgress == null) {
                updateProgress = new Thread(this, updateProgressName);
                updateProgress.start();
            }
        }
        public void stop() {
            exit = true;
        }
       }
    
       class ExecuteUpdate implements Runnable {
        Thread updateExecute;
        private String updateExecuteName;
        static volatile boolean exit = false;
        ExecuteUpdate(String name) {
         updateExecuteName = name;
        }
        @Override
        public void run() {
         System.out.println("Thread running" + updateExecuteName);
            String output = "";
            output += "ItemGenerator ";
            if(outputLocationChoices.getSelectedIndex()==2) {
                System.out.println("Database Selected.");
                performanceText.append("\nDatabase Selected.");
                output+= "-p \"Database\" ";
            }
            else if(response == JFileChooser.APPROVE_OPTION && !selectedLocation.equals("")) {
                System.out.println("Local location: " + selectedLocation);
                performanceText.append("\nLocal location: " + selectedLocation);
                output += "-p "+ selectedLocation;
   
            }
            if(cycleNumberBox.isSelected() && !cycleNumberField.getText().equals("")) {
                System.out.println("Cycle Number: " + cycleNumberField.getText());
                performanceText.append(("\nCycle Number: " + cycleNumberBox.getText()));
                output += " -c "+ cycleNumberField.getText();
            }
            else {
                output += " -c "+ CYCLENUMBERDEFAULT;
            }
            if(maxItemsBox.isSelected()&& !maxItemsField.getText().equals("")) {
                System.out.println("Max Items: " + maxItemsField.getText());
                performanceText.append("\nMax Items: " + maxItemsField.getText());
                output += " --maxitems "+maxItemsField.getText();
            }
            else {
                output += " --maxitems "+MAXITEMSDEFAULT;
            }
            if(aifBox.isSelected()) {
                System.out.println("AIF is selected.");
                performanceText.append("\nAIF is selected.");
                output += " --aif";
            }
            System.out.print("CMD Command: " + output + "\n");
            performanceText.append("\nCMD Command: " + output);
   
            try {
                excCommand("cd D:\\ItemGen-main\\ItemGenerator\\bin\\Debug && " + output);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
                exit = true;
                updateThread.stop();
                System.out.println("Execute Thread closed.");
            
            
         
        }
        public void start() {
         System.out.println("Thread started");
         if (updateExecute == null) {
          updateExecute = new Thread(this, updateExecuteName);
          updateExecute.start();
         }
        }

        public void stop() {
            exit = true;
        }
       }

    
}

