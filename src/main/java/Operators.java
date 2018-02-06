public enum Operators {
    
    PLUS("+"),
    MINUS("-"),
    MULTIPLICATION("*"),
    DIVISION("/"),
    OPEN_BRACKET("("),
    CLOSING_BRACKET(")");
    
    private String operator;
    
    Operators(String operator){
        this.operator = operator;
    }
    
    public String getOperator(){
        return this.operator;
    }
    
    public static int getMathOperationPriority(String element){
        
        if(element.equals(PLUS.getOperator()) || element.equals(MINUS.getOperator())) return 1;
        if(element.equals(MULTIPLICATION.getOperator()) || element.equals(DIVISION.getOperator())) return 2;
        else {return 0;}
    }
}
