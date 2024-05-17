package calculator.domain.point;

import calculator.utils.ErrorMessage;

public class PointValidator {
    private static final int MIN_POINT = 0;
    private static final int MAX_POINT = 24;

    private PointValidator() {
    }

    static void validate(int x, int y) {
        validatePointRange(x);
        validatePointRange(y);
    }

    private static void validatePointRange(final int value) {
        if (value < MIN_POINT || value > MAX_POINT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_POINT_RANGE);
        }
    }
}