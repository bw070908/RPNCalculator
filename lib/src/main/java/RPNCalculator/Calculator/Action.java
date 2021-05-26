package RPNCalculator.Calculator;

/**
 * An action is either a push or a pop applied to a stack.
 */
public class Action {

    enum ActionType
    {
        POP, PUSH;
    }

    private ActionType type;
    private Number value;

    /**
     * Returns a new action.
     * @param type The type of action: pop or push
     * @param value The number that was popped or pushed.
     */
    public Action(ActionType type, Number value) {
        this.type = type;
        this.value = value;
    }

    /**
     * Get whether the action was a push or a pop.
     * @return The action type.
     */
    public ActionType getType() {
        return type;
    }

    /**
     * Get the value that was popped/pushed.
     * @return The number that was popped/pushed.
     */
    public Number getValue() {
        return value;
    }
}
