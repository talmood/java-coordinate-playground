package calculator.domain.calculator;

import calculator.domain.point.Point;
import calculator.domain.point.PointCalculations;
import calculator.view.ResultView;

import java.util.List;
import java.util.Objects;

public class LineCalculator implements CoordinateCalculator {
    private final List<Point> points;

    private LineCalculator(final List<Point> points) {
        validate(points);
        this.points = points;
    }

    public static LineCalculator of(final List<Point> points) {
        return new LineCalculator(points);
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

        return PointCalculations.distance(point1, point2);
    }

    @Override
    public void printCalculateResult() {
        ResultView.printLineCalculateResult(calculate());
    }

}