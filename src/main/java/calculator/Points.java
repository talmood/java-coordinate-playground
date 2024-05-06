package calculator;

import calculator.model.Point;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Points {

    private static final int MIN_COORDINATE_COUNT = 2;
    private static final int MAX_COORDINATE_COUNT = 4;

    private final List<Point> points;

    private Points(final List<Point> points) {
        validate(points);
        this.points = points;
    }

    public static Points from(final List<Point> points) {
        return new Points(points);
    }

    private void validate(final List<Point> points) {
        validateSize(points);
        validateDuplicate(points);
    }

    private void validateSize(final List<Point> points) {
        if (Objects.isNull(points)) {
            throw new IllegalArgumentException(ErrorMessage.NULL_COORDINATES);
        }

        if (points.size() < MIN_COORDINATE_COUNT || points.size() > MAX_COORDINATE_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.COORDINATE_COUNT);
        }
    }

    private void validateDuplicate(final List<Point> points) {
        final Set<Point> set = new HashSet<>();
        for (final Point point : points) {
            if (set.contains(point)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_COORDINATES);
            }
            set.add(point);
        }
    }

    public List<Point> getPoints() {
        return List.copyOf(points);
    }
}