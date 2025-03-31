package csci2020u.lab09.components.functions;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.HashSet;
import csci2020u.lab09.GraphGUI;
import csci2020u.lab09.components.GraphComponent;
import csci2020u.lab09.components.Point;
import csci2020u.lab09.enums.FunctionType;

public abstract class Function extends GraphComponent {

    protected Function(GraphGUI gui) {
        super(gui);
    }

    @Override
    public void draw(Graphics2D g) {
        double minDomain = Math.max(gui.getMinDomain(), -400);
        double maxDomain = Math.min(gui.getMaxDomain(), 400);
        double step = 0.02; // Increment step for x

        g.setColor(Color.BLUE); // Set function color

        for (double x = minDomain; x < maxDomain; x += step) {
            double y1 = getValueAt(x, FunctionType.ORIGINAL);
            double y2 = getValueAt(x + step, FunctionType.ORIGINAL);

            // Convert mathematical coordinates to screen coordinates
            int screenX1 = gui.toScreenX(x);
            int screenY1 = gui.toScreenY(y1);
            int screenX2 = gui.toScreenX(x + step);
            int screenY2 = gui.toScreenY(y2);

            // Ensure points are within the screen bounds before drawing
            if (isWithinRange(y1) && isWithinRange(y2)) {
                g.drawLine(screenX1, screenY1, screenX2, screenY2);
            }
        }
    }

    // Utility method to check if a value is within the graphing range
    private boolean isWithinRange(double y) {
        return y >= gui.getMinRange() && y <= gui.getMaxRange();
    }

    public abstract String getFirstDerivative();

    public abstract String getSecondDerivative();

    public abstract double getValueAt(double x, FunctionType functionType);

    public abstract HashSet<Point> getXIntercepts();

    public abstract HashSet<Point> getCriticalPoints();

    public abstract HashSet<Point> getInflectionPoints();
}
