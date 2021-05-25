package RPNCalculator.Calculator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Instruction {
    private Deque<Action> actions;

    public Instruction() {
        this.actions = new ArrayDeque<Action>();
    }

    public void recordPop(Number n) {
        actions.add(new Action(Action.ActionType.POP, n));
    }

    public void recordPush(Number n) {
        actions.add(new Action(Action.ActionType.PUSH, n));
    }

    public Iterator<Action> getActions() {
        return actions.iterator();
    }

    public Iterator<Action> getActionsReversed() {
        return actions.descendingIterator();
    }
}
