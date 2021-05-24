package RPNCalculator.Commands;

import RPNCalculator.Calculator.Calculator;

public class UndoCommand extends OperationCommand {
    @Override
    int requiredNumberOfParameters() {
        return 0;
    }

    @Override
    void executeOperation(Calculator calculator) {
        calculator.undo();
    }
}
