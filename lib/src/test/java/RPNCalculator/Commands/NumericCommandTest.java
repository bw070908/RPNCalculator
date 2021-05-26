package RPNCalculator.Commands;

import RPNCalculator.Calculator.Number;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class NumericCommandTest {

    private static final String TEST_NUMBER = "2.2";

    private static final List<CommandTestCase> TESTS = List.of(
            new CommandTestCase(
                    "Numeric command should push number to top of stack",
                    "2 3",
                    "2 3 " + TEST_NUMBER,
                    null
            ),
            new CommandTestCase(
                    "Numeric command should push number to top of stack when there is one number",
                    "2",
                    "2 " + TEST_NUMBER,
                    null
            ),
            new CommandTestCase(
                    "Numeric command should push number to top of stack when stack is originally empty",
                    "",
                    TEST_NUMBER,
                    null
            )
    );

    private CommandTestRunner testRunner = new CommandTestRunner();
    private NumericCommand cut;

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testCommand(CommandTestCase test) {
        cut = new NumericCommand(new Number(TEST_NUMBER));
        testRunner.runTest(cut, test);
    }

    public static List<CommandTestCase> provideTestCases() {
        return TESTS;
    }

}