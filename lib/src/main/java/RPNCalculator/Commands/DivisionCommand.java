package RPNCalculator.Commands;

import RPNCalculator.Calculator.Number;

public class DivisionCommand extends BinaryOperationCommand {
    @Override
    Number output(Number input1, Number input2) {
        return new Number(
                input1.getValue().divide(input2.getValue())
        );
    }
}
