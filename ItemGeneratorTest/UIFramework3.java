package ItemGeneratorTest;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;


public class UIFramework3 implements ActionListener, MouseListener {
    static int VERTICALMARGIN = 15;
    static int BUTTONWIDTH = 190;
    static int BUTTONHEIGHT = 36;
    static int BOXWIDTH = 190;
    static int BOXHEIGHT = 36;
    static int FIELDHEIGHT = 36;
    static int FIELDWIDTH = 60;
    static int BOXMARGIN = 10;
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
    JTextField runField;
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
    FeatureCreator creator;
    EventManager eventManager;
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

        runBox = new OvalCheck(OvalCheck.SHAPE_CAPSULE,OvalCheck.HORIZONTAL, FOREGROUNDCOLOR, FOREGROUNDCOLOR, FOREGROUNDCOLOR, TEXTCOLOR);
        runField = new JTextField(5);
        randomAmountBox = new OvalCheck(OvalCheck.SHAPE_CAPSULE,OvalCheck.HORIZONTAL, FOREGROUNDCOLOR, FOREGROUNDCOLOR, FOREGROUNDCOLOR, TEXTCOLOR);
        imageOnlyBox = new OvalCheck(OvalCheck.SHAPE_CAPSULE,OvalCheck.HORIZONTAL, FOREGROUNDCOLOR, FOREGROUNDCOLOR, FOREGROUNDCOLOR, TEXTCOLOR);
        useTestDataBox = new OvalCheck(OvalCheck.SHAPE_CAPSULE,OvalCheck.HORIZONTAL, FOREGROUNDCOLOR, FOREGROUNDCOLOR, FOREGROUNDCOLOR, TEXTCOLOR);
        testDataSourceBox = new OvalCheck(OvalCheck.SHAPE_CAPSULE,OvalCheck.HORIZONTAL, FOREGROUNDCOLOR, FOREGROUNDCOLOR, FOREGROUNDCOLOR, TEXTCOLOR);
        testDataSourceChooser = new JFileChooser();
        customerItemCountBox = new OvalCheck(OvalCheck.SHAPE_CAPSULE,OvalCheck.HORIZONTAL, FOREGROUNDCOLOR, FOREGROUNDCOLOR, FOREGROUNDCOLOR, TEXTCOLOR);
        customerItemCountField = new JTextField(5);
        randomItemCountBox = new OvalCheck(OvalCheck.SHAPE_CAPSULE,OvalCheck.HORIZONTAL, FOREGROUNDCOLOR, FOREGROUNDCOLOR, FOREGROUNDCOLOR, TEXTCOLOR);
        singleBackgroundImageBox = new OvalCheck(OvalCheck.SHAPE_CAPSULE,OvalCheck.HORIZONTAL, FOREGROUNDCOLOR, FOREGROUNDCOLOR, FOREGROUNDCOLOR, TEXTCOLOR);
        skipBox = new OvalCheck(OvalCheck.SHAPE_CAPSULE,OvalCheck.HORIZONTAL, FOREGROUNDCOLOR, FOREGROUNDCOLOR, FOREGROUNDCOLOR, TEXTCOLOR);
        skipField = new JTextField(5);
        checkNumberBox = new OvalCheck(OvalCheck.SHAPE_CAPSULE,OvalCheck.HORIZONTAL, FOREGROUNDCOLOR, FOREGROUNDCOLOR, FOREGROUNDCOLOR, TEXTCOLOR);
        checkNumberField = new JTextField(5);
        aifDebitsOnlyBox = new OvalCheck(OvalCheck.SHAPE_CAPSULE,OvalCheck.HORIZONTAL, FOREGROUNDCOLOR, FOREGROUNDCOLOR, FOREGROUNDCOLOR, TEXTCOLOR);
        useImages = new OvalCheck(OvalCheck.SHAPE_CAPSULE,OvalCheck.HORIZONTAL, FOREGROUNDCOLOR, FOREGROUNDCOLOR, FOREGROUNDCOLOR, TEXTCOLOR);
        useImagesChooser = new JFileChooser();
        useDimensionsBox = new OvalCheck(OvalCheck.SHAPE_CAPSULE,OvalCheck.HORIZONTAL, FOREGROUNDCOLOR, FOREGROUNDCOLOR, FOREGROUNDCOLOR, TEXTCOLOR);
        useDimensionsField = new JTextField(5);
        recompressBox = new OvalCheck(OvalCheck.SHAPE_CAPSULE,OvalCheck.HORIZONTAL, FOREGROUNDCOLOR, FOREGROUNDCOLOR, FOREGROUNDCOLOR, TEXTCOLOR);
        useOasisCheckNumberBox = new OvalCheck(OvalCheck.SHAPE_CAPSULE,OvalCheck.HORIZONTAL, FOREGROUNDCOLOR, FOREGROUNDCOLOR, FOREGROUNDCOLOR, TEXTCOLOR);
        randomizeAccountsBox = new OvalCheck(OvalCheck.SHAPE_CAPSULE,OvalCheck.HORIZONTAL, FOREGROUNDCOLOR, FOREGROUNDCOLOR, FOREGROUNDCOLOR, TEXTCOLOR);
        upsideDownImageBox = new OvalCheck(OvalCheck.SHAPE_CAPSULE,OvalCheck.HORIZONTAL, FOREGROUNDCOLOR, FOREGROUNDCOLOR, FOREGROUNDCOLOR, TEXTCOLOR);
        noSignatureBox = new OvalCheck(OvalCheck.SHAPE_CAPSULE,OvalCheck.HORIZONTAL, FOREGROUNDCOLOR, FOREGROUNDCOLOR, FOREGROUNDCOLOR, TEXTCOLOR);
        noImageBox = new OvalCheck(OvalCheck.SHAPE_CAPSULE,OvalCheck.HORIZONTAL, FOREGROUNDCOLOR, FOREGROUNDCOLOR, FOREGROUNDCOLOR, TEXTCOLOR);
        noImageRecordBox = new OvalCheck(OvalCheck.SHAPE_CAPSULE,OvalCheck.HORIZONTAL, FOREGROUNDCOLOR, FOREGROUNDCOLOR, FOREGROUNDCOLOR, TEXTCOLOR);
        randomErrorsBox = new OvalCheck(OvalCheck.SHAPE_CAPSULE,OvalCheck.HORIZONTAL, FOREGROUNDCOLOR, FOREGROUNDCOLOR, FOREGROUNDCOLOR, TEXTCOLOR);
        randomErrorRateBox = new OvalCheck(OvalCheck.SHAPE_CAPSULE,OvalCheck.HORIZONTAL, FOREGROUNDCOLOR, FOREGROUNDCOLOR, FOREGROUNDCOLOR, TEXTCOLOR);
        randomErrorRateField = new JTextField(5);

