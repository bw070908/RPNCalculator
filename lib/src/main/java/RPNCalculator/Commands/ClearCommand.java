package RPNCalculator.Commands;

import RPNCalculator.Calculator.Calculator;

public final class ClearCommand extends OperationCommand {
    @Override
    int requiredNumberOfParameters() {
        return 0;
    }

    @Override
    void executeOperation(Calculator calculator) {
        while(calculator.size() > 0) {
            calculator.pop();
        }
    }
}
