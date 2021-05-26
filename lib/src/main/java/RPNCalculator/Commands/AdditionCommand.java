package RPNCalculator.Commands;

import RPNCalculator.Calculator.Number;

/**
 * Command for addition operation.
 */
public final class AdditionCommand extends BinaryOperationCommand {
    @Override
    Number output(Number input1, Number input2) {
        return new Number(
                input1.getValue().add(input2.getValue())
        );
    }
}
