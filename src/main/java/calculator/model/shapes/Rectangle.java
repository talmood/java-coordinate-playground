package calculator.model.shapes;

import calculator.model.Point;
import calculator.utils.PointUtils;

import java.util.*;

public class Rectangle implements Shape {

    private final List<Point> points;

    private Rectangle(final List<Point> points) {
        final List<Point> sortedPoints = sortPoints(points);
        validate(sortedPoints);
        this.points = sortedPoints;
    }

    private List<Point> sortPoints(final List<Point> points) {
        List<Point> sortedPoints = new ArrayList<>(points);
        sortedPoints.sort(Comparator.comparing(Point::getX).thenComparing(Point::getY));
        return sortedPoints;
    }

    public static Rectangle of(final List<Point> points) {
        return new Rectangle(points);
    }

    private void validate(final List<Point> points) {

        if (Objects.isNull(points) || points.size() != 4) {
            throw new IllegalArgumentException("rectangle must have 4 points");
        }

        validateRectangle(points);
    }

    private void validateRectangle(List<Point> points) {
        validateDiagonals(points);
        validateSides(points);
    }

    private void validateDiagonals(List<Point> points) {
        double diagonal1 = PointUtils.distance(points.get(0), points.get(2));
        double diagonal2 = PointUtils.distance(points.get(1), points.get(3));

        if (diagonal1 != diagonal2) {
            throw new IllegalArgumentException("The provided points do not form a rectangle.");
        }
    }

    private void validateSides(List<Point> points) {
        double side1 = PointUtils.distance(points.get(0), points.get(1));
        double side2 = PointUtils.distance(points.get(1), points.get(2));
        double side3 = PointUtils.distance(points.get(2), points.get(3));
        double side4 = PointUtils.distance(points.get(3), points.get(0));

        if (side1 != side3 || side2 != side4) {
            throw new IllegalArgumentException("The provided points do not form a rectangle.");
        }
    }

    @Override
    public double calculate() {
        return calculateWidth() * calculateHeight();
    }

    private double calculateWidth() {
        return PointUtils.distance(points.get(0), points.get(1));
    }

    private double calculateHeight() {
        return PointUtils.distance(points.get(0), points.get(2));
    }
}
