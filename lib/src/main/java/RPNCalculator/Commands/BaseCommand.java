package RPNCalculator.Commands;

import RPNCalculator.Calculator.Calculator;

/**
 * Base class for all commands.
 * Handles basic interactions with Calculator class and exception handling.
 */
public abstract class BaseCommand implements Command {

    abstract void executeCommand(Calculator calculator);

    @Override
    public void execute(Calculator calculator) {
        try {
            executeCommand(calculator);
            calculator.commit();
        } catch (CommandExecutionException e) {
            calculator.cancel();
            throw e;
        } catch (Exception e) {
            calculator.cancel();
            throw new CommandExecutionException(e.getMessage(), e);
        }
    }
}
