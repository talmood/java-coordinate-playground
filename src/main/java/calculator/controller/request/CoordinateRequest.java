package calculator.controller.request;

import calculator.coordinate.Point;

import java.util.Arrays;
import java.util.List;

public abstract class CoordinateRequest {
	private static final String INPUT_SPLIT_DELIMITER = "-";
	private static final String POINT_SPLIT_DELIMITER = ",";
	private static final String BRACKET_COMMA_REGEX = "[()]";
	static final int FIRST_INDEX = 0;
	static final int SECOND_INDEX = 1;
	static final int THIRD_INDEX = 2;
	static final int FOURTH_INDEX = 3;

	/**
	 * 좌표 입력값에서 '-' 문자를 기준으로 나눔
	 * @param pointInput : Ex) "(0,24)-(10,24)"
	 * @return : Ex) ["(0,24)", "(10,24)"]
	 */
	static String[] splitPointInput(final String pointInput) {
		return pointInput.split(INPUT_SPLIT_DELIMITER);
	}

	/**
	 * 좌표 문자열의 숫자 값으로 Point 생성
	 * @param coordinateInput : Ex) "(0,24)"
	 * @return
	 */
	static Point generatePoint(final String coordinateInput) {
		final String[] coordinateStringNumbers = coordinateInput.replaceAll(BRACKET_COMMA_REGEX, "").split(POINT_SPLIT_DELIMITER);
		List<Integer> coordinateNumbers = Arrays.stream(coordinateStringNumbers)
			.map(Integer::parseInt)
			.toList();

		return Point.of(coordinateNumbers.get(FIRST_INDEX), coordinateNumbers.get(SECOND_INDEX));
	}
}
