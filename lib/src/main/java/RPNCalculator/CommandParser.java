package RPNCalculator;

import RPNCalculator.Calculator.Number;
import RPNCalculator.Commands.*;
import RPNCalculator.Exceptions.InvalidInputException;

import java.util.Map;

public class CommandParser {

    private final Map<String, Command> STRING_TO_OPERATION_MAP = Map.of(
            "+", new AdditionCommand(),
            "-", new SubtractionCommand(),
            "*", new MultiplicationCommand(),
            "/", new DivisionCommand(),
            "sqrt", new SquareRootCommand(),
            "swap", new SwapCommand(),
            "clear", new ClearCommand(),
            "undo", new UndoCommand(),
            "redo", new RedoCommand()
    );

    public Command parse(String input) {
        if (STRING_TO_OPERATION_MAP.containsKey(input)) {
            return STRING_TO_OPERATION_MAP.get(input);
        }
        return parseNumeric(input);
    }

    private NumericCommand parseNumeric(String input) {
        Number number;
        try {
            number = new Number(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(input, "expression is not a number nor an operation");
        }
        return new NumericCommand(number);
    }
}
