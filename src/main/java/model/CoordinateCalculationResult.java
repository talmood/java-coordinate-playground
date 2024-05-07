package model;

public class CoordinateCalculationResult {

    private final double value;
    private final ResultType type;

    private CoordinateCalculationResult(double value, ResultType type) {
        this.value = value;
        this.type = type;
    }

    public static CoordinateCalculationResult fromDistance(double value) {
        return new CoordinateCalculationResult(value, ResultType.DISTANCE);
    }

    public static CoordinateCalculationResult fromTriangleArea(double area) {
        return new CoordinateCalculationResult(area, ResultType.TRIANGLE_AREA);
    }

    public double getValue() {
        return value;
    }

    public double getDistance() {
        if (!this.type.isDistance()) {
            throw new IllegalArgumentException("결과 타입이 길이가 아닙니다.");
        }
        return this.value;
    }

    public ResultType getType() {
        return type;
    }

    public enum ResultType {

        DISTANCE,
        AREA,
        TRIANGLE_AREA;

        public boolean isDistance() {
            return this == DISTANCE;
        }
    }

}
