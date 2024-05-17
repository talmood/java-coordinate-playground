package calculator.utils;

import java.util.Arrays;
import java.util.List;

public class DashSplitter {
    private static final String STRING_DELIMITER = "-";

    private DashSplitter() {
    }

    public static List<String> split(final String value) {
        return Arrays.stream(value.split(STRING_DELIMITER)).toList();
    }
}