package model.coordinatecalculation.strategy;

import model.CoordinateCalculationResult;
import model.DistinguishedCoordinates;
import model.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TriangleAreaCalculationStrategyTest {

    @DisplayName("삼각형 넓이 계산을 위한 좌표 개수는 3개이다.")
    @Test
    void coordinates_size_valid() {
        // given
        final DistinguishedCoordinates coordinates = new DistinguishedCoordinates(List.of(new Point(5, 5), new Point(10, 10), new Point(20, 20)));

        // when
        final TriangleAreaCalculationStrategy actual = new TriangleAreaCalculationStrategy(coordinates);

        // then
        assertThat(actual.getCoordinates())
                .isEqualTo(new DistinguishedCoordinates(List.of(new Point(5, 5), new Point(10, 10), new Point(20, 20))));
    }

    @DisplayName("좌표 3개가 주어지지 않으면 예외 발생.")
    @ParameterizedTest
    @MethodSource("provideIllegalPoints")
    void coordinates_size_validation(List<Point> points) {
        // given
        final DistinguishedCoordinates coordinates = new DistinguishedCoordinates(points);

        // when & then
        assertThatThrownBy(() -> new TriangleAreaCalculationStrategy(coordinates))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("삼각형 넓이 계산을 위한 좌표 계수는 3개이어야 합니다.");
    }

    @DisplayName("삼각형의 넓이를 계산한다.")
    @ParameterizedTest
    @MethodSource("provideTriangleAreaArguments")
    void calculate(List<Point> points, double expectedTriangleArea) {
        // given
        final CoordinateCalculationStrategy sut = new TriangleAreaCalculationStrategy(new DistinguishedCoordinates(points));

        // when
        final CoordinateCalculationResult actual = sut.calculate();

        // then
        assertAll(
                () -> assertThat(actual.getValue()).isCloseTo(expectedTriangleArea, offset(0.1)), // 소수점 이하 첫째자리까지 동일한 것을 보장
                () -> assertThat(actual.getType()).isEqualTo(CoordinateCalculationResult.ResultType.TRIANGLE_AREA)
        );
    }

    public static Stream<List<Point>> provideIllegalPoints() {
        return Stream.of(
                List.of(new Point(10, 10)),
                List.of(new Point(10, 10), new Point(20, 20))
        );
    }

    public static Stream<Arguments> provideTriangleAreaArguments() {
        return Stream.of(
                arguments(
                        List.of(new Point(10, 10), new Point(14, 15), new Point(20, 8)),
                        29.0
                ),
                arguments(
                        List.of(new Point(0, 0), new Point(14, 15), new Point(23, 17)),
                        53.5
                ),
                arguments(
                        List.of(new Point(0, 0), new Point(5, 5), new Point(10, 10)),
                        0.0
                )
        );
    }

}
