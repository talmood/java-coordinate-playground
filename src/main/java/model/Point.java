package model;

public class Point {

    private static final int MAX_VALUE = 24;
    private static final int MIN_VALUE = 0;

    private final int x;
    private final int y;

    public Point(int x, int y) {
        validateValueRange(x, y);
        this.x = x;
        this.y = y;
    }

    private void validateValueRange(int x, int y) {
        if (!meetsValueRange(x) || !meetsValueRange(y)) {
            throw new IllegalArgumentException(
                    "X, Y 좌표의 범위는 최소 %d, 최대 %d입니다.".formatted(MIN_VALUE, MAX_VALUE)
            );
        }
    }

    private boolean meetsValueRange(int value) {
        return value >= MIN_VALUE && value <= MAX_VALUE;
    }

    public int calculateDistanceByX(Point other) {
        return Math.abs(this.x - other.x);
    }

    public int calculateDistanceByY(Point other) {
        return Math.abs(this.y - other.y);
    }

}
