package RPNCalculator.Calculator;

import java.util.*;

public class Calculator {

    private Stack<Number> numbers;
    private Stack<Instruction> doneInstructions;
    private Stack<Instruction> undoneInstructions;
    private Instruction currentInstruction;

    public Calculator() {
        numbers = new Stack<Number>();
        doneInstructions = new Stack<Instruction>();
        undoneInstructions = new Stack<Instruction>();
        currentInstruction = new Instruction();
    }

    public Number pop() {
        Number popped = numbers.pop();
        currentInstruction.recordPop(popped);
        return popped;
    }

    public void push(Number n) {
        numbers.push(n);
        currentInstruction.recordPush(n);
    }

    public void commit() {
        if (!currentInstruction.isEmpty()) {
            doneInstructions.add(currentInstruction);
        }
        currentInstruction = new Instruction();
        undoneInstructions.clear();
    }

    public void cancel() {
        undoInstruction(currentInstruction);
        currentInstruction = new Instruction();
    }

    public void undo() {
        if (doneInstructions.empty()) {
            return;
        }
        Instruction instruction = doneInstructions.pop();
        undoInstruction(instruction);
        undoneInstructions.push(instruction);
    }

    public void redo() {
        if (undoneInstructions.empty()) {
            return;
        }
        Instruction instruction = undoneInstructions.pop();
        redoInstruction(instruction);
        doneInstructions.push(instruction);
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

    private void undoInstruction(Instruction instruction) {
        Iterator<Action> actions = instruction.getActionsReversed();
        while (actions.hasNext()) {
            Action action = actions.next();
            if (action.getType() == Action.ActionType.POP) {
                numbers.push(action.getValue());
            } else {
                numbers.pop();
            }
        }
    }

    private void redoInstruction(Instruction instruction) {
        Iterator<Action> actions = instruction.getActions();
        while (actions.hasNext()) {
            Action action = actions.next();
            if (action.getType() == Action.ActionType.POP) {
                numbers.pop();
            } else {
                numbers.push(action.getValue());
            }
        }
    }
}
