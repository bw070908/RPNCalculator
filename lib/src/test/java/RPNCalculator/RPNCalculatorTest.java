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
            ),
            new CalculatorTestCase(
                    "Calculator can handle wide range of numeric inputs",
                    List.of("2 2.5 2.500 .54 0.54 0.5400 00.5400 -2 -2.5 -.54 0 0.0 0.00 .00 -0 -0.0"),
                    "2 2.5 2.5 0.54 0.54 0.54 0.54 -2 -2.5 -0.54 0 0 0 0 0 0",
                    null
            ),
            new CalculatorTestCase(
                    "Calculator can handle numeric inputs with high precision and round when necessary",
                    List.of("0.01234567 0.0123456789012 0.01234567890123456789"),
                    "0.01234567 0.0123456789 0.0123456789",
                    null
            ),
            new CalculatorTestCase(
                    "Calculator truncates trailing zeros after the decimal for display",
                    List.of("1000 1000.1 1000.1000000"),
                    "1000 1000.1 1000.1",
                    null
            ),
            new CalculatorTestCase(
                    "Calculator can store numbers to a higher precision than displayed",
                    List.of("0.100000000011 0.100000000011 1000 *"),
                    "0.1 100.000000011",
                    null
            ),
            new CalculatorTestCase(
                    "Calculator redo can restore undone commands",
                    List.of("1 2 3 4", "* * *", "undo undo undo", "redo redo"),
                    "1 24",
                    null
            ),
            new CalculatorTestCase(
                    "Calculator swap switches the top 2 numbers",
                    List.of("1 2 3 4", "swap swap swap"),
                    "1 2 4 3",
                    null
            ),
            new CalculatorTestCase(
                    "Calculator throws OperationException if divide by 0",
                    List.of("1 2 3 4", "0 * /"),
                    "1 2 3 0",
                    OperationException.class
            ),
            new CalculatorTestCase(
                    "Calculator throws OperationException if sqrt of negative number",
                    List.of("1 2 3 81", "-1 * sqrt"),
                    "1 2 3 -81",
                    OperationException.class
            ),
            new CalculatorTestCase(
                    "Calculator clear emties the stack",
                    List.of("1 2 3 81", "-1 *", "clear"),
                    "",
                    null
            ),
            new CalculatorTestCase(
                    "How about a fun test with everything in it :)",
                    List.of("1 2 3 4 5", "+ - * /", " -1 * sqrt 123.45 *", "undo undo", "redo", "swap", "clear"),
                    "",
                    null
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
