package calculator.utils;

import java.util.Arrays;
import java.util.List;

public class Splitter {
    private static final String STRING_DELIMITER = "-";

    private Splitter() {
    }

    public static List<String> split(final String value) {
        return Arrays.stream(value.split(STRING_DELIMITER)).toList();
    }
}