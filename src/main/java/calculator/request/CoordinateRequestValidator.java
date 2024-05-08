package calculator.request;

import calculator.utils.ErrorMessage;
import calculator.utils.DashSplitter;
import calculator.utils.StringUtils;

public class CoordinateRequestValidator {

    private static final String POINT_INPUT_PATTERN = "\\(\\d+,\\d+\\)(?:-\\(\\d+,\\d+\\))*";
    private static final String SINGLE_POINT_PATTERN = "\\(\\d+,\\d+\\)*";

    private CoordinateRequestValidator() {
    }

    static void validate(final String coordinateInput) {
        validateCoordinateInput(coordinateInput);
        DashSplitter.split(coordinateInput).forEach(CoordinateRequestValidator::validateSinglePointPattern);
    }

    private static void validateCoordinateInput(final String coordinateInput) {
        if (StringUtils.isEmpty(coordinateInput)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT);
        }

        if (!coordinateInput.matches(POINT_INPUT_PATTERN)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT);
        }
    }

    private static void validateSinglePointPattern(final String singlePoint) {
        if (!singlePoint.matches(SINGLE_POINT_PATTERN)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT);
        }
    }
}
