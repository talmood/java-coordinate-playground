package domain;

import output.dto.CalculateResultOutput;

public interface PolygonCalculator {

    CalculateResultOutput calculate(Polygon polygon);
}