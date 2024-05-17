package calculator.controller.request;

import calculator.coordinate.Point;

public class TriangleCoordinateRequest extends CoordinateRequest {

	private final Point firstPoint;
	private final Point secondPoint;
	private final Point thirdPoint;

	private TriangleCoordinateRequest(final Point firstPoint,
									  final Point secondPoint,
									  final Point thirdPoint) {
		this.firstPoint = firstPoint;
		this.secondPoint = secondPoint;
		this.thirdPoint = thirdPoint;
	}

	public static TriangleCoordinateRequest from(final String pointInput) {
		TriangleCoordinateValidator.validatePointInput(pointInput);

		String[] splitPointInputs = splitPointInput(pointInput);
		Point firstPoint = generatePoint(splitPointInputs[FIRST_INDEX]);
		Point secondPoint = generatePoint(splitPointInputs[SECOND_INDEX]);
		Point thirdPoint = generatePoint(splitPointInputs[THIRD_INDEX]);

		return new TriangleCoordinateRequest(firstPoint, secondPoint, thirdPoint);
	}

	public Point getFirstPoint() {
		return this.firstPoint;
	}

	public Point getSecondPoint() {
		return this.secondPoint;
	}

	public Point getThirdPointPoint() {
		return this.thirdPoint;
	}

}
