import java.util.StringTokenizer;


public class MathOperationReader {


    private boolean isMoreImportant(String presentElement, Stack stack) {

        return OperatorsEnum.getMathOperationPriority(stack.peekLatestSign()) <= OperatorsEnum.getMathOperationPriority(presentElement);
    }

    private boolean isMathematicalOperator(String checkedElement) {

        return checkedElement.equals(OperatorsEnum.PLUS.getOperator()) || checkedElement.equals(OperatorsEnum.MINUS.getOperator()) || checkedElement.equals(OperatorsEnum.MULTIPLICATION.getOperator()) || checkedElement.equals(OperatorsEnum.DIVISION.getOperator());
    }

    public String reader(String mathematicalEquation_inNormalFormat) {

        StringTokenizer cutMathematicalEquation = new StringTokenizer(mathematicalEquation_inNormalFormat, "+/()-*", true);

        StringBuilder mathematicalEquation_inPostfixFormat = new StringBuilder();

        Stack stack = new Stack(mathematicalEquation_inNormalFormat.length());

        while (cutMathematicalEquation.hasMoreTokens()) {

            String element = cutMathematicalEquation.nextToken();

            if (isMathematicalOperator(element)) {
                if (isMoreImportant(element, stack)) {
                    stack.pushOnStack(element);
                } else {
                    mathematicalEquation_inPostfixFormat.append(stack.takeFromStack());
                    mathematicalEquation_inPostfixFormat.append(" ");
                    stack.pushOnStack(element);
                }
            } else if (element.equals(OperatorsEnum.OPEN_BRACKET.getOperator())) {
                stack.pushOnStack(element);
            } else if (element.equals(OperatorsEnum.CLOSING_BRACKET.getOperator())) {

                while (!stack.peekLatestSign().equals("(")) {
                    mathematicalEquation_inPostfixFormat.append(stack.peekLatestSign());
                    mathematicalEquation_inPostfixFormat.append(" ");
                }
            } else {
                mathematicalEquation_inPostfixFormat.append(element);
                mathematicalEquation_inPostfixFormat.append(" ");
            }
        }
        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                mathematicalEquation_inPostfixFormat.append(stack.takeFromStack());
                mathematicalEquation_inPostfixFormat.append(" ");
            }
        }
        return mathematicalEquation_inPostfixFormat.toString();
    }
}

