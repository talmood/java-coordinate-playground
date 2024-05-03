package calculator.coordinate;

import calculator.exception.ExceptionMessage;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class PointValidator {
	private static final int MIN_POINT_NUMBER = 0;
	private static final int MAX_POINT_NUMBER = 24;
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
			throw new IllegalArgumentException(ExceptionMessage.fetchWrongXRangeMessage());
		}

		if (!AVAILABLE_POINT_LIST.contains(y)) {
			throw new IllegalArgumentException(ExceptionMessage.fetchWrongYRangeMessage());
		}
	}
}
