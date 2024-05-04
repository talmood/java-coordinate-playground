package calculator.controller.request;

import calculator.coordinate.Point;

public class LineCoordinateRequest extends CoordinateRequest {

	private final Point firstPoint;
	private final Point secondPoint;

	private LineCoordinateRequest(final Point firstPoint, final Point secondPoint) {
		this.firstPoint = firstPoint;
		this.secondPoint = secondPoint;
	}

	public static LineCoordinateRequest from(final String pointInput) {
		LineCoodinateValidator.validatePointInput(pointInput);

		String[] splitPointInputs = splitPointInput(pointInput);
		Point firstPoint = generatePoint(splitPointInputs[FIRST_INDEX]);
		Point secondPoint = generatePoint(splitPointInputs[SECOND_INDEX]);
		return new LineCoordinateRequest(firstPoint, secondPoint);
	}

	public Point getFirstPoint() {
		return this.firstPoint;
	}

	public Point getSecondPoint() {
		return this.secondPoint;
	}
}
