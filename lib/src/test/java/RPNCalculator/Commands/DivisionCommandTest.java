package RPNCalculator.Commands;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

class DivisionCommandTest {

    private static final List<CommandTestCase> TESTS = List.of(
            new CommandTestCase(
                    "Basic division should return correct value",
                    "4 2",
                    "2",
                    null
            ),
            new CommandTestCase(
                    "Division should return correct result when result is a fraction",
                    "2 4",
                    "0.5",
                    null
            ),
            new CommandTestCase(
                    "Division should return correct result when result is a repeating decimal",
                    "4 3",
                    "1.3333333333",
                    null
            ),
            new CommandTestCase(
                    "Division should be able to handle small outputs",
                    "1 2000000000",
                    "0.0000000005",
                    null
            ),
            new CommandTestCase(
                    "Division should be able to handle outputs smaller than display scale",
                    "1 200000000000",
                    "0",
                    null
            ),
            new CommandTestCase(
                    "Division should be able to handle outputs smaller than storage scale",
                    "1 200000000000000000000",
                    "0",
                    null
            ),
            new CommandTestCase(
                    "Division should be able to handle large outputs",
                    "1 0.0000000005",
                    "2000000000",
                    null
            ),
            new CommandTestCase(
                    "Division should be able to handle inputs with mismatched precisions",
                    "146.8944 12.12",
                    "12.12",
                    null
            ),
            new CommandTestCase(
                    "Division should be able to handle inputs with negative values",
                    "146.8944 -12.12",
                    "-12.12",
                    null
            ),
            new CommandTestCase(
                    "Division should throw exception when divisor is 0",
                    "1866455.18546 0",
                    "1866455.18546 0",
                    CommandExecutionException.class
            ),
            new CommandTestCase(
                    "Division should throw exception when there are less 2 parameters",
                    "2",
                    "2",
                    CommandExecutionException.class
            )
    );

    private CommandTestRunner testRunner = new CommandTestRunner();
    private DivisionCommand cut;

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testCommand(CommandTestCase test) {
        cut = new DivisionCommand();
        testRunner.runTest(cut, test);
    }

    public static List<CommandTestCase> provideTestCases() {
        return TESTS;
    }

}