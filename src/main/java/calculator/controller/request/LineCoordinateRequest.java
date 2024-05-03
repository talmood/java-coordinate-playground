package calculator.controller.request;

import calculator.coordinate.Point;

import java.util.Arrays;
import java.util.List;

public class LineCoordinateRequest {
	private static final String SPLIT_DELIMITER = "-";
	private static final String BRACKET_COMMA_REGEX = "[(),]";
	private static final int FIRST_INDEX = 0;
	private static final int SECOND_INDEX = 1;

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

	/**
	 * 좌표 입력값에서 '-' 문자를 기준으로 나눔
	 * @param pointInput : Ex) "(0,24)-(10,24)"
	 * @return : Ex) ["(0,24)", "(10,24)"]
	 */
	private static String[] splitPointInput(final String pointInput) {
		return pointInput.split(SPLIT_DELIMITER);
	}

	/**
	 * 좌표 문자열의 숫자 값으로 Point 생성
	 * @param coordinateInput : Ex) "(0,24)"
	 * @return
	 */
	private static Point generatePoint(final String coordinateInput) {
		final String[] coordinateStringNumbers = coordinateInput.split(BRACKET_COMMA_REGEX);
		List<Integer> coordinateNumbers = Arrays.stream(coordinateStringNumbers)
				.map(Integer::parseInt)
				.toList();

		return Point.of(coordinateNumbers.get(FIRST_INDEX), coordinateNumbers.get(SECOND_INDEX));
	}
}
