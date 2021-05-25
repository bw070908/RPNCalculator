package RPNCalculator.Exceptions;

public class InvalidInputException extends RuntimeException {
    private String offendingInput;

    public InvalidInputException(String offendingInput, String message) {
        super(message);
        this.offendingInput = offendingInput;
    }

    public String getOffendingInput() {
        return offendingInput;
    }
}
