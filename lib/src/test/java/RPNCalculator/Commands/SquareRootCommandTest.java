package RPNCalculator.Commands;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class SquareRootCommandTest {

    private static final List<CommandTestCase> TESTS = List.of(
            new CommandTestCase(
                    "Square root should return correct values for perfect squares",
                    "4",
                    "2",
                    null
            ),
            new CommandTestCase(
                    "Square root should return rounded results for other integers",
                    "2",
                    "1.4142135623",
                    null
            ),
            new CommandTestCase(
                    "Square root should return correct values for perfect square decimals",
                    "1.21",
                    "1.1",
                    null
            ),
            new CommandTestCase(
                    "Square root should return correct values for other decimals",
                    "1.8",
                    "1.3416407864",
                    null
            ),
            new CommandTestCase(
                    "Square root should return 1 for input 1",
                    "1",
                    "1",
                    null
            ),
            new CommandTestCase(
                    "Square root should return 0 for input 0",
                    "0",
                    "0",
                    null
            ),
            new CommandTestCase(
                    "Square root should throw exception if input is negative",
                    "-3",
                    "-3",
                    CommandExecutionException.class
            )
    );

    private CommandTestRunner testRunner = new CommandTestRunner();
    private SquareRootCommand cut;

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testCommand(CommandTestCase test) {
        cut = new SquareRootCommand();
        testRunner.runTest(cut, test);
    }

    public static List<CommandTestCase> provideTestCases() {
        return TESTS;
    }

}