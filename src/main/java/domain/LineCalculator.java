package domain;

import output.dto.CalculateOutput;
import output.dto.LineCalculateOutput;

public class LineCalculator implements PolygonCalculator {


    @Override
    public CalculateOutput calculate(Polygon polygon) {
        Line line = (Line) polygon;

        return new LineCalculateOutput(line.calculateDistance());
    }
}
