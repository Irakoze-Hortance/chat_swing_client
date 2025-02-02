package components.Teams.edit;

import javax.swing.border.AbstractBorder;
import java.awt.*;

public class CustomBorder extends AbstractBorder {
    public void paintBorder(Component c, Graphics g, int x, int y,
                            int width, int height) {
        super.paintBorder(c, g, x, y, width, height);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(12));
        g2d.drawRoundRect(x, y, width - 1, height - 1, 25, 25);
    }
}
