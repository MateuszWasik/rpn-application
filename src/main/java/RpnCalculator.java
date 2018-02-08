import java.util.StringTokenizer;

public class RpnCalculator implements MathematicalOperatorChecker {

    public String postfixFormatCalculator(String postfixFormatEquation) {

        StringTokenizer cutPostfixEquation = new StringTokenizer(postfixFormatEquation, " ", false);

        Stack stackLast = new Stack(postfixFormatEquation.length());

        while (cutPostfixEquation.hasMoreTokens()) {

            String element = cutPostfixEquation.nextToken();

            if (!isMathematicalOperator(element)) {
                stackLast.pushOnStack(element);
            } else {
                stackLast.pushOnStack(stackLast.doMathAccordingToOperator(element));
            }
        }
        return stackLast.peekLatestSign();

    }

    @Override
    public boolean isMathematicalOperator(String checkedElement) {
        return checkedElement.equals(OperatorsEnum.PLUS.getOperator()) || checkedElement.equals(OperatorsEnum.MINUS.getOperator()) || checkedElement.equals(OperatorsEnum.MULTIPLICATION.getOperator()) || checkedElement.equals(OperatorsEnum.DIVISION.getOperator());
    }
}
