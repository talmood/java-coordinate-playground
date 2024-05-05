package calculator.controller.request;

public abstract class CoordinateValidator {
	private static final String SPLIT_DELIMITER = "-";
	private static final String POINT_REGEX = "\\(\\d+,\\d+\\)";

	static final String ERROR_MESSAGE = "[ERROR] 잘못된 입력입니다.";
	private static final String WRONG_INPUT_POINT = " 좌표 입력 형태는 괄호'()'로 둘러쌓여 있고 쉼표 ','로 x값과 y값을 구분해야 합니다.";

	static String[] validatePointInputSplit(final String pointInput) {
		try {
			return pointInput.split(SPLIT_DELIMITER);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
	}

	static void validateMatchPointRegex(final String[] splitPointInputs) {
		for (String pointInput : splitPointInputs) {
			if (!pointInput.matches(POINT_REGEX)) {
				throw new IllegalArgumentException(ERROR_MESSAGE + WRONG_INPUT_POINT);
			}
		}
	}
}
