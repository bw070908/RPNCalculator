package RPNCalculator.Commands;

import RPNCalculator.Calculator.Calculator;
import RPNCalculator.Calculator.Number;

public final class SwapCommand extends OperationCommand {
    @Override
    int requiredNumberOfParameters() {
        return 2;
    }

    @Override
    void executeOperation(Calculator calculator) {
        calculator.beginInstruction();
        Number input1 = calculator.popNumber();
        Number input2 = calculator.popNumber();
        calculator.pushNumber(input1);
        calculator.pushNumber(input2);
        calculator.endInstruction();
    }
}
