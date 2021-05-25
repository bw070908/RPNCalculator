import RPNCalculator.RPNCalculator;

import java.util.Scanner;

public class RPNCommandLine {
    public static void main(String[] args) {
        RPNCalculator calculator = new RPNCalculator();
        Scanner inputScanner = new Scanner(System.in);
        String input;
        while ((input = inputScanner.nextLine()) != null) {
            calculator.process(input);
            System.out.println(calculator.printStack());
        }
    }
}
