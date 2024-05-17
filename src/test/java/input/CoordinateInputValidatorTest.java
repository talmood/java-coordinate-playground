package input;

import input.dto.CoordinateInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CoordinateInputValidatorTest {

    private static final int MIN_COORDINATE_RANGE_INCLUSIVE = 0;
    private static final int MAX_COORDINATE_RANGE_INCLUSIVE = 24;
    private static final int MAX_COORDINATES_SIZE_INCLUSIVE = 4;
    private static final int MIN_COORDINATES_SIZE_INCLUSIVE = 2;

    static Stream<Arguments> invalidCoordinateSizeParameters() {
        return Stream.of(
                Arguments.of(new CoordinateInput(Collections.emptyList())),
                Arguments.of(new CoordinateInput(List.of(new CoordinateInput.Coordinate(1, 2)))),
                Arguments.of(new CoordinateInput(
                                List.of(
                                        new CoordinateInput.Coordinate(1, 2),
                                        new CoordinateInput.Coordinate(1, 2),
                                        new CoordinateInput.Coordinate(1, 2),
                                        new CoordinateInput.Coordinate(1, 2),
                                        new CoordinateInput.Coordinate(1, 2)
                                )
                        )
                )
        );
    }

    static Stream<Arguments> invalidCoordinateRange() {
        return Stream.of(
                Arguments.of(new CoordinateInput(
                                List.of(
                                        new CoordinateInput.Coordinate(25, 2),
                                        new CoordinateInput.Coordinate(1, 2)
                                )
                        )
                ),
                Arguments.of(new CoordinateInput(
                                List.of(
                                        new CoordinateInput.Coordinate(-1, 2),
                                        new CoordinateInput.Coordinate(1, 2)
                                )
                        )
                )
        );
    }

    static Stream<Arguments> hasSameCoordinates() {
        return Stream.of(
                Arguments.of(new CoordinateInput(
                                List.of(
                                        new CoordinateInput.Coordinate(24, 2),
                                        new CoordinateInput.Coordinate(1, 2),
                                        new CoordinateInput.Coordinate(24, 2),
                                        new CoordinateInput.Coordinate(3, 4)
                                )
                        )
                )
        );
    }

    @ParameterizedTest
    @MethodSource("invalidCoordinateSizeParameters")
    @DisplayName("좌표 갯수 테스트")
    void validateCoordinateSize(CoordinateInput coordinateInput) {
        CoordinateInputValidator coordinateInputValidator = new CoordinateInputValidator();

        IllegalArgumentException illegalArgumentException = assertThrows(
                IllegalArgumentException.class,
                () -> coordinateInputValidator.validate(coordinateInput)
        );
        assertEquals(
                illegalArgumentException.getMessage(),
                String.format(
                        "> [ERROR] 잘못된 입력입니다. 좌표는 최소 %d개 이상, %d개 이하까지 입력가능합니다.",
                        MIN_COORDINATES_SIZE_INCLUSIVE,
                        MAX_COORDINATES_SIZE_INCLUSIVE
                )
        );
    }

    @ParameterizedTest
    @MethodSource("invalidCoordinateRange")
    @DisplayName("좌표 범위 테스트")
    void validateCoordinateRange(CoordinateInput coordinateInput) {
        CoordinateInputValidator coordinateInputValidator = new CoordinateInputValidator();

        IllegalArgumentException illegalArgumentException = assertThrows(
                IllegalArgumentException.class,
                () -> coordinateInputValidator.validate(coordinateInput)
        );

        assertEquals(
                illegalArgumentException.getMessage(),
                String.format(
                        "> [ERROR] 잘못된 입력입니다. X, Y 좌표의 범위는 최소 %d, 최대 %d입니다.",
                        MIN_COORDINATE_RANGE_INCLUSIVE,
                        MAX_COORDINATE_RANGE_INCLUSIVE
                )
        );
    }

    @ParameterizedTest
    @MethodSource("hasSameCoordinates")
    @DisplayName("중복 좌표 테스트")
    void validateHasSameCoordinate(CoordinateInput coordinateInput) {
        CoordinateInputValidator coordinateInputValidator = new CoordinateInputValidator();

        IllegalArgumentException illegalArgumentException = assertThrows(
                IllegalArgumentException.class,
                () -> coordinateInputValidator.validate(coordinateInput)
        );

        assertEquals(
                illegalArgumentException.getMessage(),
                "> [ERROR] 잘못된 입력입니다. 겹치는 좌표가 존재합니다."
        );
    }
}