package RPNCalculator.Calculator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * Instruction contains a sequence of actions (pops/pushes) done to the calculator's stack.
 * All actions within an instruction are undone/redone together.
 */
public class Instruction {

    private Deque<Action> actions;

    public Instruction() {
        this.actions = new ArrayDeque<Action>();
    }

    /**
     * Records the action of popping a number.
     * @param n The number that was popped.
     */
    public void recordPop(Number n) {
        actions.add(new Action(Action.ActionType.POP, n));
    }

    /**
     * Records the action of pushing a number.
     * @param n The number that was pushed.
     */
    public void recordPush(Number n) {
        actions.add(new Action(Action.ActionType.PUSH, n));
    }

    /**
     * Get all the actions. Useful for redo.
     * @return Iterator of actions.
     */
    public Iterator<Action> getActions() {
        return actions.iterator();
    }

    /**
     * Get all the actions in reverse order. Useful for undo.
     * @return Iterator of actions in reverse order.
     */
    public Iterator<Action> getActionsReversed() {
        return actions.descendingIterator();
    }

    /**
     * Check if the current instruction has no actions.
     * @return True if instruction has no actions.
     */
    public boolean isEmpty() {
        return actions.isEmpty();
    }
}
