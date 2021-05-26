package RPNCalculator.Calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Number is the base representation of numeric values for RPNCalculator.
 * It is a wrapper around BigDecimal that enforces precision, scale, and rounding modes.
 */
public class Number {

    public static final int DEFAULT_SCALE = 15;
    public static final int DISPLAY_SCALE = 10;
    public static final RoundingMode DEFAULT_ROUNDING_MODE = RoundingMode.DOWN;
    public static final MathContext DEFAULT_MC =
            new MathContext(MathContext.DECIMAL128.getPrecision(), DEFAULT_ROUNDING_MODE);

    private BigDecimal value;

    /**
     * Returns new Number based on input string.
     * @param n String representation of a number.
     */
    public Number(String n) {
        value = new BigDecimal(n, DEFAULT_MC).setScale(DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
    }

    /**
     * Returns a new Number based on an input BigDecimal.
     * @param bd BigDecimal representation of a number.
     */
    public Number(BigDecimal bd) {
        value = bd.setScale(DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
    }

    /**
     * Returns a copy of the BigDecimal representation of the number.
     * @return BigDecimal representation of the number
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * Returns plain string representation of the number.
     * @return Plain string representation of the number.
     */
    public String toPlainString() {
        return value.setScale(DISPLAY_SCALE, DEFAULT_ROUNDING_MODE)
                .stripTrailingZeros()
                .toPlainString();
    }
}
