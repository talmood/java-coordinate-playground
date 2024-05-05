package calculator.domain;

import calculator.controller.request.CoordinateRequest;
import calculator.controller.request.RectangleCoordinateRequest;
import calculator.coordinate.Point;

public class RectangleCoordinateCalculator implements CoordinateCalculator {
	private static final int SQUARE_FACTOR = 2;

	public RectangleCoordinateCalculator() {}

	/**
	 * 사각형 면적 : 너비 * 높이
	 */
	@Override
	public double calculate(final CoordinateRequest coordinateRequest) {
		final Point firstPoint = ((RectangleCoordinateRequest) coordinateRequest).getFirstPoint();
		final Point secondPoint = ((RectangleCoordinateRequest) coordinateRequest).getSecondPoint();
		final Point thirdPoint = ((RectangleCoordinateRequest) coordinateRequest).getThirdPointPoint();
		final Point fourthPoint = ((RectangleCoordinateRequest) coordinateRequest).getFourthPointPoint();

		return calculateSquareWidth(firstPoint, secondPoint, thirdPoint, fourthPoint) *
			calculateSquareHeight(firstPoint, secondPoint, thirdPoint, fourthPoint);
	}

	/**
	 * 사각형 너비 구하기 (가장 오른쪽 점 - 가장 왼쪽 점)
	 */
	private int calculateSquareWidth(final Point firstPoint,
									 final Point secondPoint,
									 final Point thirdPoint,
									 final Point fourcePoint) {
		int minX = Math.min(Math.min(firstPoint.getX(), secondPoint.getX()), Math.min(thirdPoint.getX(), fourcePoint.getX()));
		int maxX = Math.max(Math.max(firstPoint.getX(), secondPoint.getX()), Math.max(thirdPoint.getX(), fourcePoint.getX()));

		return maxX - minX;
	}

	/**
	 * 사각형의 높이 구하기 (가장 위쪽 점 - 가장 아래쪽 점)
	 */
	private int calculateSquareHeight(final Point firstPoint,
									  final Point secondPoint,
									  final Point thirdPoint,
									  final Point fourcePoint) {
		int minY = Math.min(Math.min(firstPoint.getY(), secondPoint.getY()), Math.min(thirdPoint.getY(), fourcePoint.getY()));
		int maxY = Math.max(Math.max(firstPoint.getY(), secondPoint.getY()), Math.max(thirdPoint.getY(), fourcePoint.getY()));

		return maxY - minY;
	}
}
