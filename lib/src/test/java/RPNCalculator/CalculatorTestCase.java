package RPNCalculator;

import java.lang.reflect.Type;
import java.util.List;

public class CalculatorTestCase {
    private String description;
    private List<String> inputs;
    private String expectedStack;
    private Type expectedException;

    public CalculatorTestCase(String description, List<String> inputs, String expectedStack, Type expectedException) {
        this.description = description;
        this.inputs = inputs;
        this.expectedStack = expectedStack;
        this.expectedException = expectedException;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getInputs() {
        return inputs;
    }

    public String getExpectedStack() {
        return expectedStack;
    }

    public Type getExpectedException() {
        return expectedException;
    }
}
