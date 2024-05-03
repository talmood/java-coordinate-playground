package util;

import java.util.Objects;
import java.util.regex.Pattern;

public abstract class PatternUtil {

    public static boolean isMatches(String regex, String str) {
        if (Objects.isNull(str)) {
            return false;
        }

        return Pattern.matches(regex, str);
    }
}
