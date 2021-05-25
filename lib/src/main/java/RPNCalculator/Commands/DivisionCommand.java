package RPNCalculator.Commands;

import RPNCalculator.Calculator.Number;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class DivisionCommand extends BinaryOperationCommand {
    @Override
    Number output(Number input1, Number input2) {
        if (input2.getValue().compareTo(BigDecimal.ZERO) == 0) {
            throw new CommandExecutionException("cannot divide by 0");
        }
        return new Number(
                input1.getValue().divide(
                        input2.getValue(),
                        Number.DEFAULT_PRECISION,
                        RoundingMode.HALF_UP
                )
        );
    }
}
