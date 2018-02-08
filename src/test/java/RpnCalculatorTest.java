import org.junit.Test;

import static org.junit.Assert.*;

public class RpnCalculatorTest {

    RpnCalculator rpnCalculator = new RpnCalculator();

    private String infixFormatFirstParam = "34 3 3 2 + * 2 - - ";

    private String infixFormatSecondParam = "12 2 3 4 * 10 5 / + * + ";


    @Test
    public void postfixFormatCalculator() {

        assertEquals("-47", rpnCalculator.postfixFormatCalculator(infixFormatFirstParam));
        assertEquals("40", rpnCalculator.postfixFormatCalculator(infixFormatSecondParam));
    }
}