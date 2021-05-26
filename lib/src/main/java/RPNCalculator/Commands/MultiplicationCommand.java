package RPNCalculator.Commands;

import RPNCalculator.Calculator.Number;

/**
 * Command for multiplication operation.
 */
public final class MultiplicationCommand extends BinaryOperationCommand {
    @Override
    Number output(Number input1, Number input2) {
        return new Number(
                input1.getValue().multiply(input2.getValue())
        );
    }
}
