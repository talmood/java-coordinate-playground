package view.input;

import model.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputCoordinatesTest {

    @DisplayName("유효한 좌표 입력 포맷으로 객체 생성")
    @Test
    void fromString() {
        assertPointExists("(10,10)-(14,15)", List.of(new Point(10, 10), new Point(14, 15)));
        assertPointExists(
                "(10,10)-(22,10)-(22,18)-(10,18)",
                List.of(
                        new Point(10, 10),
                        new Point(22, 10),
                        new Point(22, 18),
                        new Point(10, 18)
                )
        );
    }

    private void assertPointExists(String coordinatesLiteral, List<Point> expected) {
        final InputCoordinates actual = InputCoordinates.fromString(coordinatesLiteral);
        assertThat(actual.getPoints()).isEqualTo(expected);
    }

    @DisplayName("유효하지 않은 좌표 입력 포맷으로 객체 생성 시 예외 발생")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "123,",
            "(10,10)-",
            "(10,10)-(20,",
            "(10,10)-(20,3",
            "(10,10)-(20,23), ",
    })
    void fromString_invalid_format(String coordinatesLiteral) {
        assertThatThrownBy(() -> InputCoordinates.fromString(coordinatesLiteral))
                .isInstanceOf(IllegalArgumentException.class);
    }

}