package calculator.controller.request;

import calculator.coordinate.Point;

public class RectangleCoordinateRequest extends CoordinateRequest {

	private final Point firstPoint;
	private final Point secondPoint;
	private final Point thirdPoint;
	private final Point fourthPoint;

	private RectangleCoordinateRequest(final Point firstPoint,
									   final Point secondPoint,
									   final Point thirdPoint,
									   final Point fourthPoint) {
		this.firstPoint = firstPoint;
		this.secondPoint = secondPoint;
		this.thirdPoint = thirdPoint;
		this.fourthPoint = fourthPoint;
	}

	public static RectangleCoordinateRequest from(final String pointInput) {
		RectangleCoordinateValidator.validatePointInput(pointInput);

		String[] splitPointInputs = splitPointInput(pointInput);
		Point firstPoint = generatePoint(splitPointInputs[FIRST_INDEX]);
		Point secondPoint = generatePoint(splitPointInputs[SECOND_INDEX]);
		Point thirdPoint = generatePoint(splitPointInputs[THIRD_INDEX]);
		Point fourthPoint = generatePoint(splitPointInputs[FOURTH_INDEX]);

		RectangleCoordinateValidator.validateRectangle(firstPoint, secondPoint, thirdPoint, fourthPoint);
		return new RectangleCoordinateRequest(firstPoint, secondPoint, thirdPoint, fourthPoint);
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

	public Point getFourthPointPoint() {
		return this.fourthPoint;
	}
}
