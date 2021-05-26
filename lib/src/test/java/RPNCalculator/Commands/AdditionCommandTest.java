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
            ),
            new CommandTestCase(
                    "Addition should handle cases where input is negative",
                    "5 -3",
                    "2",
                    null
            ),
            new CommandTestCase(
                    "Addition should handle cases where output is negative",
                    "-5 3",
                    "-2",
                    null
            ),
            new CommandTestCase(
                    "Subtraction should handle inputs with different precisions",
                    "100.23 45.00678",
                    "145.23678",
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