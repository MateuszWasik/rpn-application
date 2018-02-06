public class Main {
    
   private static String mathematicalEquation;
    
    public static void main(String[] args) {
        
        MathOperationReader mathematicalEquation_inInfixFormat = new MathOperationReader();

        mathematicalEquation = "4*2+7/8";

        System.out.println(mathematicalEquation_inInfixFormat.reader(mathematicalEquation));
    }
    
}
