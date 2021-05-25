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
        Number input1 = calculator.pop();
        Number input2 = calculator.pop();
        calculator.push(input1);
        calculator.push(input2);
        calculator.commit();
    }
}
