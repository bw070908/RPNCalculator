package RPNCalculator;

import RPNCalculator.Calculator.Calculator;
import RPNCalculator.Commands.Command;

import java.util.ArrayList;
import java.util.List;

public class RPNCalculator {
    private Calculator calculator;
    private CommandParser parser;

    public RPNCalculator() {
        calculator = new Calculator();
        parser = new CommandParser();
    }

    public void process(String input) {
        String[] inputs = input.split(" ");
        List<Command> commands = new ArrayList<Command>();
        for (String in : inputs) {
            commands.add(parser.parse(in));
        }
        commands.forEach(c -> {c.execute(calculator);});
    }

    public String printStack() {
        return calculator.printStack();
    }
}
