package RPNCalculator.Commands;

import RPNCalculator.Calculator.Number;

import java.math.BigDecimal;

public final class DivisionCommand extends BinaryOperationCommand {
    @Override
    Number output(Number input1, Number input2) {
        if (input2.getValue().compareTo(BigDecimal.ZERO) == 0) {
            throw new CommandExecutionException("cannot divide by 0");
        }
        return new Number(
                input1.getValue().stripTrailingZeros().divide(
                        input2.getValue().stripTrailingZeros(),
                        Number.DEFAULT_SCALE,
                        Number.DEFAULT_ROUNDING_MODE
                )
        );
    }
}
