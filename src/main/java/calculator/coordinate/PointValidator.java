package calculator.coordinate;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class PointValidator {
	private static final int MIN_POINT_NUMBER = 0;
	private static final int MAX_POINT_NUMBER = 24;
	private static final String ERROR_MESSAGE_WRONG_X_RANGE = "[ERROR] 잘못된 입력입니다. x 좌표값의 범위는 최소 0, 최대 24입니다.";
	private static final String ERROR_MESSAGE_WRONG_Y_RANGE = "[ERROR] 잘못된 입력입니다. y 좌표값의 범위는 최소 0, 최대 24입니다.";
	private static final List<Integer> AVAILABLE_POINT_LIST = new LinkedList<>();

	static {
		IntStream.rangeClosed(MIN_POINT_NUMBER, MAX_POINT_NUMBER)
			.forEach(AVAILABLE_POINT_LIST::add);
	}

	/**
	 * 좌표 x, y가 최소 0부터 최대 24까지의 값을 가지고 있는지 검사
	 */
	public static void validatePoint(final int x, final int y) {
		if (!AVAILABLE_POINT_LIST.contains(x)) {
			throw new IllegalArgumentException(ERROR_MESSAGE_WRONG_X_RANGE);
		}

		if (!AVAILABLE_POINT_LIST.contains(y)) {
			throw new IllegalArgumentException(ERROR_MESSAGE_WRONG_Y_RANGE);
		}
	}
}
