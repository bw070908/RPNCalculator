package RPNCalculator.Calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Calculator {

    private Stack<Number> numbers;
    private Stack<Instruction> doneInstructions;
    private Stack<Instruction> undoneInstructions;
    private Instruction currentInstruction;

    public Calculator() {
        numbers = new Stack<Number>();
        doneInstructions = new Stack<Instruction>();
        undoneInstructions = new Stack<Instruction>();
    }

    public void beginInstruction() {
        this.currentInstruction = new Instruction();
    }

    public Number popNumber() {
        Number popped = numbers.pop();
        currentInstruction.recordPop(popped);
        return popped;
    }

    public void pushNumber (Number n) {
        numbers.push(n);
        currentInstruction.recordPush(n);
    }

    public void endInstruction() {
        doneInstructions.add(currentInstruction);
        currentInstruction = null;
        undoneInstructions.clear();
    }

    public void undo() {
        if (doneInstructions.empty()) {
            return;
        }
        Instruction instruction = doneInstructions.pop();
        // Pop all the originally pushed numbers
        for (int i = 0; i < instruction.getPushedNumbers().size(); i++) {
            numbers.pop();
        }
        // Push all the originally popped numbers in reverse order
        List<Number> poppedNumbers = new ArrayList<Number>(instruction.getPoppedNumbers());
        Collections.reverse(poppedNumbers);
        numbers.addAll(poppedNumbers);
        undoneInstructions.push(instruction);
    }

    public void redo() {
        if (undoneInstructions.empty()) {
            return;
        }
        Instruction instruction = undoneInstructions.pop();
        // Pop the originally popped numbers again
        for (int i = 0; i < instruction.getPoppedNumbers().size(); i++) {
            numbers.pop();
        }
        // Push all the originally pushed numbers again
        numbers.addAll(instruction.getPushedNumbers());
        undoneInstructions.push(instruction);
    }

    public int getStackDepth() {
        return numbers.size();
    }

    public String printStack() {
        List<String> printedNumbers = new ArrayList<String>();
        for(Number n : numbers) {
           printedNumbers.add(n.getValue().stripTrailingZeros().toPlainString());
        }
        return String.join(" ", printedNumbers);
    }
}
