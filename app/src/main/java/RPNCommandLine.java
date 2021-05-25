import RPNCalculator.Exceptions.InvalidInputException;
import RPNCalculator.Exceptions.OperationException;
import RPNCalculator.RPNCalculator;

import java.util.Scanner;

public class RPNCommandLine {
    public static void main(String[] args) {
        RPNCalculator calculator = new RPNCalculator();
        Scanner inputScanner = new Scanner(System.in);
        String input;
        while ((input = inputScanner.nextLine()) != null) {
            try {
                calculator.process(input);
            } catch (OperationException e) {
                printOperationException(e);
            } catch (InvalidInputException e) {
                printInvalidInputException(e);
            }
            printCalculatorStack(calculator);
        }
    }

    private static void printCalculatorStack(RPNCalculator calculator) {
        System.out.println("Stack: " + calculator.printStack());
    }

    private static void printOperationException(OperationException e) {
        String displayMessage = String.format(
                "operation %s (position: %d): %s",
                e.getOperationSymbol(),
                e.getPosition(),
                e.getMessage()
        );
        System.out.println(displayMessage);
    }

    private static void printInvalidInputException(InvalidInputException e) {
        String displayMessage = String.format(
                "invalid input [%s]: %s",
                e.getOffendingInput(),
                e.getMessage()
        );
        System.out.println(displayMessage);
    }

}
