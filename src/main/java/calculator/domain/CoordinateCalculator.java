package calculator.domain;

import calculator.controller.request.CoordinateRequest;

public interface CoordinateCalculator {
	double calculate(final CoordinateRequest coordinateRequest);
}
