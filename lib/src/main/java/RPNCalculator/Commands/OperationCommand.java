package RPNCalculator.Commands;

import RPNCalculator.Calculator.Calculator;

public abstract class OperationCommand implements Command {

    abstract int requiredNumberOfParameters();

    abstract void executeOperation(Calculator calculator);

    @Override
    public void execute(Calculator calculator) {
        if (requiredNumberOfParameters() >  calculator.getStackDepth()) {
            throw new CommandExecutionException("Not enough parameters.");
        }
        executeOperation(calculator);
    }
}
