package RPNCalculator.Commands;

import RPNCalculator.Calculator.Calculator;

public abstract class BaseCommand implements Command {

    abstract void executeCommand(Calculator calculator);

    @Override
    public void execute(Calculator calculator) {
        try {
            executeCommand(calculator);
            calculator.commit();
        } catch (CommandExecutionException e) {
            calculator.cancel();
            throw e;
        }
    }
}
