package RPNCalculator.Commands;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class MultiplicationCommandTest {

    private static final List<CommandTestCase> TESTS = List.of(
            new CommandTestCase(
                    "Basic multiplication should return correct value",
                    "3 2",
                    "6",
                    null
            ),
            new CommandTestCase(
                    "Multiplication should return correct result when result is a fraction",
                    "2 .4",
                    "0.8",
                    null
            ),
            new CommandTestCase(
                    "Division should be able to handle small outputs",
                    "0.003 0.0002",
                    "0.0000006",
                    null
            ),
            new CommandTestCase(
                    "Division should be able to handle outputs smaller than display scale",
                    "0.003 0.0000000002",
                    "0",
                    null
            ),
            new CommandTestCase(
                    "Division should be able to handle outputs smaller than storage scale",
                    "0.003 0.0000000000000002",
                    "0",
                    null
            ),
            new CommandTestCase(
                    "Division should be able to handle large outputs",
                    "300 2000000000",
                    "600000000000",
                    null
            ),
            new CommandTestCase(
                    "Division should be able to handle inputs with mismatched precisions",
                    "146.8944 12.12",
                    "1780.360128",
                    null
            ),
            new CommandTestCase(
                    "Multiplication should be able to handle negative parameters",
                    "3 -2.0400",
                    "-6.12",
                    null
            ),
            new CommandTestCase(
                    "Division should throw exception when there are less 2 parameters",
                    "2",
                    "2",
                    CommandExecutionException.class
            )
    );

    private CommandTestRunner testRunner = new CommandTestRunner();
    private MultiplicationCommand cut;

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testCommand(CommandTestCase test) {
        cut = new MultiplicationCommand();
        testRunner.runTest(cut, test);
    }

    public static List<CommandTestCase> provideTestCases() {
        return TESTS;
    }

}