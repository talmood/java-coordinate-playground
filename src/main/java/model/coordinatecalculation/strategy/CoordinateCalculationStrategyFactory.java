package model.coordinatecalculation.strategy;

import model.DistinguishedCoordinates;
import model.polygon.Rectangle;
import model.polygon.Triangle;

public class CoordinateCalculationStrategyFactory {

    private static final CoordinateCalculationStrategyFactory INSTANCE = new CoordinateCalculationStrategyFactory();

    private CoordinateCalculationStrategyFactory() {
    }

    public static CoordinateCalculationStrategyFactory getInstance() {
        return INSTANCE;
    }

    public CoordinateCalculationStrategy create(DistinguishedCoordinates coordinates) {
        switch (coordinates.size()) { // todo enum strategy 적용
            case 2 -> {
                return new PointsDistanceCalculationStrategy(coordinates);
            }
            case 3 -> {
                return new TriangleAreaCalculationStrategy(new Triangle(coordinates));
            }
            case 4 -> {
                return new QuadrangleAreaCalculationStrategy(new Rectangle(coordinates));
            }
            default -> throw new IllegalArgumentException("좌표 개수는 2이상 4이하여야 합니다.");
        }
    }

}
