package calculator.model.shapes;

import calculator.model.Point;
import calculator.utils.PointUtils;

import java.util.List;
import java.util.Objects;

public class Line implements Shape {
    private final List<Point> points;

    private Line(final List<Point> points) {
        validate(points);
        this.points = points;
    }

    public static Line of(final List<Point> points) {
        return new Line(points);
    }

    private void validate(List<Point> points) {
        if (Objects.isNull(points) || points.size() != 2) {
            throw new IllegalArgumentException("line must have 2 points");
        }

        if (points.get(0).equals(points.get(1))) {
            throw new IllegalArgumentException("line must have 2 different points");
        }
    }

    @Override
    public double calculate() {
        Point point1 = points.get(0);
        Point point2 = points.get(1);

        return PointUtils.distance(point1, point2);
    }

}