package RPNCalculator.Calculator;

import java.util.*;
import java.util.stream.Collectors;

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
            undoneInstructions.clear();
        }
        currentInstruction = new Instruction();
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

    public int size() {
        return numbers.size();
    }

    public String printStack() {
        return String.join(
                " ",
                numbers.stream().map(n -> n.toPlainString()).collect(Collectors.toList())
        );
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
