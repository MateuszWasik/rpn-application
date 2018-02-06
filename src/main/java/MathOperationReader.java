import java.util.StringTokenizer;


public class MathOperationReader {


    private boolean isMoreImportant(String presentElement, Stack stack){

        return Operators.getMathOperationPriority(stack.peekLatestSign()) <= Operators.getMathOperationPriority(presentElement);
    }

    private boolean isMathematicalOperator(String checkedElement){

        return checkedElement.equals(Operators.PLUS.getOperator()) || checkedElement.equals(Operators.MINUS.getOperator()) || checkedElement.equals(Operators.MULTIPLICATION.getOperator()) || checkedElement.equals(Operators.DIVISION.getOperator());
    }

    public String reader(String mathematicalEquation_inNormalFormat) {

        StringTokenizer cutMathematicalEquation = new StringTokenizer(mathematicalEquation_inNormalFormat, "+/()-*",
                true);

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
            } else if (element.equals(Operators.OPEN_BRACKET.getOperator())) {
                stack.pushOnStack(element);
            } else if (element.equals(Operators.CLOSING_BRACKET.getOperator())) {

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

