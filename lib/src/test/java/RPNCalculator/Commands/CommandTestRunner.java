package RPNCalculator.Commands;

import RPNCalculator.Calculator.Calculator;
import RPNCalculator.Calculator.Number;
import com.google.common.base.Splitter;
import org.junit.jupiter.api.Assertions;

import java.lang.reflect.Type;
import java.util.List;

public class CommandTestRunner {

    public void runTest(Command command, CommandTestCase test) {
        Calculator calculator = new Calculator();
        List<String> inputNumbers = Splitter.on(" ")
                .omitEmptyStrings()
                .splitToList(test.getInitialStack());
        inputNumbers.forEach(s -> calculator.push(new Number(s)));
        calculator.commit();

        Type caught = null;
        try {
            command.execute(calculator);
        } catch (Exception e) {
            caught = e.getClass();
        }
        Assertions.assertEquals(
                test.getExpectedStack(),
                calculator.printStack(),
                test.getDescription()
        );
        Assertions.assertEquals(
                test.getExpectedException(),
                caught,
                test.getDescription()
        );
    }
}
