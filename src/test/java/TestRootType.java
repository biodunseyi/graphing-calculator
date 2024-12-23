import csci2020u.lab09.components.functions.Cosine;
import csci2020u.lab09.components.functions.Sine;
import csci2020u.lab09.components.functions.Tangent;
import csci2020u.lab09.enums.FunctionType;
import csci2020u.lab09.enums.RootType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRootType {
    @Test
    public void testTangentFirstDerivative() {
        Tangent tangent = new Tangent(null, "2tan(3x)");
        double randNum = (Math.random() * 100) + 3;
        Tangent randTangent = new Tangent(null, randNum + "tan(3x)");

        double x = Math.PI / 6;
        double expected = 6 * Math.pow(1 / Math.cos(3 * x), 2);
        double actual = tangent.getValueAt(x, FunctionType.FIRST_DERIVATIVE);

        assertEquals(expected, actual, 0.0001, "First derivative of tangent should match");
        assertNotEquals(randTangent.getValueAt(x, FunctionType.FIRST_DERIVATIVE), actual, "Random should not match");
    }

    @Test
    public void testTangentSecondDerivative() {
        Tangent tangent = new Tangent(null, "2tan(3x)");
        double randNum = (Math.random() * 100) + 3;
        Tangent randTangent = new Tangent(null, randNum + "tan(3x)");

        double x = Math.PI / 6;
        double expected = 36 * Math.pow(1 / Math.cos(3 * x), 2) * Math.tan(3 * x);
        double actual = tangent.getValueAt(x, FunctionType.SECOND_DERIVATIVE);

        assertEquals(expected, actual, 0.0001, "Second derivative of tangent should match");
        assertNotEquals(randTangent.getValueAt(x, FunctionType.SECOND_DERIVATIVE), actual, "Random should not match");
    }

    @Test
    public void testTangentThirdDerivative() {
        Tangent tangent = new Tangent(null, "2tan(3x)");
        double randNum = (Math.random() * 100) + 3;
        Tangent randTangent = new Tangent(null, randNum + "tan(3x)");

        double x = Math.PI / 6;
        double secSquared = Math.pow(1 / Math.cos(3 * x), 2);
        double sec4 = Math.pow(1 / Math.cos(3 * x), 4);
        double tanSquared = Math.pow(Math.tan(3 * x), 2);
        double expected = 216 * secSquared * tanSquared  + 108 * sec4;
        double actual = tangent.getValueAt(x, FunctionType.THIRD_DERIVATIVE);

        assertEquals(expected, actual, 0.0001, "Third derivative of tangent should match");
        assertNotEquals(randTangent.getValueAt(x, FunctionType.THIRD_DERIVATIVE), actual, "Random should not match");
    }

    @Test
    public void testCosineFirstDerivative() {
        Cosine cosine = new Cosine(null, "3cos(2x)");
        double randNum = (Math.random() * 100) + 4;
        Tangent randCos = new Tangent(null, randNum + "cos(2x)");

        double x = Math.PI / 4;
        double expected = -6 * Math.sin(2 * x);
        double actual = cosine.getValueAt(x, FunctionType.FIRST_DERIVATIVE);

        assertEquals(expected, actual, 0.0001, "First derivative of cosine should match");
        assertNotEquals(randCos.getValueAt(x, FunctionType.FIRST_DERIVATIVE), actual, "Random should not match");
    }

    @Test
    public void testCosineSecondDerivative() {
        Cosine cosine = new Cosine(null, "3cos(2x)");
        double randNum = (Math.random() * 100) + 4;
        Tangent randCos = new Tangent(null, randNum + "cos(2x)");

        double x = Math.PI / 4;
        double expected = -12 * Math.cos(2 * x);
        double actual = cosine.getValueAt(x, FunctionType.SECOND_DERIVATIVE);

        assertEquals(expected, actual, 0.0001, "Second derivative of cosine should match");
        assertNotEquals(randCos.getValueAt(x, FunctionType.SECOND_DERIVATIVE), actual, "Random should not match");
    }

    @Test
    public void testCosineThirdDerivative() {
        Cosine cosine = new Cosine(null, "3cos(2x)");
        double randNum = (Math.random() * 100) + 4;
        Tangent randCos = new Tangent(null, randNum + "cos(2x)");

        double x = Math.PI / 4;
        double expected = 24 * Math.sin(2 * x);
        double actual = cosine.getValueAt(x, FunctionType.THIRD_DERIVATIVE);

        assertEquals(expected, actual, 0.0001, "Third derivative of cosine should match");
        assertNotEquals(randCos.getValueAt(x, FunctionType.THIRD_DERIVATIVE), actual, "Random should not match");
    }

    @Test
    public void testNewtonMethodXIntercept() {
        Sine sine = new Sine(null, "2sin(3x)");

        double guess = Math.PI / 3;
        double result = RootType.X_INTERCEPT.newtonsMethod(sine, guess, 100);

        assertEquals(0, sine.getValueAt(result, FunctionType.ORIGINAL), 0.0001, "Root should be close to a known sine root");
    }

    @Test
    public void testNewtonMethodCriticalPoint() {
        Cosine cosine = new Cosine(null, "3cos(2x)");

        double guess = Math.PI / 2;
        double result = RootType.CRITICAL_POINT.newtonsMethod(cosine, guess, 100);

        assertEquals(0, cosine.getValueAt(result, FunctionType.FIRST_DERIVATIVE), 0.0001, "Critical point derivative should be zero");
    }

    @Test
    public void testNewtonMethodInflectionPoint() {
        Sine sine = new Sine(null, "4sin(2x)");

        double guess = Math.PI / 2;
        double result = RootType.INFLECTION_POINT.newtonsMethod(sine, guess, 100);

        assertEquals(0, sine.getValueAt(result, FunctionType.SECOND_DERIVATIVE), 0.0001, "Inflection point second derivative should be zero");
    }
}
