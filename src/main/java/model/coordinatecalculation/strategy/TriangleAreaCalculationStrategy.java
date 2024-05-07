package model.coordinatecalculation.strategy;

import model.CoordinateCalculationResult;
import model.DistinguishedCoordinates;
import model.Point;

import java.util.List;

public class TriangleAreaCalculationStrategy implements CoordinateCalculationStrategy {

    private final DistinguishedCoordinates coordinates;

    public TriangleAreaCalculationStrategy(DistinguishedCoordinates coordinates) {
        if (!coordinates.matchesSize(4)) {
            throw new IllegalArgumentException("사각형 넓이 계산을 위한 좌표 계수는 4개이어야 합니다.");
        }
        this.coordinates = coordinates;
    }

    public DistinguishedCoordinates getCoordinates() {
        return this.coordinates;
    }

    @Override
    public CoordinateCalculationResult calculate() {
        return CoordinateCalculationResult.fromTriangleArea(applyHeronFormula());
    }

    /**
     * 헤론의 공식을 구현한다.
     * <a href="https://ko.wikipedia.org/wiki/%ED%97%A4%EB%A1%A0_%EA%B3%B5%EC%8B%9D">헤론 공식</a>
     */
    private double applyHeronFormula() {
        // 꼭짓점
        final Point first = coordinates.fetchPointByIndex(0);
        final Point second = coordinates.fetchPointByIndex(1);
        final Point third = coordinates.fetchPointByIndex(2);

        // 삼각형 빗변의 길이
        final double a = calculateSideLength(first, second);
        final double b = calculateSideLength(second, third);
        final double c = calculateSideLength(third, first);

        final double s = (a + b + c) / 2.0;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    private double calculateSideLength(Point first, Point second) {
        final CoordinateCalculationResult calculationResult =
                new PointsDistanceCalculationStrategy(new DistinguishedCoordinates(List.of(first, second))).calculate();

        return calculationResult.getDistance();
    }

}
