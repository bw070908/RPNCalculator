package RPNCalculator.Calculator;

public class Action {

    enum ActionType
    {
        POP, PUSH;
    }

    private ActionType type;
    private Number value;

    public Action(ActionType type, Number value) {
        this.type = type;
        this.value = value;
    }

    public ActionType getType() {
        return type;
    }

    public Number getValue() {
        return value;
    }
}
