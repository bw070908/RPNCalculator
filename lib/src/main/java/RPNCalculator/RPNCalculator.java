package RPNCalculator;

import RPNCalculator.Calculator.Calculator;
import RPNCalculator.Commands.Command;
import RPNCalculator.Commands.CommandExecutionException;
import RPNCalculator.Exceptions.OperationException;
import com.google.common.base.Splitter;

import java.util.ArrayList;
import java.util.List;

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
        List<Command> commands = new ArrayList<Command>();
        for (String in : inputs) {
            commands.add(commandParser.parse(in));
        }
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
