package RPNCalculator.Commands;

import RPNCalculator.Calculator.Number;

/**
 * Command for subtraction operation.
 */
public final class SubtractionCommand extends BinaryOperationCommand {
    @Override
    Number output(Number input1, Number input2) {
        return new Number(
                input1.getValue().subtract(input2.getValue())
        );
    }
}
