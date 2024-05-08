package calculator.domain.point;

import calculator.utils.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Points {

    private static final int MIN_COORDINATE_COUNT = 2;
    private static final int MAX_COORDINATE_COUNT = 4;

    private final List<Point> points;

    private Points(final List<Point> points) {
        this.points = points;
    }

    public static Points from(final List<Point> points) {
        validate(points);
        return new Points(points);
    }

    private static void validate(final List<Point> points) {
        validateCount(points);
        validateDuplicate(points);
    }

    private static void validateCount(final List<Point> points) {
        if (Objects.isNull(points)) {
            throw new IllegalArgumentException(ErrorMessage.NULL_POINT);
        }

        if (points.size() < MIN_COORDINATE_COUNT || points.size() > MAX_COORDINATE_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_POINT_COUNT);
        }
    }

    private static void validateDuplicate(final List<Point> points) {
        final Set<Point> set = new HashSet<>();
        for (final Point point : points) {
            if (set.contains(point)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATED_POINT);
            }
            set.add(point);
        }
    }

    public List<Point> getPoints() {
        return List.copyOf(points);
    }
}