package csci2020u.lab09.components.functions;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import csci2020u.lab09.GraphGUI;
import csci2020u.lab09.components.Point;
import csci2020u.lab09.enums.FunctionType;
import csci2020u.lab09.enums.RootType;

public class Logarithmic extends Function {

    public double a;
    public double base;
    public double k;

    public Logarithmic(GraphGUI gui, String function) {
        super(gui);
        Pattern sortLog = Pattern.compile("^([+\\-])?(\\d+(\\.\\d+)?)?(log([+\\-])?(\\d+(\\.\\d+)?)?|ln)\\(([+\\-])?(\\d+(.\\d+)?)?x\\)$");
        Matcher matcher = sortLog.matcher(function);

        if (matcher.find()) {
            a = (matcher.group(2) == null) ?
                    (matcher.group(1) != null) ? (matcher.group(1).equals("-")) ? -1 : 1 : 1
                    : (matcher.group(1) != null) ? (matcher.group(1).equals("-")) ? -Double.parseDouble(matcher.group(2)) : Double.parseDouble(matcher.group(2))
                    : Double.parseDouble(matcher.group(2));

            k = (matcher.group(9) == null) ?
                    (matcher.group(8) != null) ? (matcher.group(8).equals("-")) ? -1 : 1 : 1
                    : (matcher.group(8) != null) ? (matcher.group(8).equals("-")) ? -Double.parseDouble(matcher.group(9)) : Double.parseDouble(matcher.group(9))
                    : Double.parseDouble(matcher.group(9));

            base = (matcher.group(4).contains("log")) ?
                    (matcher.group(5) != null) ?
                            (matcher.group(5).equals("-")) ?
                                    (matcher.group(6) == null) ? -10 : -Double.parseDouble(matcher.group(6))
                                    : (matcher.group(6) == null) ? 10 : Double.parseDouble(matcher.group(6))
                            : (matcher.group(6) == null) ? 10 : Double.parseDouble(matcher.group(6))
                    : (matcher.group(5) != null ? (matcher.group(5).equals("-")) ? -Math.E : Math.E : Math.E);
        }
    }

    @Override
    public String getFirstDerivative() {
        return (base == Math.E) ? a + "/x" : a + "/(xln(" + base + "))";
    }

    @Override
    public String getSecondDerivative() {
        return (base == Math.E) ? -a + "/x^2" : -a + "/(x^2ln(" + base + "))";
    }

    @Override
    public double getValueAt(double x, FunctionType functionType) {
        if (x <= 0) return Double.NaN;

        switch (functionType) {
            case FIRST_DERIVATIVE:
                return a / (x * Math.log(base));
            case SECOND_DERIVATIVE:
                return -a / (x * x * Math.log(base));
            case THIRD_DERIVATIVE:
                return 2 * a / (Math.pow(x, 3) * Math.log(base));
            default:
                return a * Math.log(k * x) / Math.log(base);
        }
    }

    @Override
    public HashSet<Point> getXIntercepts() {
        return RootType.X_INTERCEPT.getRoots(gui, this, gui.getMinDomain(), gui.getMaxDomain());
    }

    @Override
    public HashSet<Point> getCriticalPoints() {
        return new HashSet<>();
    }

    @Override
    public HashSet<Point> getInflectionPoints() {
        return new HashSet<>();
    }
}