        //Local Variables
        //Icon Font Open Sans
        //Create Images/Icons
        ImageIcon argoIcon = new ImageIcon("./ItemGeneratorTest/Images/PurpleArgoIcon.png");
        checkIcon = new ImageIcon("./ItemGeneratorTest/Images/CheckIcon.png");

        //Fonts
//        try {
//            openSans16 = Font.createFont(Font.TRUETYPE_FONT, new File("./ItemGeneratorTest/Fonts/OpenSans-Regular.ttf")).deriveFont(16f);
//            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("./ItemGeneratorTest/Fonts/OpenSans-Regular.ttf")));
//        }
//        catch(IOException | FontFormatException e) {
//
//        }
        openSans16 = new Font(Font.SANS_SERIF,Font.PLAIN, 16);
        //Style
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        openDirectory.updateUI();
        openDirectory.setOpaque(false);

        //Feature Creator
        creator = new FeatureCreator(TEXTCOLOR, FOREGROUNDCOLOR, BACKGROUNDCOLOR, DARKTEXTCOLOR, openSans16);
        //Event Manager
        eventManager = new EventManager(TEXTCOLOR, FOREGROUNDCOLOR, BACKGROUNDCOLOR, DARKTEXTCOLOR, openSans16);
        
        //Item Generator Frame
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
        creator.fillButton(closeButton, "X");
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

