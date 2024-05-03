package calculator.exception;

public class ExceptionMessage {
	private static final String ERROR_MESSAGE_FORMAT = "[ERROR] 잘못된 입력입니다. %s";
	private static final String WRONG_X_RANGE = "x 좌표값의 범위는 최소 0, 최대 24입니다.";
	private static final String WRONG_Y_RANGE = "y 좌표값의 범위는 최소 0, 최대 24입니다.";
	private static final String WRONG_INPUT_NUMBER = "좌표값은 최소 0 최대 24인 정수값이어야 합니다.";

	public static String fetchWrongXRangeMessage() {
		return ERROR_MESSAGE_FORMAT.formatted(WRONG_X_RANGE);
	}

	public static String fetchWrongYRangeMessage() {
		return ERROR_MESSAGE_FORMAT.formatted(WRONG_Y_RANGE);
	}

	public static String fetchWrongInputNumberMessage() {
		return ERROR_MESSAGE_FORMAT.formatted(WRONG_INPUT_NUMBER);
	}
}
