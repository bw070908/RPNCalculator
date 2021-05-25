package RPNCalculator;

import RPNCalculator.Calculator.Calculator;
import RPNCalculator.Commands.Command;
import com.google.common.base.Splitter;

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
        List<String> inputs = Splitter.on(" ").omitEmptyStrings().splitToList(input);
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