        //Layout Manager for Customization Panel
        LayoutManager layout = new LayoutManager(customizationPanel.getWidth(), customizationPanel.getHeight(), 10, VERTICALMARGIN);
        layout.setX(10);
        layout.setY(20);

        //Output Location
        customizationPanel.add(outputLocationLabel);
        customizationPanel.add(outputLocationChoices);
        customizationPanel.add(localLabel);
        layout.updateComponent(220, 20);
        outputLocationLabel.setBounds(layout.getX(), layout.getY(), 220, 20);
        outputLocationLabel.setText("Select Output Location");
        outputLocationLabel.setFont(openSans16);
        outputLocationLabel.setForeground(TEXTCOLOR);

        layout.updateComponent(100, 36,15);
        outputLocationChoices.setBounds(layout.getX(),layout.getY(),100,36);
        outputLocationChoices.setBackground(new Color(59,59,59,255));
        outputLocationChoices.setForeground(TEXTCOLOR);
        outputLocationChoices.setFont(openSans16);
        outputLocationChoices.setModel(new DefaultComboBoxModel<>(new String[] { "Choose..", "Local", "Database" }));
        outputLocationChoices.setToolTipText("Select the output location");
        outputLocationChoices.addActionListener(this);
        outputLocationChoices.setFocusable(false);

        layout.updateHComponent(100, 36);
        localLabel.setBounds(layout.getTextX(), layout.getY(), 150, 36);
        localLabel.setFont(openSans16);
        localLabel.setForeground(TEXTCOLOR);
        localLabel.setText("");

        //Skip
        customizationPanel.add(skipBox);
        layout.updateComponent(BOXWIDTH,BOXHEIGHT,BOXMARGIN);
        skipBox.setBounds(layout.getX(),layout.getY(), BOXWIDTH, BOXHEIGHT);
        creator.fillCheckBox(skipBox,"Skip");
        skipBox.addActionListener(this);

        customizationPanel.add(skipField);
        layout.updateHComponent(FIELDWIDTH,FIELDHEIGHT);
        skipField.setBounds(layout.getTextX(),layout.getY(),FIELDWIDTH,FIELDHEIGHT);
        creator.fillField(skipField, "001");
        skipField.addMouseListener(this);

        //Cycle Number
        customizationPanel.add(cycleNumberBox);
        layout.updateComponent(BOXWIDTH, BOXHEIGHT,BOXMARGIN);
        cycleNumberBox.setBounds(layout.getX(),layout.getY(),BOXWIDTH,BOXHEIGHT);
        creator.fillCheckBox(cycleNumberBox, "Cycle Number");
        cycleNumberBox.addActionListener(this);

        customizationPanel.add(cycleNumberField);
        layout.updateHComponent(60,FIELDHEIGHT);
        cycleNumberField.setBounds(layout.getTextX(),layout.getY(),FIELDWIDTH,FIELDHEIGHT);
        creator.fillField(cycleNumberField,"010");
        cycleNumberField.addMouseListener(this);

        //Run Box and Field
        customizationPanel.add(runBox);
        layout.updateComponent(BOXWIDTH, BOXHEIGHT,BOXMARGIN);
        runBox.setBounds(layout.getX(),layout.getY(),BOXWIDTH,BOXHEIGHT);
        creator.fillCheckBox(runBox, "Run");
        runBox.addActionListener(this);

        customizationPanel.add(runField);
        layout.updateHComponent(60,FIELDHEIGHT);
        runField.setBounds(layout.getTextX(),layout.getY(),FIELDWIDTH,FIELDHEIGHT);
        creator.fillField(runField,"001");
        runField.addMouseListener(this);

        //Max Items
        customizationPanel.add(maxItemsBox);
        layout.updateComponent(BOXWIDTH,BOXHEIGHT,BOXMARGIN);
        maxItemsBox.setBounds(layout.getX(),layout.getY(), BOXWIDTH, BOXHEIGHT);
        creator.fillCheckBox(maxItemsBox,"Max Items");
        maxItemsBox.addActionListener(this);

