package calculator.domain.point;

import java.util.Objects;

public class Point {

    private final int x;
    private final int y;

    private Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public static Point of(final int x, final int y) {
        PointValidator.validate(x, y);
        return new Point(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}