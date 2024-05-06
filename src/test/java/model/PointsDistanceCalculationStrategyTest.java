package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PointsDistanceCalculationStrategyTest {

    @DisplayName("주어진 좌표가 2개가 아니라면 예외 발생")
    @Test
    void validateCoordinateSize() {
        final Coordinates coordinates = new Coordinates(List.of(new Point(10, 10)));
        assertThatThrownBy(() -> new PointsDistanceCalculationStrategy(coordinates))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("두 점 사이의 계산을 위한 좌표 계수는 2개이어야 합니다.");
    }

    @DisplayName("두 점 사이의 좌표를 계산한다.")
    @ParameterizedTest
    @MethodSource("provideDistanceArguments")
    void calculate(Coordinates coordinates, double expectedDistance) {
        // given
        final CoordinateCalculationStrategy sut = new PointsDistanceCalculationStrategy(coordinates);

        // when
        final CoordinateCalculationResult actual = sut.calculate();

        // then
        assertAll(
                () -> assertThat(actual.getValue()).isCloseTo(expectedDistance, offset(0.000001)), // offset 소수점 이하 6자리까지는 일치하는 것을 보장.
                () -> assertThat(actual.getType()).isEqualTo(CoordinateCalculationResult.ResultType.DISTANCE)
        );
    }

    public static Stream<Arguments> provideDistanceArguments() {
        return Stream.of(
                arguments(
                        new Coordinates(List.of(new Point(10, 10), new Point(14, 15))),
                        6.403124
                ),
                arguments(
                        new Coordinates(List.of(new Point(0, 0), new Point(0, 0))),
                        0.0
                ),
                arguments(
                        new Coordinates(List.of(new Point(0, 0), new Point(24, 24))),
                        33.941125
                )
        );
    }

}