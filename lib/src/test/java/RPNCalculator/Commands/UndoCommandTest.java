package RPNCalculator.Commands;

import RPNCalculator.Calculator.Calculator;
import RPNCalculator.Calculator.Number;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UndoCommandTest {

    private UndoCommand cut = new UndoCommand();

    @Test
    public void testUndoRevertsRecentInstruction() {
        Calculator calculator = new Calculator();
        calculator.push(new Number("1"));
        calculator.push(new Number("2"));
        calculator.commit();
        calculator.push(new Number("3"));
        calculator.push(new Number("4"));
        calculator.pop();
        calculator.commit();
        cut.execute(calculator);
        Assertions.assertEquals("1 2", calculator.printStack());
    }

    @Test
    public void testUndoTakesNoActionIfNoPastInstructions() {
        Calculator calculator = new Calculator();
        cut.execute(calculator);
        Assertions.assertEquals("", calculator.printStack());
    }

    @Test
    public void testConsecutiveUndos() {
        Calculator calculator = new Calculator();
        calculator.push(new Number("1"));
        calculator.push(new Number("2"));
        calculator.commit();
        calculator.push(new Number("3"));
        calculator.push(new Number("4"));
        calculator.pop();
        calculator.commit();
        cut.execute(calculator);
        cut.execute(calculator);
        Assertions.assertEquals("", calculator.printStack());
    }

}