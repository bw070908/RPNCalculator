package RPNCalculator;

import org.junit.Assert;

import java.lang.reflect.Type;

public class CalculatorTestRunner {

    public void runTest(RPNCalculator calculator, CalculatorTestCase test) {
        Type caught = null;
        try {
            test.getInputs().forEach(in -> calculator.process(in));
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
