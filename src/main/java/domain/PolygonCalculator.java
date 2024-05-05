package domain;

import output.dto.CalculateOutput;

public interface PolygonCalculator {

    CalculateOutput calculate(Polygon polygon);
}