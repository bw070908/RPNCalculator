package RPNCalculator.Calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Number {

    public static final int DEFAULT_PRECISION = 15;
    public static final MathContext DEFAULT_MC = new MathContext(DEFAULT_PRECISION);

    private BigDecimal value;

    public Number(String n) {
        value = new BigDecimal(n);
        value.setScale(DEFAULT_PRECISION);
    }

    public Number(BigDecimal bd) {
        value = bd;
        bd.setScale(DEFAULT_PRECISION, RoundingMode.HALF_UP);
    }

    public BigDecimal getValue() {
        return value;
    }
}
