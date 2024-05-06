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

    public double getValue() {
        return value;
    }

    public ResultType getType() {
        return type;
    }

    public enum ResultType {

        DISTANCE,
        AREA,
        ;

    }

}
