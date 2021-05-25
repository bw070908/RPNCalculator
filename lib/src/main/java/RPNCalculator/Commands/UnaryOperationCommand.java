package RPNCalculator.Commands;

import RPNCalculator.Calculator.Calculator;
import RPNCalculator.Calculator.Number;

public abstract class UnaryOperationCommand extends OperationCommand {

    abstract Number output(Number input);

    @Override
    int requiredNumberOfParameters() {
        return 1;
    }

    @Override
    void executeOperation(Calculator calculator) {
        calculator.push(output(calculator.pop()));
        calculator.commit();
    }
}
