package model.coordinatecalculation.strategy;

import model.CoordinateCalculationResult;
import model.coordinatecalculation.polygon.Triangle;

public class TriangleAreaCalculationStrategy implements CoordinateCalculationStrategy {

    private final Triangle triangle;

    public TriangleAreaCalculationStrategy(Triangle triangle) {
        this.triangle = triangle;
    }

    @Override
    public CoordinateCalculationResult calculate() {
        return CoordinateCalculationResult.fromTriangleArea(this.triangle.calculateArea());
    }

}
