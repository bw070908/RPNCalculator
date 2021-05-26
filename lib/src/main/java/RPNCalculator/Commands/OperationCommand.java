package RPNCalculator.Commands;

import RPNCalculator.Calculator.Calculator;

/**
 * Base class for all operation commands.
 * Operation commands are all the commands that are not Numeric.
 * Most require pre-requesite number of numbers as parameters.
 */
public abstract class OperationCommand extends BaseCommand {

    abstract int requiredNumberOfParameters();

    abstract void executeOperation(Calculator calculator);

    @Override
    public void executeCommand(Calculator calculator) {
        if (requiredNumberOfParameters() >  calculator.size()) {
            throw new CommandExecutionException("insufficient parameters");
        }
        executeOperation(calculator);
    }
}
