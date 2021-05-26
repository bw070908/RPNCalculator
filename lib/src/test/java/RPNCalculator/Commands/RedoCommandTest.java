package RPNCalculator.Commands;

import RPNCalculator.Calculator.Calculator;
import RPNCalculator.Calculator.Number;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RedoCommandTest {

    private RedoCommand cut = new RedoCommand();
    private UndoCommand undoCommand = new UndoCommand();

    @Test
    public void testRedoRevertsUndoneInstruction() {
        Calculator calculator = new Calculator();
        calculator.push(new Number("1"));
        calculator.push(new Number("2"));
        calculator.commit();
        calculator.push(new Number("3"));
        calculator.push(new Number("4"));
        calculator.pop();
        calculator.commit();
        undoCommand.execute(calculator);
        cut.execute(calculator);
        Assertions.assertEquals("1 2 3", calculator.printStack());
    }

    @Test
    public void testRedoTakesNoActionIfNoUndoneInstructions() {
        Calculator calculator = new Calculator();
        calculator.push(new Number("1"));
        calculator.push(new Number("2"));
        calculator.commit();
        cut.execute(calculator);
        Assertions.assertEquals("1 2", calculator.printStack());
    }

    @Test
    public void testConsecutiveRedos() {
        Calculator calculator = new Calculator();
        calculator.push(new Number("1"));
        calculator.push(new Number("2"));
        calculator.commit();
        calculator.push(new Number("3"));
        calculator.push(new Number("4"));
        calculator.pop();
        calculator.commit();
        undoCommand.execute(calculator);
        undoCommand.execute(calculator);
        cut.execute(calculator);
        cut.execute(calculator);
        Assertions.assertEquals("1 2 3", calculator.printStack());
    }

    @Test
    public void newInstructionsWipesUndoneInstructions() {
        Calculator calculator = new Calculator();
        calculator.push(new Number("1"));
        calculator.push(new Number("2"));
        calculator.commit();
        calculator.push(new Number("3"));
        calculator.push(new Number("4"));
        calculator.pop();
        calculator.commit();
        undoCommand.execute(calculator);
        calculator.push(new Number("5"));
        calculator.push(new Number("6"));
        calculator.pop();
        calculator.commit();
        cut.execute(calculator);
        Assertions.assertEquals("1 2 5", calculator.printStack());
    }

}