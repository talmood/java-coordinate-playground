package calculator.controller.request;

import calculator.coordinate.Point;

import java.util.HashSet;
import java.util.Set;

public class RectangleCoordinateValidator extends CoordinateValidator {
	private static final int COORDINATE_COUNT = 4;
	private static final int SAME_XY_COORDINATE_COUNT = 2;

	private static final String WRONG_INPUT_COORDINATE_COUNT = " 사각형 좌표는 네 개를 입력해야 합니다.";
	private static final String WRONG_RECTANGLE = " 사각형 좌표는 직사각형만 허용합니다.";

	private static Set<Integer> xSet = new HashSet<>();
	private static Set<Integer> ySet = new HashSet<>();

	/**
	 * 좌표 입력값을 검증한다.
	 * @param pointInput
	 */
	public static void validatePointInput(final String pointInput) {
		String[] splitPointInputs = validatePointInputSplit(pointInput);
		validateSplitPointInputSize(splitPointInputs);
		validateMatchPointRegex(splitPointInputs);
	}

	private static void validateSplitPointInputSize(final String[] splitPointInputs) {
		if (splitPointInputs.length != COORDINATE_COUNT) {
			throw new IllegalArgumentException(ERROR_MESSAGE + WRONG_INPUT_COORDINATE_COUNT);
		}
	}

	/**
	 * 입력 좌표가 직사각형을 이루는지 검증한다.
	 * x 값이 같은 좌표가 2개 && y 값이 같은 좌표가 2개
	 */
	public static void validateRectangle(final Point firstPoint,
										  final Point secondPoint,
										  final Point thirdPoint,
										  final Point fourthPoint) {

		initXSet(firstPoint, secondPoint, thirdPoint, fourthPoint);
		initYSet(firstPoint, secondPoint, thirdPoint, fourthPoint);

		if (xSet.size() > SAME_XY_COORDINATE_COUNT ||
			ySet.size() > SAME_XY_COORDINATE_COUNT) {
			throw new IllegalArgumentException(ERROR_MESSAGE + WRONG_RECTANGLE);
		}
	}

	private static void initXSet(final Point firstPoint,
								 final Point secondPoint,
								 final Point thirdPoint,
								 final Point fourthPoint) {
		xSet.add(firstPoint.getX());
		xSet.add(secondPoint.getX());
		xSet.add(thirdPoint.getX());
		xSet.add(fourthPoint.getX());
	}

	private static void initYSet(final Point firstPoint,
								 final Point secondPoint,
								 final Point thirdPoint,
								 final Point fourthPoint) {
		ySet.add(firstPoint.getY());
		ySet.add(secondPoint.getY());
		ySet.add(thirdPoint.getY());
		ySet.add(fourthPoint.getY());
	}
}