        customizationPanel.add(maxItemsField);
        layout.updateHComponent(FIELDWIDTH,FIELDHEIGHT);
        maxItemsField.setBounds(layout.getTextX(),layout.getY(),FIELDWIDTH,FIELDHEIGHT);
        creator.fillField(maxItemsField, "20");
        maxItemsField.addMouseListener(this);

        //Check Number
        customizationPanel.add(checkNumberBox);
        layout.updateComponent(BOXWIDTH,BOXHEIGHT,BOXMARGIN);
        checkNumberBox.setBounds(layout.getX(),layout.getY(), BOXWIDTH, BOXHEIGHT);
        creator.fillCheckBox(checkNumberBox,"Check Number");
        checkNumberBox.addActionListener(this);

        customizationPanel.add(checkNumberField);
        layout.updateHComponent(FIELDWIDTH,FIELDHEIGHT);
        checkNumberField.setBounds(layout.getTextX(),layout.getY(),FIELDWIDTH,FIELDHEIGHT);
        creator.fillField(checkNumberField, "001");
        checkNumberField.addMouseListener(this);

        //Use Dimensions
//        customizationPanel.add(useDimensionsBox);
//        layout.updateComponent(BOXWIDTH,BOXHEIGHT,BOXMARGIN);
//        useDimensionsBox.setBounds(layout.getX(),layout.getY(), BOXWIDTH, BOXHEIGHT);
//        creator.fillCheckBox(useDimensionsBox,"Use Dimensions");
//        useDimensionsBox.addActionListener(this);

//        customizationPanel.add(useDimensionsField);
//        layout.updateHComponent(FIELDWIDTH,FIELDHEIGHT);
//        useDimensionsField.setBounds(layout.getTextX(),layout.getY(),FIELDWIDTH,FIELDHEIGHT);
//        creator.fillField(useDimensionsField, "100x10");
//        useDimensionsField.addMouseListener(this);

        //Test Data Source
        //..add later

        //Customer Item Count
        customizationPanel.add(customerItemCountBox);
        layout.updateComponent(BOXWIDTH,BOXHEIGHT,BOXMARGIN);
        customerItemCountBox.setBounds(layout.getX(),layout.getY(), BOXWIDTH, BOXHEIGHT);
        creator.fillCheckBox(customerItemCountBox,"Customer Item Count");
        customerItemCountBox.addActionListener(this);

        customizationPanel.add(customerItemCountField);
        layout.updateHComponent(FIELDWIDTH,FIELDHEIGHT);
        customerItemCountField.setBounds(layout.getTextX(),layout.getY(),FIELDWIDTH,FIELDHEIGHT);
        creator.fillField(customerItemCountField, "");
        customerItemCountField.addMouseListener(this);

        //Random Item Count
        customizationPanel.add(randomItemCountBox);
        layout.updateComponent(BOXWIDTH,BOXHEIGHT,BOXMARGIN);
        randomItemCountBox.setBounds(layout.getX(),layout.getY(), BOXWIDTH, BOXHEIGHT);
        creator.fillCheckBox(randomItemCountBox,"Random Item Count");
        randomItemCountBox.addActionListener(this);

        //Single Background Image
//        customizationPanel.add(singleBackgroundImageBox);
//        layout.updateComponent(BOXWIDTH,BOXHEIGHT,BOXMARGIN);
//        singleBackgroundImageBox.setBounds(layout.getX(),layout.getY(), BOXWIDTH, BOXHEIGHT);
//        creator.fillCheckBox(singleBackgroundImageBox,"Single Background Image");
//        singleBackgroundImageBox.addActionListener(this);

        //Random Amount Check Box
//        customizationPanel.add(randomAmountBox);
//        layout.updateComponent(BOXWIDTH, BOXHEIGHT,BOXMARGIN);
//        randomAmountBox.setBounds(layout.getX(),layout.getY(),BOXWIDTH,BOXHEIGHT);
//        creator.fillCheckBox(randomAmountBox, "Random Amount");
//        randomAmountBox.addActionListener(this);

