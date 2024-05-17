package domain;

import output.dto.CalculateOutput;
import output.dto.SquareCalculateOutput;

public class SquareCalculator implements PolygonCalculator {

    @Override
    public CalculateOutput calculate(Polygon polygon) {
        Square square = (Square) polygon;

        return new SquareCalculateOutput(square.calculateArea());
    }
}
