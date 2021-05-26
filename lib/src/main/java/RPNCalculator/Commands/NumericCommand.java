package RPNCalculator.Commands;

import RPNCalculator.Calculator.Calculator;
import RPNCalculator.Calculator.Number;

/**
 * Command for numeric inputs.
 */
public final class NumericCommand extends BaseCommand {

    private Number value;

    public NumericCommand(Number number) {
        this.value = number;
    }

    @Override
    public void executeCommand(Calculator calculator) {
        calculator.push(this.value);
    }
}
