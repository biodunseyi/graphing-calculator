package csci2020u.lab09.components.functions;

import java.awt.Graphics2D;
import java.util.HashSet;
import csci2020u.lab09.GraphGUI;
import csci2020u.lab09.components.GraphComponent;
import csci2020u.lab09.components.Point;
import csci2020u.lab09.enums.FunctionType;
import csci2020u.lab09.enums.RootType;

public abstract class Function extends GraphComponent {
    
    
    protected Function(GraphGUI gui) {
        super(gui);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        /*
        * TODO: Graph the function
        *  - Increment x at a small step, s (e.g. 0.02)
        *  - Call getValueAt() to get f(x). Use `FunctionType.ORIGINAL` as the function type to call getValueAt().
        *  - Draw a line from (x, f(x)) to (x + s, f(x + s))
        *
        *  Optional:
        *  - The drawing function can respond to zooming
        *  - The drawing function can respond to domain and range scales.
        *  - The drawing function only draws within the domain and range
        * */
    }

    public HashSet<Point> getXIntercepts() {
        return RootType.X_INTERCEPT.getRoots(gui, this, Math.max(gui.getPlaneWidth() / gui.getZoom() * gui.getDomainStep() / -2, gui.getMinDomain()), Math.min(gui.getPlaneWidth() / gui.getZoom() * gui.getDomainStep() / 2, gui.getMaxDomain()));
    }

    public HashSet<Point> getCriticalPoints() {
        return RootType.CRITICAL_POINT.getRoots(gui, this, Math.max(gui.getPlaneWidth() / gui.getZoom() * gui.getDomainStep() / -2, gui.getMinDomain()), Math.min(gui.getPlaneWidth() / gui.getZoom() * gui.getDomainStep() / 2, gui.getMaxDomain()));
    }

    public HashSet<Point> getInflectionPoints() {
        return RootType.INFLECTION_POINT.getRoots(gui, this, Math.max(gui.getPlaneWidth() / gui.getZoom() * gui.getDomainStep() / -2, gui.getMinDomain()), Math.min(gui.getPlaneWidth() / gui.getZoom() * gui.getDomainStep() / 2, gui.getMaxDomain()));
    }

    public abstract String getFirstDerivative();

    public abstract String getSecondDerivative();

    public abstract double getValueAt(double x, FunctionType functionType);
}
