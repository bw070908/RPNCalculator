package RPNCalculator.Commands;

public class CommandExecutionException extends RuntimeException{
    public CommandExecutionException(String message) {
        super(message);
    }
}
