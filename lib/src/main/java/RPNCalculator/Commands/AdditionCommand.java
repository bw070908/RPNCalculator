package RPNCalculator.Commands;

import RPNCalculator.Calculator.Number;

public class AdditionCommand extends BinaryOperationCommand {
    @Override
    Number output(Number input1, Number input2) {
        return new Number(
                input1.getValue().add(input2.getValue())
        );
    }
}
