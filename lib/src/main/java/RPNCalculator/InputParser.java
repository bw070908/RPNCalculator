package RPNCalculator;

import com.google.common.base.Splitter;

import java.util.ArrayList;
import java.util.List;

/**
 * InputParser contains utility methods to parse user inputted lines.
 */
class InputParser {

    private static final char DELIMITER = ' ';

    /**
     * Parse input line into individual tokens.
     * @param input Input line.
     * @return List of individual tokens.
     */
    public List<String> parseInput(String input) {
        return Splitter.on(DELIMITER).omitEmptyStrings().splitToList(input);
    }

    /**
     * Returns the positions of individual tokens in an input line.
     * These tokens can be used to return error messages to users.
     * @param input Input line.
     * @return List of indices of tokens' positions in the input line.
     */
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
