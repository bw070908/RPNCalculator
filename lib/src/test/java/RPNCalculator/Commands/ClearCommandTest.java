package RPNCalculator.Commands;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class ClearCommandTest {

    private static final List<CommandTestCase> TESTS = List.of(
            new CommandTestCase(
                    "Clear should remove all numbers from stack when there are multiple numbers",
                    "2 3 4",
                    "",
                    null
            ),
            new CommandTestCase(
                    "Clear should remove number from stack when there is one number",
                    "2",
                    "",
                    null
            ),
            new CommandTestCase(
                    "Clear should maintain empty stack when stack is originally empty",
                    "",
                    "",
                    null
            )
    );

    private CommandTestRunner testRunner = new CommandTestRunner();
    private ClearCommand cut;

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testCommand(CommandTestCase test) {
        cut = new ClearCommand();
        testRunner.runTest(cut, test);
    }

    public static List<CommandTestCase> provideTestCases() {
        return TESTS;
    }

}