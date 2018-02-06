public class Stack {

    private String[] stackTab;

    private int firstEmptyIndex;

    Stack(int stackSize) {
        stackTab = new String[stackSize];
        firstEmptyIndex = 0;
    }

    public void pushOnStack(String character) {
        if (firstEmptyIndex < stackTab.length) {
            stackTab[firstEmptyIndex] = character;
            firstEmptyIndex++;
        } else {
            System.out.println("Stack overflow");
        }
    }
    
    public String peekLatestSign() {
        if (firstEmptyIndex != 0) {
            return stackTab[firstEmptyIndex - 1];
        }
        return "Stack is empty";
    }

    public String takeFromStack() {
        if (firstEmptyIndex <= 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        String lastStackElement = stackTab[firstEmptyIndex - 1];
        firstEmptyIndex--;
        return lastStackElement;
    }
    
    public boolean isEmpty(){
        return firstEmptyIndex <= 0;
    }

}
