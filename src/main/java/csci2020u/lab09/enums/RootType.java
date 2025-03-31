package csci2020u.lab09.enums;

import java.awt.Color;
import java.util.HashSet;
import csci2020u.lab09.GraphGUI;
import csci2020u.lab09.components.Point;
import csci2020u.lab09.components.functions.Function;
import csci2020u.lab09.enums.FunctionType;

public enum RootType {
    X_INTERCEPT(Color.decode("#C2BCFF"), "X-INT", FunctionType.ORIGINAL, FunctionType.FIRST_DERIVATIVE),
    CRITICAL_POINT(Color.decode("#6330DB"), "CP", FunctionType.FIRST_DERIVATIVE, FunctionType.SECOND_DERIVATIVE),
    INFLECTION_POINT(Color.decode("#D331E2"), "IP", FunctionType.SECOND_DERIVATIVE, FunctionType.THIRD_DERIVATIVE);

    private final Color color;
    private final String name;
    private final int ATTEMPTS = 100;
    private final FunctionType functionOne;
    private final FunctionType functionTwo;

    RootType(Color color, String name, FunctionType functionOne, FunctionType functionTwo) {
        this.color = color;
        this.name = name;
        this.functionOne = functionOne;
        this.functionTwo = functionTwo;
    }

    public Color getPointColor() {
        return color;
    }

    public String getPointName() {
        return name;
    }

    public HashSet<Point> getRoots(GraphGUI gui, Function function, double minDomain, double maxDomain) {
        HashSet<Point> addPoint = new HashSet<>();

        for (double i = minDomain - 0.01; i < maxDomain + 0.01; i += 0.01) {
            double x = newtonsMethod(function, i, ATTEMPTS);
            if (!Double.isNaN(x)) {
                addPoint.add(new Point(gui, this, x, function.getValueAt(x, FunctionType.ORIGINAL)));
            }
        }
        return addPoint;
    }

    public double newtonsMethod(Function function, double guess, int attempts) {
        final double TOLERANCE = 1e-6;
        final double EPSILON = 1e-6;

        double x = guess;
        for (int i = 0; i < attempts; i++) {
            double f_x = function.getValueAt(x, functionOne);
            double f_prime_x = function.getValueAt(x, functionTwo);

            if (Math.abs(f_prime_x) < EPSILON) return Double.NaN;

            double nextX = x - (f_x / f_prime_x);
            if (Math.abs(nextX - x) < TOLERANCE) return nextX;

            x = nextX;
        }

        return Double.NaN;
    }
}
