package calculator.domain;

import calculator.controller.request.CoordinateRequest;
import calculator.controller.request.TriangleCoordinateRequest;
import calculator.coordinate.Point;

public class TriangleCoordinateCalculator implements CoordinateCalculator {

	public TriangleCoordinateCalculator() {}

	/**
	 * 삼각형 면적 : 사선 공식
	 * 1/2 * |(x1y2 + x2y3 + x3y1) - (x1y3 + x2y1 + x3y2)|
	 */
	@Override
	public double calculate(final CoordinateRequest coordinateRequest) {
		final Point firstPoint = ((TriangleCoordinateRequest) coordinateRequest).getFirstPoint();
		final Point secondPoint = ((TriangleCoordinateRequest) coordinateRequest).getSecondPoint();
		final Point thirdPoint = ((TriangleCoordinateRequest) coordinateRequest).getThirdPointPoint();

		return (double) (Math.abs(leftDiagonalFormula(firstPoint, secondPoint, thirdPoint) -
			rightDiagonalFormula(firstPoint, secondPoint, thirdPoint))) / 2;
	}

	private static int leftDiagonalFormula(Point firstPoint, Point secondPoint, Point thirdPoint) {
		return firstPoint.getX() * secondPoint.getY() + secondPoint.getX() * thirdPoint.getY() + thirdPoint.getX() * firstPoint.getY();
	}

	private static int rightDiagonalFormula(Point firstPoint, Point secondPoint, Point thirdPoint) {
		return firstPoint.getX() * thirdPoint.getY() + secondPoint.getX() * firstPoint.getY() + thirdPoint.getX() * secondPoint.getY();
	}
}