        //Image Only Box
        customizationPanel.add(imageOnlyBox);
        layout.updateComponent(BOXWIDTH, BOXHEIGHT, BOXMARGIN);
        imageOnlyBox.setBounds(layout.getX(),layout.getY(), BOXWIDTH, BOXHEIGHT);
        creator.fillCheckBox(imageOnlyBox, "Image Only");
        imageOnlyBox.addActionListener(this);

        //AIF
        customizationPanel.add(aifBox);
        layout.updateComponent(BOXWIDTH, BOXHEIGHT, BOXMARGIN);
        aifBox.setBounds(layout.getX(),layout.getY(), BOXWIDTH, BOXHEIGHT);
        creator.fillCheckBox(aifBox, "AIF");
        aifBox.addActionListener(this);

        //AIF Debits Only
//        customizationPanel.add(aifDebitsOnlyBox);
//        layout.updateComponent(BOXWIDTH, BOXHEIGHT, BOXMARGIN);
//        aifDebitsOnlyBox.setBounds(layout.getX(),layout.getY(), BOXWIDTH, BOXHEIGHT);
//        creator.fillCheckBox(aifDebitsOnlyBox, "AIF Debits Only");
//        aifDebitsOnlyBox.addActionListener(this);

        //Use Images
        //..do later


        //Use Test Data
//        customizationPanel.add(useTestDataBox);
//        layout.updateComponent(BOXWIDTH, BOXHEIGHT, BOXMARGIN);
//        useTestDataBox.setBounds(layout.getX(),layout.getY(), BOXWIDTH, BOXHEIGHT);
//        creator.fillCheckBox(useTestDataBox, "Use Test Data");
//        useTestDataBox.addActionListener(this);

        //Recompress
//        customizationPanel.add(recompressBox);
//        layout.updateComponent(BOXWIDTH, BOXHEIGHT, BOXMARGIN);
//        recompressBox.setBounds(layout.getX(),layout.getY(), BOXWIDTH, BOXHEIGHT);
//        creator.fillCheckBox(recompressBox, "Recompress");
//        recompressBox.addActionListener(this);

        //Use Oasis Check Number
//        customizationPanel.add(useOasisCheckNumberBox);
//        layout.updateComponent(BOXWIDTH, BOXHEIGHT, BOXMARGIN);
//        useOasisCheckNumberBox.setBounds(layout.getX(),layout.getY(), BOXWIDTH, BOXHEIGHT);
//        creator.fillCheckBox(useOasisCheckNumberBox, "Use Oasis Check Number");
//        useOasisCheckNumberBox.addActionListener(this);

        //Randomize Accounts
//        customizationPanel.add(randomizeAccountsBox);
//        layout.updateComponent(BOXWIDTH, BOXHEIGHT, BOXMARGIN);
//        randomizeAccountsBox.setBounds(layout.getX(),layout.getY(), BOXWIDTH, BOXHEIGHT);
//        creator.fillCheckBox(randomizeAccountsBox, "Randomize Accounts");
//        randomizeAccountsBox.addActionListener(this);

        //Upside Down Image
        customizationPanel.add(upsideDownImageBox);
        layout.updateComponent(BOXWIDTH, BOXHEIGHT, BOXMARGIN);
        upsideDownImageBox.setBounds(layout.getX(),layout.getY(), BOXWIDTH, BOXHEIGHT);
        creator.fillCheckBox(upsideDownImageBox, "Upside Down Image");
        upsideDownImageBox.addActionListener(this);

        //No Signature
        customizationPanel.add(noSignatureBox);
        layout.updateComponent(BOXWIDTH, BOXHEIGHT, BOXMARGIN);
        noSignatureBox.setBounds(layout.getX(),layout.getY(), BOXWIDTH, BOXHEIGHT);
        creator.fillCheckBox(noSignatureBox, "No Signature");
        noSignatureBox.addActionListener(this);

        //No Image
        customizationPanel.add(noImageBox);
        layout.updateComponent(BOXWIDTH, BOXHEIGHT, BOXMARGIN);
        noImageBox.setBounds(layout.getX(),layout.getY(), BOXWIDTH, BOXHEIGHT);
        creator.fillCheckBox(noImageBox, "No Image");
        noImageBox.addActionListener(this);

