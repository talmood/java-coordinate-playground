package calculator.controller.request;

public class LineCoodinateValidator {
	private static final String SPLIT_DELIMITER = "-";
	private static final int LINE_COORDINATE_COUNT = 2;
	private static final String POINT_REGEX = "\\(\\d+,\\d+\\)";

	private static final String ERROR_MESSAGE = "[ERROR] 잘못된 입력입니다.";
	private static final String WRONG_INPUT_COORDINATE_COUNT = " 직선 좌표는 두 개를 입력해야 합니다.";
	private static final String WRONG_INPUT_POINT = " 좌표 입력 형태는 괄호'()'로 둘러쌓여 있고 쉼표 ','로 x값과 y값을 구분해야 합니다.";

	/**
	 * 직선 좌표 입력값을 검증한다.
	 * @param pointInput
	 */
	public static void validatePointInput(final String pointInput) {
		String[] splitPointInputs = validatePointInputSplit(pointInput);
		validateSplitPointInputSize(splitPointInputs);
		validateMatchPointRegex(splitPointInputs);
	}

	private static String[] validatePointInputSplit(final String pointInput) {
		try {
			return pointInput.split(SPLIT_DELIMITER);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
	}

	private static void validateSplitPointInputSize(final String[] splitPointInputs) {
		if (splitPointInputs.length != LINE_COORDINATE_COUNT) {
			throw new IllegalArgumentException(ERROR_MESSAGE + WRONG_INPUT_COORDINATE_COUNT);
		}
	}

	private static void validateMatchPointRegex(final String[] splitPointInputs) {
		for (String pointInput : splitPointInputs) {
			if (!pointInput.matches(POINT_REGEX)) {
				throw new IllegalArgumentException(ERROR_MESSAGE + WRONG_INPUT_POINT);
			}
		}
	}
}
