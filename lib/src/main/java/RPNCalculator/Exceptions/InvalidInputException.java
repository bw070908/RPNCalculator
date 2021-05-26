package RPNCalculator.Exceptions;

/**
 * External facing exception for cases where user input is invalid.
 */
public class InvalidInputException extends RuntimeException {
    private String offendingInput;

    public InvalidInputException(String message, String offendingInput) {
        super(message);
        this.offendingInput = offendingInput;
    }

    public String getOffendingInput() {
        return offendingInput;
    }
}
