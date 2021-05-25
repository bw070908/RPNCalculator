package RPNCalculator.Commands;

import RPNCalculator.Calculator.Calculator;
import RPNCalculator.Calculator.Number;
import com.google.common.base.Splitter;
import org.junit.Assert;

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
        Assert.assertEquals(
                test.getDescription(),
                test.getExpectedStack(),
                calculator.printStack()
        );
        Assert.assertEquals(
                test.getDescription(),
                test.getExpectedException(),
                caught
        );
    }
}
