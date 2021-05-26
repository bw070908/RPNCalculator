package RPNCalculator;

import org.junit.jupiter.api.Assertions;

import java.lang.reflect.Type;

public class CalculatorTestRunner {

    public void runTest(RPNCalculator calculator, CalculatorTestCase test) {
        Type caught = null;
        try {
            test.getInputs().forEach(in -> calculator.process(in));
        } catch (Exception e) {
            caught = e.getClass();
        }
        Assertions.assertEquals(
                test.getExpectedException(),
                caught,
                test.getDescription()
        );
        Assertions.assertEquals(
                test.getExpectedStack(),
                calculator.printStack(),
                test.getDescription()
        );
    }
}
