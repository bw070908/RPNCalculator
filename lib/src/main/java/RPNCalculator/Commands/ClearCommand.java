package RPNCalculator.Commands;

import RPNCalculator.Calculator.Calculator;

public class ClearCommand extends OperationCommand {
    @Override
    int requiredNumberOfParameters() {
        return 0;
    }

    @Override
    void executeOperation(Calculator calculator) {
        calculator.beginInstruction();
        while(calculator.getStackDepth() > 0) {
            calculator.popNumber();
        }
        calculator.endInstruction();
    }
}
