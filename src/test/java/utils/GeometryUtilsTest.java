package utils;

import model.Point;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GeometryUtilsTest {

    @ParameterizedTest
    @MethodSource("provideDistanceArguments")
    void calculateDistance(Point first, Point second, double expectedDistance) {
        assertThat(GeometryUtils.calculateDistance(first, second)).isCloseTo(expectedDistance, offset(0.000001));
    }

    public static Stream<Arguments> provideDistanceArguments() {
        return Stream.of(
                arguments(
                        new Point(10, 10),
                        new Point(14, 15),
                        6.403124
                ),
                arguments(
                        new Point(0, 0),
                        new Point(0, 0),
                        0.0
                ),
                arguments(
                        new Point(0, 0),
                        new Point(24, 24),
                        33.941125
                )
        );
    }

}