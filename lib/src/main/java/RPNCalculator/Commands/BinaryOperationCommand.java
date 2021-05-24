package RPNCalculator.Commands;

import RPNCalculator.Calculator.Calculator;
import RPNCalculator.Calculator.Number;

public abstract class BinaryOperationCommand extends OperationCommand {

    abstract Number output(Number input1, Number input2);

    @Override
    int requiredNumberOfParameters() {
        return 2;
    }

    @Override
    void executeOperation(Calculator calculator) {
        calculator.beginInstruction();
        Number input2 = calculator.popNumber();
        Number input1 = calculator.popNumber();
        calculator.pushNumber(output(input1, input2));
        calculator.endInstruction();
    }
}
