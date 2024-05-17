package model.polygon;

import model.CoordinateCalculationResult;
import model.DistinguishedCoordinates;
import model.Point;
import model.coordinatecalculation.strategy.PointsDistanceCalculationStrategy;

import java.util.List;

public class Triangle {

    private final DistinguishedCoordinates coordinates;

    public Triangle(DistinguishedCoordinates coordinates) {
        validateTriangle(coordinates);
        this.coordinates = coordinates;
    }

    public double calculateArea() {
        return applyHeronFormula(this.coordinates);
    }

    private void validateTriangle(DistinguishedCoordinates coordinates) {
        validateSize(coordinates);
    }

    private void validateSize(DistinguishedCoordinates coordinates) {
        if (!coordinates.matchesSize(3)) {
            throw new IllegalArgumentException("삼각형이 아닙니다.");
        }
        if (isAllPointsOnOneLine(coordinates)) { // todo 부동소수점 비교
            throw new IllegalArgumentException("삼각형이 아닙니다.");
        }
    }

    private boolean isAllPointsOnOneLine(DistinguishedCoordinates coordinates) {
        return applyHeronFormula(coordinates) == 0.0;
    }

    /**
     * 헤론의 공식을 구현한다.
     * <a href="https://ko.wikipedia.org/wiki/%ED%97%A4%EB%A1%A0_%EA%B3%B5%EC%8B%9D">헤론 공식</a>
     */
    private double applyHeronFormula(DistinguishedCoordinates coordinates) {
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
