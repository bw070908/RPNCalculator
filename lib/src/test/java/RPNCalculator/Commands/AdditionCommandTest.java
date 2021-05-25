package RPNCalculator.Commands;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class AdditionCommandTest {

    private static final List<CommandTestCase> TESTS = List.of(
            new CommandTestCase(
                    "Basic addition should return correct value",
                    "2 3",
                    "5",
                    null
            ),
            new CommandTestCase(
                    "Addition should throw exception when there are insufficient parameters",
                    "2",
                    "2",
                    CommandExecutionException.class
            ),
            new CommandTestCase(
                    "Addition should only affect top 2 elements on stack",
                    "1 2 3",
                    "1 5",
                    null
            )
    );

    private CommandTestRunner testRunner = new CommandTestRunner();
    private AdditionCommand cut;

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testCommand(CommandTestCase test) {
        cut = new AdditionCommand();
        testRunner.runTest(cut, test);
    }

    public static List<CommandTestCase> provideTestCases() {
        return TESTS;
    }
}