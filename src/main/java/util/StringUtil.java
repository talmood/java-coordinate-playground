package util;

import java.util.Objects;

public abstract class StringUtil {

    public static boolean isEmpty(String str) {
        return Objects.isNull(str) || str.isEmpty();
    }
}
