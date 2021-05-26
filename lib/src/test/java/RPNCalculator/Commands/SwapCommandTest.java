package RPNCalculator.Commands;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class SwapCommandTest {

    private static final List<CommandTestCase> TESTS = List.of(
            new CommandTestCase(
                    "Swap should swap the top two numbers on stack",
                    "1 2 3 4 5",
                    "1 2 3 5 4",
                    null
            ),
            new CommandTestCase(
                    "Swap should swap both numbers if there are only 2 numbers",
                    "1 2",
                    "2 1",
                    null
            ),
            new CommandTestCase(
                    "Swap should throw exception if there are less than 2 numbers",
                    "1",
                    "1",
                    CommandExecutionException.class
            )
    );

    private CommandTestRunner testRunner = new CommandTestRunner();
    private SwapCommand cut;

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testCommand(CommandTestCase test) {
        cut = new SwapCommand();
        testRunner.runTest(cut, test);
    }

    public static List<CommandTestCase> provideTestCases() {
        return TESTS;
    }

}