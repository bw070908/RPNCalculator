package RPNCalculator;

import com.google.common.base.Splitter;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    private static final char DELIMITER = ' ';

    public List<String> parseInput(String input) {
        return Splitter.on(DELIMITER).omitEmptyStrings().splitToList(input);
    }

    public List<Integer> getPositions(String input) {
        List<Integer> indices = new ArrayList<Integer>();
        char[] chars = input.toCharArray();
        boolean prevCharIsDelimiter = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != DELIMITER && prevCharIsDelimiter) {
                indices.add(i+1);
            }
            prevCharIsDelimiter = chars[i] == DELIMITER;
        }
        return indices;
    }
}
