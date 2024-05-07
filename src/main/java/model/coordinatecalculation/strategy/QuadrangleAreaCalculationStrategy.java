package model.coordinatecalculation.strategy;

import model.CoordinateCalculationResult;
import model.polygon.Rectangle;

public class QuadrangleAreaCalculationStrategy implements CoordinateCalculationStrategy {

    private final Rectangle rectangle;

    public QuadrangleAreaCalculationStrategy(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public CoordinateCalculationResult calculate() {
        return CoordinateCalculationResult.fromQuadrangleArea(this.rectangle.calculateArea());
    }

}