        //No Image Record
        customizationPanel.add(noImageRecordBox);
        layout.updateComponent(BOXWIDTH, BOXHEIGHT, BOXMARGIN);
        noImageRecordBox.setBounds(layout.getX(),layout.getY(), BOXWIDTH, BOXHEIGHT);
        creator.fillCheckBox(noImageRecordBox, "No Image Record");
        noImageRecordBox.addActionListener(this);

        //Random Errors
        customizationPanel.add(randomErrorsBox);
        layout.updateComponent(BOXWIDTH, BOXHEIGHT, BOXMARGIN);
        randomErrorsBox.setBounds(layout.getX(),layout.getY(), BOXWIDTH, BOXHEIGHT);
        creator.fillCheckBox(randomErrorsBox, "Random Errors");
        randomErrorsBox.addActionListener(this);

        //Execute Button HARDCODED LOCATION
        customizationPanel.add(executeButton);
        //layout.updateComponent(BUTTONWIDTH,BUTTONHEIGHT,BOXMARGIN);
        executeButton.setBounds(500, 400, BUTTONWIDTH, BUTTONHEIGHT);
        creator.fillButton(executeButton, "Execute");
        executeButton.addActionListener(this);

        //Performance text area HARDCODED LOCATION
        customizationPanel.add(performanceTextScroller);
        //layout.updateComponent(600,300);
         performanceTextScroller.setBounds(500, 100, 490, 290);
        creator.fillPerformanceText(performanceText,performanceTextScroller, "Performance Output: ");


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

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == closeButton) {
            itemGeneratorFrame.setVisible(false);
            itemGeneratorFrame.dispose(); //Destroy the JFrame object
        }
        if(e.getSource() == skipBox) {
            eventManager.updateBoxField(skipBox, skipField);
        }
        if(e.getSource() == cycleNumberBox) {
            eventManager.updateBoxField(cycleNumberBox, cycleNumberField);
        }
        if(e.getSource() == runBox) {
            eventManager.updateBoxField(runBox, runField);
        }
        if(e.getSource() == maxItemsBox) {
            eventManager.updateBoxField(maxItemsBox, maxItemsField);
        }
        if(e.getSource() == checkNumberBox) {
            eventManager.updateBoxField(checkNumberBox, checkNumberField);
        }
//        if(e.getSource() == useDimensionsBox) {
//            eventManager.updateBoxField(useDimensionsBox, useDimensionsField);
//        }
        if(e.getSource() == customerItemCountBox) {
            eventManager.updateBoxField(customerItemCountBox, customerItemCountField);
        }
        if(e.getSource() == randomItemCountBox) {
            eventManager.updateBox(randomItemCountBox);
        }
        if(e.getSource() == singleBackgroundImageBox) {
            eventManager.updateBox(singleBackgroundImageBox);
        }
//        if(e.getSource() == randomAmountBox) {
//            eventManager.updateBox(randomAmountBox);
//        }
        if(e.getSource() == imageOnlyBox) {
            eventManager.updateBox(imageOnlyBox);
        }
        if(e.getSource() == aifBox) {
            eventManager.updateBox(aifBox);
        }
