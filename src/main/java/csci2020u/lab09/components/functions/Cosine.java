package csci2020u.lab09.components.functions;

import java.util.HashSet;
import csci2020u.lab09.GraphGUI;
import csci2020u.lab09.components.Point;
import csci2020u.lab09.enums.FunctionType;
import csci2020u.lab09.enums.RootType;

public class Cosine extends Trignometric {

    public Cosine(GraphGUI gui, String function) {
        super(gui, function, "cos");
    }

    @Override
    public String getFirstDerivative() {
        return "-sin(x)";
    }

    @Override
    public String getSecondDerivative() {
        return "-cos(x)";
    }

    @Override
    public double getValueAt(double x, FunctionType functionType) {
        switch (functionType) {
            case FIRST_DERIVATIVE:
                return -Math.sin(x);
            case SECOND_DERIVATIVE:
                return -Math.cos(x);
            case THIRD_DERIVATIVE:
                return Math.sin(x);
            case ORIGINAL:
            default:
                return Math.cos(x);
        }
    }

    @Override
    public HashSet<Point> getXIntercepts() {
        return RootType.X_INTERCEPT.getRoots(gui, this, gui.getMinDomain(), gui.getMaxDomain());
    }

    @Override
    public HashSet<Point> getCriticalPoints() {
        return RootType.CRITICAL_POINT.getRoots(gui, this, gui.getMinDomain(), gui.getMaxDomain());
    }

    @Override
    public HashSet<Point> getInflectionPoints() {
        return RootType.INFLECTION_POINT.getRoots(gui, this, gui.getMinDomain(), gui.getMaxDomain());
    }
}
