package RPNCalculator.Commands;

import RPNCalculator.Calculator.Calculator;

/**
 * Command for redo operation.
 */
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
