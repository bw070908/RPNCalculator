package RPNCalculator.Calculator;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Calculator class encapsulates all the stateful components of RPNCalculator.
 * It maintains a stack of numbers, and records all pops/pushes to the stack.
 * Pop/pushes to the stack are tracked through Instructions, which can be undone/redone.
 */
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

    /**
     * Pop number from top of the stack.
     * This action is recorded for undo/redo.
     * @return Number popped from stack.
     */
    public Number pop() {
        Number popped = numbers.pop();
        currentInstruction.recordPop(popped);
        return popped;
    }

    /**
     * Push number onto the stack.
     * This action is recorded for undo/redo.
     * @param n Number to push.
     */
    public void push(Number n) {
        numbers.push(n);
        currentInstruction.recordPush(n);
    }

    /**
     * Commit saves all the pops/pushes into an Instruction.
     * Instructions can be undone/redone.
     * New instructions resets the redone stack, as it starts a new history chain.
     */
    public void commit() {
        if (!currentInstruction.isEmpty()) {
            doneInstructions.add(currentInstruction);
            undoneInstructions.clear();
        }
        currentInstruction = new Instruction();
    }

    /**
     * Revert all the pop/pushes from the previous commit.
     */
    public void cancel() {
        undoInstruction(currentInstruction);
        currentInstruction = new Instruction();
    }

    /**
     * Undo previous instruction.
     * No action if there are no instructions to undo.
     */
    public void undo() {
        if (doneInstructions.empty()) {
            return;
        }
        Instruction instruction = doneInstructions.pop();
        undoInstruction(instruction);
        undoneInstructions.push(instruction);
    }

    /**
     * Redo previous undone instruction.
     * No action if there are no instructions to redo.
     */
    public void redo() {
        if (undoneInstructions.empty()) {
            return;
        }
        Instruction instruction = undoneInstructions.pop();
        redoInstruction(instruction);
        doneInstructions.push(instruction);
    }

    /**
     * Returns current size of the stack.
     * @return Size of stack.
     */
    public int size() {
        return numbers.size();
    }

    /**
     * Returns plain string representation of the current stack.
     * @return Plain string representation of the current stack
     */
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
