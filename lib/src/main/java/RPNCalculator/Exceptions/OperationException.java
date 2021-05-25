package RPNCalculator.Exceptions;

public class OperationException extends RuntimeException {
    private String operationSymbol;
    private int position;

    public OperationException(String operationSymbol, int position, String message) {
        super(message);
        this.operationSymbol = operationSymbol;
        this.position = position;
    }

    public String getOperationSymbol() {
        return operationSymbol;
    }

    public int getPosition() {
        return position;
    }
}
