package calculator.controller.request;

public class TriangleCoordinateValidator extends CoordinateValidator {
	private static final int COORDINATE_COUNT = 3;
	private static final int SAME_XY_COORDINATE_COUNT = 2;

	private static final String WRONG_INPUT_COORDINATE_COUNT = " 삼각형 좌표는 두 개를 입력해야 합니다.";

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
}
