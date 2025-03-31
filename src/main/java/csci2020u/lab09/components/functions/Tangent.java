package csci2020u.lab09.components.functions;

import java.util.HashSet;
import csci2020u.lab09.GraphGUI;
import csci2020u.lab09.components.Point;
import csci2020u.lab09.enums.FunctionType;
import csci2020u.lab09.enums.RootType;

public class Tangent extends Trignometric {

    public Tangent(GraphGUI gui, String function) {
        super(gui, function, "tan");
    }

    @Override
    public String getFirstDerivative() {
        return "sec^2(x)";
    }

    @Override
    public String getSecondDerivative() {
        return "2 sec^2(x) tan(x)";
    }

    @Override
    public double getValueAt(double x, FunctionType functionType) {
        if (Math.abs(Math.cos(x)) < 1e-6) {
            return Double.NaN;
        }

        switch (functionType) {
            case FIRST_DERIVATIVE:
                return 1 / (Math.cos(x) * Math.cos(x));
            case SECOND_DERIVATIVE:
                return 2 * (1 / (Math.cos(x) * Math.cos(x))) * Math.tan(x);
            case THIRD_DERIVATIVE:
                return 2 * (1 / (Math.cos(x) * Math.cos(x))) * (1 + 2 * Math.pow(Math.tan(x), 2));
            case ORIGINAL:
            default:
                return Math.tan(x);
        }
    }

    @Override
    public HashSet<Point> getCriticalPoints() {
        return new HashSet<>();
    }

    @Override
    public HashSet<Point> getInflectionPoints() {
        return new HashSet<>();
    }

    @Override
    public HashSet<Point> getXIntercepts() {
        return RootType.X_INTERCEPT.getRoots(gui, this, gui.getMinDomain(), gui.getMaxDomain());
    }
}
