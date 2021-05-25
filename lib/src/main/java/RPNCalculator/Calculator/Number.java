package RPNCalculator.Calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Number {

    public static final int DEFAULT_SCALE = 15;
    public static final int DISPLAY_SCALE = 10;
    public static final RoundingMode DEFAULT_ROUNDING_MODE = RoundingMode.DOWN;
    public static final MathContext DEFAULT_MC =
            new MathContext(MathContext.DECIMAL128.getPrecision(), DEFAULT_ROUNDING_MODE);

    private BigDecimal value;

    public Number(String n) {
        value = new BigDecimal(n, DEFAULT_MC).setScale(DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
    }

    public Number(BigDecimal bd) {
        value = bd.setScale(DEFAULT_SCALE, DEFAULT_ROUNDING_MODE);
    }

    public BigDecimal getValue() {
        return value;
    }

    public String toPlainString() {
        return value.setScale(DISPLAY_SCALE, DEFAULT_ROUNDING_MODE)
                .stripTrailingZeros()
                .toPlainString();
    }
}
