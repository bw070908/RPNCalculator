package RPNCalculator.Commands;

import java.lang.reflect.Type;

public class CommandTestCase {
    private String description;
    private String initialStack;
    private String expectedStack;
    private Type expectedException;

    public CommandTestCase(String description, String initialStack, String expectedStack, Type expectedException) {
        this.description = description;
        this.initialStack = initialStack;
        this.expectedStack = expectedStack;
        this.expectedException = expectedException;
    }

    public String getDescription() {
        return description;
    }

    public String getInitialStack() {
        return initialStack;
    }

    public String getExpectedStack() {
        return expectedStack;
    }

    public Type getExpectedException() {
        return expectedException;
    }
}
