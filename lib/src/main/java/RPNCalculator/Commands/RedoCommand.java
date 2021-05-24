package RPNCalculator.Commands;

import RPNCalculator.Calculator.Calculator;

public class RedoCommand extends OperationCommand {
    @Override
    int requiredNumberOfParameters() {
        return 0;
    }

    @Override
    void executeOperation(Calculator calculator) {
        calculator.redo();
    }
}
