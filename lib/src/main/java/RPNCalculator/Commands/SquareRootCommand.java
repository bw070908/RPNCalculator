package RPNCalculator.Commands;

import RPNCalculator.Calculator.Number;

public class SquareRootCommand extends UnaryOperationCommand {
    @Override
    Number output(Number input) {
        return new Number(
                input.getValue().sqrt(Number.DEFAULT_MC)
        );
    }
}
