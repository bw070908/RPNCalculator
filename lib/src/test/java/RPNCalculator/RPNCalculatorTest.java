package RPNCalculator;

import RPNCalculator.Exceptions.OperationException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class RPNCalculatorTest {

    private static final List<CalculatorTestCase> TESTS = List.of(
            new CalculatorTestCase(
                    "Basic numeric inputs",
                    List.of("5 2"),
                    "5 2",
                    null
            ),
            new CalculatorTestCase(
                    "Basic unary operation",
                    List.of("2 sqrt"),
                    "1.4142135623",
                    null
            ),
            new CalculatorTestCase(
                    "Clear operation followed by further inputs",
                    List.of("2 sqrt", "clear 9 sqrt"),
                    "3",
                    null
            ),
            new CalculatorTestCase(
                    "Clear operation results in empty stack",
                    List.of("5 2 -", "3 -", "clear"),
                    "",
                    null
            ),
            new CalculatorTestCase(
                    "Undos undo previous numbers",
                    List.of("5 4 3 2", "undo undo *"),
                    "20",
                    null
            ),
            new CalculatorTestCase(
                    "Undos undo previous numbers and operations",
                    List.of("5 4 3 2", "undo undo *", "5 *", "undo"),
                    "20 5",
                    null
            ),
            new CalculatorTestCase(
                    "Basic binary operations (*/)",
                    List.of("7 12 2 /", "*", "4 /"),
                    "10.5",
                    null
            ),
            new CalculatorTestCase(
                    "Negative outputs",
                    List.of("1 2 3 4 5", "*", "clear 3 4 -"),
                    "-1",
                    null
            ),
            new CalculatorTestCase(
                    "Consecutive operations",
                    List.of("1 2 3 4 5", "* * * *"),
                    "120",
                    null
            ),
            new CalculatorTestCase(
                    "Calculator throws OperationException when calculator has insufficient parameters",
                    List.of("1 2 3 * 5 + * * 6 5"),
                    "11",
                    OperationException.class
            )
    );

    CalculatorTestRunner testRunner = new CalculatorTestRunner();
    RPNCalculator cut;

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testRPNCalculator(CalculatorTestCase test) {
        cut = new RPNCalculator();
        testRunner.runTest(cut, test);
    }

    public static List<CalculatorTestCase> provideTestCases() {
        return TESTS;
    }
}