//        if(e.getSource() == aifDebitsOnlyBox) {
//            eventManager.updateBox(aifDebitsOnlyBox);
//        }
//        if(e.getSource() == useTestDataBox) {
//            eventManager.updateBox(useTestDataBox);
//        }
//        if(e.getSource() == recompressBox) {
//            eventManager.updateBox(recompressBox);
//        }
//        if(e.getSource() == useOasisCheckNumberBox) {
//            eventManager.updateBox(useOasisCheckNumberBox);
//        }
        if(e.getSource() == randomizeAccountsBox) {
            eventManager.updateBox(randomizeAccountsBox);
        }
        if(e.getSource() == upsideDownImageBox) {
            eventManager.updateBox(upsideDownImageBox);
        }
        if(e.getSource() == noSignatureBox) {
            eventManager.updateBox(noSignatureBox);
        }
        if(e.getSource() == noImageBox) {
            eventManager.updateBox(noImageBox);
        }
        if(e.getSource() == noImageRecordBox) {
            eventManager.updateBox(noImageRecordBox);
        }
        if(e.getSource() == randomErrorsBox) {
            eventManager.updateBox(randomErrorsBox);
        }
        if(e.getSource() == executeButton) {
            System.out.println("Execute Button Pressed");
            performanceText.setText("");
            boolean valid = true;
            //add validity for rest of basic buttons
            if(cycleNumberBox.isSelected()){
                try {
                    if(cycleNumberField.getText().equals("")) {
                        cycleNumberField.setText(CYCLENUMBERDEFAULT);
                    }
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
            System.out.println("Valid = " + valid);

            if(valid) {
                valid = true;
                performanceText.setText("");
                System.out.println("Executing...");
                performanceText.append("Executing...");
//                if(Integer.parseInt(cycleNumberField.getText()) > 49) {
//                    progress = new JProgressBar(0, Integer.parseInt(maxItemsField.getText()));
//                    progress.setStringPainted(true);
//                    progress.setForeground(FOREGROUNDCOLOR);
//                    progress.setBackground(new Color(59, 59, 59, 255));
//                    progress.setBorder(BorderFactory.createEmptyBorder());
//                    progress.setFocusable(false);
//                    progress.setValue(0);
//                    customizationPanel.add(progress);
//                    progress.setBounds(700, 400, 270, 20);
//
//                    ProgressUpdate updateThread = new ProgressUpdate("update1");
//                    updateThread.start();
//                }
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
            output += eventManager.getCommandLine(skipBox, skipField, "--skip");
            output += eventManager.getCommandLine(cycleNumberBox, cycleNumberField, "-c", CYCLENUMBERDEFAULT);
            output += eventManager.getCommandLine(runBox, runField, "--run");
            output += eventManager.getCommandLine(maxItemsBox, maxItemsField, "--maxitems", MAXITEMSDEFAULT);
            output += eventManager.getCommandLine(checkNumberBox, checkNumberField, "--checknumber");
                //cant find command call for use dimension
            //output += eventManager.getCommandLine(useDimensionsBox, useDimensionsField, "");
            output += eventManager.getCommandLine(customerItemCountBox, customerItemCountField, "--customeritemcount");
            output += eventManager.getCommandLine(randomItemCountBox, "--randomitemcount");
                //may be wrong command call
            //output += eventManager.getCommandLine(singleBackgroundImageBox, "--singleimage");
                //cannot find command call for random amount
            //output += eventManager.getCommandLine(randomAmountBox, "");
            output += eventManager.getCommandLine(imageOnlyBox, "--imageonly");
            output += eventManager.getCommandLine(aifBox, "--aif");
                //cannot find command call for aif debits only
            //output += eventManager.getCommandLine(aifDebitsOnlyBox, "--aif");
                //cannot find command call for use test data
            //output += eventManager.getCommandLine(useTestDataBox, "--");
                //Cannot find command call for recompress
            //output += eventManager.getCommandLine(recompressBox, "--aif");
                //cannot find command call for use oasis check number
            //output += eventManager.getCommandLine(useOasisCheckNumberBox, "--aif");
                //cannot find command call for randomize accounts
            //output += eventManager.getCommandLine(randomizeAccountsBox, "--aif");
            output += eventManager.getCommandLine(upsideDownImageBox, "--upsidedown");
            output += eventManager.getCommandLine(noSignatureBox, "--nosignature");
            output += eventManager.getCommandLine(noImageBox, "--noimage");
            output += eventManager.getCommandLine(noImageRecordBox, "--noimagerecord");
            output += eventManager.getCommandLine(randomErrorsBox, "--randomerrors");

            System.out.print("CMD Command: " + output + "\n");
            performanceText.append("\nCMD Command: " + output);
   
            try {
                //excCommand("cd D:\\ItemGen-main\\ItemGenerator\\bin\\Debug && " + output);
                excCommand("cd .\\bin && " + output);

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

