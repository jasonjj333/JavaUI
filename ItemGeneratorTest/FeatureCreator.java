package ItemGeneratorTest;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;


public class FeatureCreator {
    private Color TEXTCOLOR;
    private Color FOREGROUNDCOLOR;
    private Color DARKTEXTCOLOR;
    private Color BACKGROUNDCOLOR;
    //private Font openSans16;
    private Font openSans16 = new Font(Font.SERIF,Font.PLAIN, 24);
    public FeatureCreator(Color tcolor, Color fcolor, Color bcolor, Color dtcolor, Font font) {
        TEXTCOLOR = tcolor;
        FOREGROUNDCOLOR = fcolor;
        BACKGROUNDCOLOR = bcolor;
        DARKTEXTCOLOR = dtcolor;
        openSans16 = font;
    }
    public void fillCheckBox(OvalCheck box, String label) {
        box.setText(label);
        box.setForeground(TEXTCOLOR);
        box.setFont(openSans16);
        box.setRadius(.16);
        box.setBorderThickness(0);
        box.setHorizontalAlignment(JCheckBox.CENTER);
    }
    public void fillButton(OvalButton button, String label) {
        button.setText(label);
        button.setFont(openSans16);
        button.setForeground(TEXTCOLOR);
        button.setBorderThickness(0);
        button.setRadius(.16);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setFocusable(false);
    }
    public void fillField(JTextField field, String label) {
        field.setFont(openSans16);
        field.setText(label);
        field.setBackground(new Color(59,59,59,255));
        field.setCaretColor(FOREGROUNDCOLOR);
        field.setForeground(DARKTEXTCOLOR);
        field.setEditable(false);
        field.setBorder(BorderFactory.createEmptyBorder());
        field.setHorizontalAlignment(JCheckBox.RIGHT);
    }
    public void fillButton(JButton button, String label) {
        button.setText(label);
        button.setFont(openSans16);
        button.setForeground(TEXTCOLOR);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusable(false);
    }
    public void fillPerformanceText(JTextArea performanceText, JScrollPane performanceTextScroller, String label) {
        performanceText.setEditable(false);
        performanceText.setFocusable(false);
        performanceText.setLineWrap(true);
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
                scrollbar.setEnabled(scrollbar.isEnabled());
            }
        });
        performanceText.setText(label);
        performanceText.setBackground(new Color(59,59,59,255));
        performanceText.setCaretColor(FOREGROUNDCOLOR);
        performanceText.setForeground(DARKTEXTCOLOR);
        performanceText.setBorder(BorderFactory.createEmptyBorder());
    }


}
