package domain;

import java.util.Objects;

public class Coordinate {

    private static final int MIN_COORDINATE_RANGE = 0;
    private static final int MAX_COORDINATE_RANGE = 24;

    private final int xCoordinate;

    private final int yCoordinate;

    private Coordinate(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public static Coordinate create(int xCoordinate, int yCoordinate) {
        validateRange(xCoordinate, yCoordinate);

        return new Coordinate(xCoordinate, yCoordinate);
    }

    private static void validateRange(int xCoordinate, int yCoordinate) {
        if (!isRange(xCoordinate, yCoordinate)) {
            throw new IllegalArgumentException(
                    String.format(
                            "[ERROR] X, Y 좌표의 범위는 최소 %d, 최대 %d입니다.",
                            MIN_COORDINATE_RANGE,
                            MAX_COORDINATE_RANGE
                    )
            );
        }
    }

    private static boolean isRange(int xCoordinate, int yCoordinate) {
        return isRangeNumber(xCoordinate) && isRangeNumber(yCoordinate);
    }

    private static boolean isRangeNumber(int number) {
        return number >= MIN_COORDINATE_RANGE && number <= MAX_COORDINATE_RANGE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return xCoordinate == that.xCoordinate && yCoordinate == that.yCoordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }
}
