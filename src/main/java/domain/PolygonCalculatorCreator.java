package domain;

public abstract class PolygonCalculatorCreator {

    public static PolygonCalculator create(Polygon polygon) {
        if (polygon instanceof Line) {
            return new LineCalculator();
        }

        if (polygon instanceof Triangle) {
            return new TriangleCalculator();
        }

        if (polygon instanceof SquareCalculator) {
            return new SquareCalculator();
        }

        throw new IllegalArgumentException("[ERROR] 도형에 맞는 계산기가 없습니다.");
    }
}
