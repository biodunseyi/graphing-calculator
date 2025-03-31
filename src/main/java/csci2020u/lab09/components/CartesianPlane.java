package csci2020u.lab09.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import csci2020u.lab09.GraphGUI;

public class CartesianPlane extends GraphComponent {

    public CartesianPlane(GraphGUI gui) {
        super(gui);
    }

    @Override
    public void draw(Graphics2D g) {
        int width = gui.getGraphPanel().getWidth();
        int height = gui.getGraphPanel().getHeight();
        int midX = width / 2;
        int midY = height / 2;
        int spacing = 50;  // Distance between grid lines

        g.setColor(Color.LIGHT_GRAY);
        g.setStroke(new BasicStroke(1));

        // Draw vertical grid lines
        for (int x = 0; x <= width; x += spacing) {
            g.drawLine(x, 0, x, height);
        }

        // Draw horizontal grid lines
        for (int y = 0; y <= height; y += spacing) {
            g.drawLine(0, y, width, y);
        }

        // Draw the x and y axes
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(2));
        g.drawLine(midX, 0, midX, height); // Y-axis
        g.drawLine(0, midY, width, midY); // X-axis

        // Label the axes
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        for (int x = spacing; x < width; x += spacing) {
            g.drawString(Integer.toString((x - midX) / spacing), x + 2, midY - 2);
            g.drawString(Integer.toString((-x + midX) / spacing), midX - x + 2, midY - 2);
        }
        for (int y = spacing; y < height; y += spacing) {
            g.drawString(Integer.toString((-y + midY) / spacing), midX + 2, y - 2);
            g.drawString(Integer.toString((y - midY) / spacing), midX + 2, midY - y - 2);
        }
    }
}