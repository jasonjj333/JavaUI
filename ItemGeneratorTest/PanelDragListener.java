package ItemGeneratorTest;


import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.Point;

public class PanelDragListener extends MouseAdapter{
    private final JPanel panel;
    private final JFrame frame;
    private Point mouseDownCompCoords = null;

    public PanelDragListener(JPanel panel, JFrame frame) {
        this.panel = panel;
        this.frame = frame;
    }
    public void mouseReleased(MouseEvent e) {
        mouseDownCompCoords = null;
    }

    public void mousePressed(MouseEvent e) {
        mouseDownCompCoords = e.getPoint();
    }

    public void mouseDragged(MouseEvent e) {
        Point currCoords = e.getLocationOnScreen();
        frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
    }

}
