package input;

import input.dto.CoordinateInput;

public class CoordinateInputValidator {

    private static final int MIN_COORDINATE_RANGE_INCLUSIVE = 0;
    private static final int MAX_COORDINATE_RANGE_INCLUSIVE = 24;
    private static final int MAX_COORDINATES_SIZE_INCLUSIVE = 4;
    private static final int MIN_COORDINATES_SIZE_INCLUSIVE = 2;

    public void validate(CoordinateInput coordinateInput) {
        this.validateSize(coordinateInput);
        this.validateSameCoordinate(coordinateInput);
        this.validateRange(coordinateInput);
    }

    private void validateSize(CoordinateInput coordinateInput) {
        if (!coordinateInput.isCoordinatesSizeBetween(MIN_COORDINATES_SIZE_INCLUSIVE, MAX_COORDINATES_SIZE_INCLUSIVE)) {
            throw new IllegalArgumentException(
                    String.format(
                            "> [ERROR] 잘못된 입력입니다. 좌표는 최소 %d개 이상, %d개 이하까지 입력가능합니다.",
                            MIN_COORDINATES_SIZE_INCLUSIVE,
                            MAX_COORDINATES_SIZE_INCLUSIVE
                    )
            );
        }
    }

    private void validateRange(CoordinateInput coordinateInput) {
        if (!coordinateInput.isCoordinatesRange(MIN_COORDINATE_RANGE_INCLUSIVE, MAX_COORDINATE_RANGE_INCLUSIVE)) {
            throw new IllegalArgumentException(
                    String.format(
                            "> [ERROR] 잘못된 입력입니다. X, Y 좌표의 범위는 최소 %d, 최대 %d입니다.",
                            MIN_COORDINATE_RANGE_INCLUSIVE,
                            MAX_COORDINATE_RANGE_INCLUSIVE
                    )
            );
        }
    }

    private void validateSameCoordinate(CoordinateInput coordinateInput) {
        if (coordinateInput.hasSameCoordinate()) {
            throw new IllegalArgumentException("> [ERROR] 잘못된 입력입니다. 겹치는 좌표가 존재합니다.");
        }
    }
}
