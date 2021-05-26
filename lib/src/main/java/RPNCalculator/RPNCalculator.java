package RPNCalculator;

import RPNCalculator.Calculator.Calculator;
import RPNCalculator.Commands.Command;
import RPNCalculator.Commands.CommandExecutionException;
import RPNCalculator.Exceptions.OperationException;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * RPNCalculator is the class from the RPNCalculator library exposed to users.
 * Users can input commands to the calculator and examine the state of the stack within the calculator.
 */
public class RPNCalculator {
    private Calculator calculator;
    private InputParser inputParser;
    private CommandParser commandParser;

    public RPNCalculator() {
        calculator = new Calculator();
        inputParser = new InputParser();
        commandParser = new CommandParser();
    }

    /**
     * Method process will have RPNCaclulator process an user inputted string.
     * @param input String representing line with user inputs delimited by whitespace.
     */
    public void process(String input) {
        List<String> inputs = inputParser.parseInput(input);
        List<Integer> positions = inputParser.getPositions(input);
        List<Command> commands = inputs.stream().map(s -> commandParser.parse(s)).collect(toList());
        for (int i = 0; i < commands.size(); i ++) {
            execute(commands.get(i), inputs.get(i), positions.get(i));
        }
    }

    /**
     * Return plain string representing state of the calculator's stack.
     * @return Plain string representation of calculator's stack.
     */
    public String printStack() {
        return calculator.printStack();
    }

    private void execute(Command command, String input, int position) {
        try {
            command.execute(calculator);
        } catch (CommandExecutionException e){
            throw new OperationException(input, position, e.getMessage());
        }
    }
}
