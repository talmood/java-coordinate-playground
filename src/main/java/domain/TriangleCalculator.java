package domain;

import output.dto.CalculateOutput;
import output.dto.TriangleCalculateOutput;

public class TriangleCalculator implements PolygonCalculator {

    @Override
    public CalculateOutput calculate(Polygon polygon) {
        Triangle triangle = (Triangle) polygon;

        return new TriangleCalculateOutput(triangle.calculateArea());
    }
}
