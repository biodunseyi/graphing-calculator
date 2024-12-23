package csci2020u.lab09.components.functions;

import java.util.HashSet;
import csci2020u.lab09.GraphGUI;
import csci2020u.lab09.components.Point;
import csci2020u.lab09.enums.FunctionType;

public class Tangent extends Trignometric {
    
    public Tangent(GraphGUI gui, String function) {
        super(gui, function, "tan");
    }

    @Override
    public String getFirstDerivative() {
        /*
         * TODO: Return first derivative. Check Sine.java for an example.
         * */

        return "";
    }

    @Override
    public String getSecondDerivative() {
        /*
         * TODO: Return second derivative. Check Sine.java for an example.
         * */

        return "";
    }

    @Override
    public double getValueAt(double x, FunctionType functionType) {
        /*
         * TODO: Return the y-value at x given the function. Check Sine.java for an example.
         *  - Note the function type. For example, if functionType is FIRST_DERIVATIVE, use the the first derivative function to get the y-value.
         *  - Note there are four cases of functionType: FIRST_DERIVATIVE, SECOND_DERIVATIVE, THIRD_DERIVATIVE and ORIGINAL
         * */

        return 0;
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
