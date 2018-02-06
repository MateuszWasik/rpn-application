public enum OperatorsEnum {
    
    PLUS("+", 1),
    MINUS("-", 1),
    MULTIPLICATION("*", 2),
    DIVISION("/", 2),
    OPEN_BRACKET("(", 0),
    CLOSING_BRACKET(")", 0);
    
    private String operator;
    private int priority;

    OperatorsEnum(String operator, int priority){
        this.operator = operator;
        this.priority = priority;
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
