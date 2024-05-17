package calculator.domain;

import calculator.controller.request.CoordinateRequest;
import calculator.controller.request.LineCoordinateRequest;
import calculator.coordinate.Point;

public class LineCoordinateCalculator implements CoordinateCalculator {
	private static final int SQUARE_FACTOR = 2;

	private final CoordinateRequest coordinateRequest;

	private LineCoordinateCalculator(final LineCoordinateRequest coordinateRequest) {
		this.coordinateRequest = coordinateRequest;
	}

	public static LineCoordinateCalculator from(final LineCoordinateRequest coordinateRequest) {
		return new LineCoordinateCalculator(coordinateRequest);
	}

	/**
	 * 직선 좌표 : 두 좌표 간 거리 계산
	 */
	@Override
	public double calculate() {
		final Point firstPoint = ((LineCoordinateRequest) coordinateRequest).getFirstPoint();
		final Point secondPoint = ((LineCoordinateRequest) coordinateRequest).getSecondPoint();

		return Math.sqrt(diffSquarePointX(firstPoint, secondPoint) + diffSquarePointY(firstPoint, secondPoint));
	}

	/**
	 * 두 좌표가 주어질 때 x좌표 간 차에 제곱을 한 값을 반환
	 */
	private double diffSquarePointX(final Point point1, final Point point2) {
		double diff = point1.getX() - point2.getX();
		return Math.pow(diff, SQUARE_FACTOR);
	}

	/**
	 * 두 좌표가 주어질 때 y좌표 간 차에 제곱을 한 값을 반환
	 */
	private double diffSquarePointY(final Point point1, final Point point2) {
		double diff = point1.getY() - point2.getY();
		return Math.pow(diff, SQUARE_FACTOR);
	}
}
