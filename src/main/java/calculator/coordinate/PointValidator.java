package calculator.coordinate;

import calculator.exception.ExceptionMessage;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class PointValidator {
	private static final int MIN_POINT_NUMBER = 0;
	private static final int MAX_POINT_NUMBER = 24;
	private static final Set<Integer> AVAILABLE_POINT_SET = new HashSet<>();

	static {
		IntStream.rangeClosed(MIN_POINT_NUMBER, MAX_POINT_NUMBER)
				.forEach(AVAILABLE_POINT_SET::add);
	}

	/**
	 * 좌표 x, y가 최소 0부터 최대 24까지의 값을 가지고 있는지 검사
	 */
	public static void validatePoint(final int x, final int y) {
		if (!AVAILABLE_POINT_SET.contains(x)) {
			throw new IllegalArgumentException(ExceptionMessage.fetchWrongXRangeMessage());
		}

		if (!AVAILABLE_POINT_SET.contains(y)) {
			throw new IllegalArgumentException(ExceptionMessage.fetchWrongYRangeMessage());
		}
	}
}
