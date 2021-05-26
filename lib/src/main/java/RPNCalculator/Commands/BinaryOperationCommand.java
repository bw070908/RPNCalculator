package RPNCalculator.Commands;

import RPNCalculator.Calculator.Calculator;
import RPNCalculator.Calculator.Number;

/**
 * Base class for all binary operations.
 * Binary operations (such as + - * /) consume 2 parameters and returns 1 output.
 */
public abstract class BinaryOperationCommand extends OperationCommand {

    abstract Number output(Number input1, Number input2);

    @Override
    int requiredNumberOfParameters() {
        return 2;
    }

    @Override
    void executeOperation(Calculator calculator) {
        Number input2 = calculator.pop();
        Number input1 = calculator.pop();
        calculator.push(output(input1, input2));
    }
}
