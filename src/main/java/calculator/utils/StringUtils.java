package calculator.utils;

import java.util.Objects;

public class StringUtils {

    private StringUtils() {}

    public static boolean hasText(final String value) {
        return Objects.nonNull(value) && !value.isEmpty();
    }

    public static boolean isEmpty(final String value) {
        return Objects.isNull(value) || value.isEmpty();
    }

}