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
        
        if(element.equals(PLUS) || element.equals(MINUS)) return 1;
        if(element.equals(MULTIPLICATION) || element.equals(DIVISION)) return 2;
        return 0;
    }
    
}
