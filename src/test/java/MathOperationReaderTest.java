import org.junit.Test;

import static org.junit.Assert.*;


public class MathOperationReaderTest {

    private MathOperationReader mathOperationReader = new MathOperationReader();
    private String mathEquationWithoutBrackets = "2+3*5";
    private String mathEquationWithBrackets = "2*3+3*(2+2)";
    private String mathEquationWithExtraBracket = "34-3*((3+2)-2";

    @Test
    public void shouldReturnPostfixFormat(){
        assertEquals("2 3 5 * + ", mathOperationReader.convertInfixToPostfix(mathEquationWithoutBrackets));
        assertEquals("2 3 * 3 2 2 + * + ", mathOperationReader.convertInfixToPostfix(mathEquationWithBrackets));
    }

    @Test
    public void shouldNotCompleteBecauseOfExtraBracket(){
        assertNotEquals("34 3 3 2 + * 2 - - ",mathOperationReader.convertInfixToPostfix(mathEquationWithExtraBracket));
    }
}