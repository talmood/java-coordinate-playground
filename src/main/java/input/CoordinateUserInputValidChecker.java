package input;

import dto.CoordinateUserInput;

public class CoordinateUserInputValidChecker {

    private static final int MIN_COORDINATE_RANGE = 0;
    private static final int MAX_COORDINATE_RANGE = 24;
    private static final int MAX_COORDINATES_SIZE = 4;
    private static final int MIN_COORDINATES_SIZE = 2;

    public void check(CoordinateUserInput coordinateUserInput) {
        this.checkSize(coordinateUserInput);
        this.checkSameCoordinate(coordinateUserInput);
        this.checkRange(coordinateUserInput);
    }

    private void checkSize(CoordinateUserInput coordinateUserInput) {
        if (!coordinateUserInput.isCoordinatesSizeBetween(MIN_COORDINATES_SIZE, MAX_COORDINATES_SIZE)) {
            throw new IllegalArgumentException(
                    String.format(
                            "[ERROR] 잘못된 입력입니다. 좌표는 최소 %d개 이상, %d개 이하까지 입력가능합니다.",
                            MIN_COORDINATES_SIZE,
                            MAX_COORDINATES_SIZE
                    )
            );
        }
    }

    private void checkRange(CoordinateUserInput coordinateUserInput) {
        if (!coordinateUserInput.isCandidatesRange(MIN_COORDINATE_RANGE, MAX_COORDINATE_RANGE)) {
            throw new IllegalArgumentException(
                    String.format(
                            "[ERROR] 잘못된 입력입니다. X, Y 좌표의 범위는 최소 %d, 최대 %d입니다.",
                            MIN_COORDINATE_RANGE,
                            MAX_COORDINATE_RANGE
                    )
            );
        }
    }

    private void checkSameCoordinate(CoordinateUserInput coordinateUserInput) {
        if (coordinateUserInput.hasSameCoordinate()) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. 겹치는 좌표가 존재합니다.");
        }
    }
}
