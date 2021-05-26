package RPNCalculator.Commands;

/**
 * Custom exception class for runtime exceptions while executing commands.
 */
public class CommandExecutionException extends RuntimeException{
    public CommandExecutionException(String message) {
        super(message);
    }

    public CommandExecutionException(String message, Throwable cause) {
        super(message, cause);
    }
}
