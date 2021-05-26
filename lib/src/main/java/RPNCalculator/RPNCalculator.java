package RPNCalculator;

import RPNCalculator.Calculator.Calculator;
import RPNCalculator.Commands.Command;
import RPNCalculator.Commands.CommandExecutionException;
import RPNCalculator.Exceptions.OperationException;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class RPNCalculator {
    private Calculator calculator;
    private InputParser inputParser;
    private CommandParser commandParser;

    public RPNCalculator() {
        calculator = new Calculator();
        inputParser = new InputParser();
        commandParser = new CommandParser();
    }

    public void process(String input) {
        List<String> inputs = inputParser.parseInput(input);
        List<Integer> positions = inputParser.getPositions(input);
        List<Command> commands = inputs.stream().map(s -> commandParser.parse(s)).collect(toList());
        for (int i = 0; i < commands.size(); i ++) {
            execute(commands.get(i), inputs.get(i), positions.get(i));
        }
    }

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
