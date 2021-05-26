package RPNCalculator.Commands;

import RPNCalculator.Calculator.Calculator;

/**
 * Interface for all commands that can be executed.
 */
public interface Command {

    void execute(Calculator calculator);

}
