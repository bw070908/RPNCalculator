package RPNCalculator.Commands;

import RPNCalculator.Calculator.Calculator;

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
