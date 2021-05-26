package RPNCalculator.Commands;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class SubtractionCommandTest {

    private static final List<CommandTestCase> TESTS = List.of(
            new CommandTestCase(
                    "Basic subtraction should return correct value",
                    "5 2",
                    "3",
                    null
            ),
            new CommandTestCase(
                    "Subtraction should throw exception when there are insufficient parameters",
                    "2",
                    "2",
                    CommandExecutionException.class
            ),
            new CommandTestCase(
                    "Subtraction should only affect top 2 elements on stack",
                    "1 3 2",
                    "1 1",
                    null
            ),
            new CommandTestCase(
                    "Subtraction should handle cases where output is negative",
                    "1 3",
                    "-2",
                    null
            ),
            new CommandTestCase(
                    "Subtraction should handle cases where input is negative",
                    "1 -3",
                    "4",
                    null
            ),
            new CommandTestCase(
                    "Subtraction should handle inputs with different precisions",
                    "100.23 45.00678",
                    "55.22322",
                    null
            )
    );

    private CommandTestRunner testRunner = new CommandTestRunner();
    private SubtractionCommand cut;

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testCommand(CommandTestCase test) {
        cut = new SubtractionCommand();
        testRunner.runTest(cut, test);
    }

    public static List<CommandTestCase> provideTestCases() {
        return TESTS;
    }

}