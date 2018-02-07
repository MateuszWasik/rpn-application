public class Main {


    public static void main(String[] args) {

        MathOperationReader mathematicalEquation_inInfixFormat = new MathOperationReader();

        RpnCalculator mathematicalEquation_inPosfixFormat = new RpnCalculator();

        String mathematicalEquation = "2*3+3*(2+2)";

        System.out.println(mathematicalEquation_inInfixFormat.convertInfixToPostfix(mathematicalEquation));
        System.out.println(mathematicalEquation_inPosfixFormat.postfixFormatCalculator(mathematicalEquation_inInfixFormat.convertInfixToPostfix(mathematicalEquation)));


    }

}
