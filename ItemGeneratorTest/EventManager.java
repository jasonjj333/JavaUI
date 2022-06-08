package ItemGeneratorTest;

import javax.swing.*;
import java.awt.*;

public class EventManager {
    JPanel panel;
    private Color TEXTCOLOR;
    private Color FOREGROUNDCOLOR;
    private Color DARKTEXTCOLOR;
    private Color BACKGROUNDCOLOR;
    private Font openSans16;

    public EventManager(Color tcolor, Color fcolor, Color bcolor, Color dtcolor, Font font) {
        TEXTCOLOR = tcolor;
        FOREGROUNDCOLOR = fcolor;
        BACKGROUNDCOLOR = bcolor;
        DARKTEXTCOLOR = dtcolor;
        openSans16 = font;
    }
    public void updateBoxField(OvalCheck box, JTextField field) {
        if(box.isSelected()) {
            field.setForeground(TEXTCOLOR);
            field.setEditable(true);
            box.setColorNormal(TEXTCOLOR);
            box.setForeground(FOREGROUNDCOLOR);
            box.setColorHighlighted(TEXTCOLOR);
        }
        else {
            field.setForeground(DARKTEXTCOLOR);
            field.setEditable(false);
            box.setColorNormal(FOREGROUNDCOLOR);
            box.setForeground(TEXTCOLOR);
            box.setColorHighlighted(FOREGROUNDCOLOR);
        }
    }
    public void updateBox(OvalCheck box) {
        if (box.isSelected()) {
            box.setColorNormal(TEXTCOLOR);
            box.setForeground(FOREGROUNDCOLOR);
            box.setColorHighlighted(TEXTCOLOR);
        } else {
            box.setColorNormal(FOREGROUNDCOLOR);
            box.setForeground(TEXTCOLOR);
            box.setColorHighlighted(FOREGROUNDCOLOR);
        }
    }

    public String getCommandLine(OvalCheck box, JTextField field, String call) {
        if(box.isSelected()&& !field.getText().equals("")) {
            System.out.println(box.getText() + ": " + field.getText());
            //performanceText.append("\n" + box.getText() + ": " + maxItemsField.getText());
            return " " + call + " " + field.getText();
        }
        return "";
    }
    public String getCommandLine( OvalCheck box, JTextField field, String call, String defaultText) {
        if(box.isSelected() && !field.getText().equals("")) {
            System.out.println("Cycle Number: " + field.getText());
            //performanceText.append(("\nCycle Number: " + cycleNumberField.getText()));
            return " " + call + " " + field.getText();
        }
        else {
            return " " + call + " " + defaultText;
        }
    }
    public String getCommandLine(OvalCheck box, String call) {
        if(box.isSelected()) {
            System.out.println(box.getText() + " is selected.");
            //performanceText.append("\n" + box.getText() + " is selected.");
            return " " + call;
        }
        //System.out.print("CMD Command: " + output + "\n");
        //performanceText.append("\nCMD Command: " + output);
        return "";
    }


}
