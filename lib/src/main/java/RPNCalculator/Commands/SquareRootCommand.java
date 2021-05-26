package RPNCalculator.Commands;

import RPNCalculator.Calculator.Number;

import java.math.BigDecimal;

public final class SquareRootCommand extends UnaryOperationCommand {
    @Override
    Number output(Number input) {
        if (input.getValue().compareTo(BigDecimal.ZERO) < 0) {
            throw new CommandExecutionException("cannot take sqrt of negative number");
        }
        return new Number(
                input.getValue().sqrt(Number.DEFAULT_MC)
        );
    }
}
