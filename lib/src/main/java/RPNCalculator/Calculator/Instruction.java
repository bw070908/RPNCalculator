package RPNCalculator.Calculator;

import java.util.Stack;

public class Instruction {
    private Stack<Number> poppedNumbers;
    private Stack<Number> pushedNumbers;

    public Instruction() {
        poppedNumbers = new Stack<Number>();
        pushedNumbers = new Stack<Number>();
    }

    public Stack<Number> getPoppedNumbers() {
        return this.poppedNumbers;
    }

    public Stack<Number> getPushedNumbers() {
        return this.pushedNumbers;
    }

    public void recordPop(Number n) {
        poppedNumbers.push(n);
    }

    public void recordPush(Number n) {
        pushedNumbers.push(n);
    }
}
