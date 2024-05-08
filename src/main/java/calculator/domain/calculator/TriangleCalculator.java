package calculator.domain.calculator;

import calculator.domain.point.Point;
import calculator.domain.point.PointCalculations;
import calculator.view.ResultView;

import java.util.List;
import java.util.Objects;

public class TriangleCalculator implements CoordinateCalculator {

    private final List<Point> points;

    private TriangleCalculator(final List<Point> points) {
        validate(points);
        this.points = points;
    }

    public static TriangleCalculator of(final List<Point> points) {
        return new TriangleCalculator(points);
    }

    private void validate(List<Point> points) {
        if (Objects.isNull(points) || points.size() != 3) {
            throw new IllegalArgumentException("triangle must have 3 points");
        }

        validateTriangle(points);
    }

    private void validateTriangle(final List<Point> points) {
        if (points.get(0).equals(points.get(1)) || points.get(0).equals(points.get(2)) || points.get(1).equals(points.get(2))) {
            throw new IllegalArgumentException("The provided points do not form a valid triangle.");
        }

        if (PointCalculations.isOnLine(points.get(0), points.get(1), points.get(2))) {
            throw new IllegalArgumentException("The provided points do not form a valid triangle.");
        }
    }

    @Override
    public double calculate() {
        // 헤론의 공식을 사용하여 삼각형의 넓이를 계산한다.
        double side1 = PointCalculations.distance(points.get(0), points.get(1));
        double side2 = PointCalculations.distance(points.get(1), points.get(2));
        double side3 = PointCalculations.distance(points.get(2), points.get(0));

        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public void printCalculateResult() {
        ResultView.printTriangleCalculateResult(calculate());
    }
}
