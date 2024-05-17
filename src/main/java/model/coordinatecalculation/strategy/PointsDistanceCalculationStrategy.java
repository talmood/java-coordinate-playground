package model.coordinatecalculation.strategy;

import model.CoordinateCalculationResult;
import model.DistinguishedCoordinates;
import model.Point;

import java.util.List;

import static utils.MathUtils.square;

public class PointsDistanceCalculationStrategy implements CoordinateCalculationStrategy {

    private final DistinguishedCoordinates coordinates;

    public PointsDistanceCalculationStrategy(DistinguishedCoordinates coordinates) {
        validateCoordinateSize(coordinates);
        this.coordinates = coordinates;
    }

    private void validateCoordinateSize(DistinguishedCoordinates coordinates) {
        if (!coordinates.matchesSize(2)) {
            throw new IllegalArgumentException("두 점 사이의 계산을 위한 좌표 계수는 2개이어야 합니다.");
        }
    }

    @Override
    public CoordinateCalculationResult calculate() {
        final List<Point> points = this.coordinates.getPoints();

        final Point first = points.get(0);
        final Point second = points.get(1);

        return CoordinateCalculationResult.fromDistance(calculateDistance(first, second));
    }

    private double calculateDistance(Point first, Point second) {
        return Math.sqrt(square(first.calculateDistanceByX(second)) + square(first.calculateDistanceByY(second)));
    }

}
