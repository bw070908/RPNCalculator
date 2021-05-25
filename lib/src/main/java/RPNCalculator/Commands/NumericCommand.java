package RPNCalculator.Commands;

import RPNCalculator.Calculator.Calculator;
import RPNCalculator.Calculator.Number;

public final class NumericCommand implements Command {

    private Number value;

    public NumericCommand(Number number) {
        this.value = number;
    }

    @Override
    public void execute(Calculator calculator) {
        calculator.push(this.value);
        calculator.commit();
    }
}
