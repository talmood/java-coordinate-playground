package model.coordinatecalculation;

import model.DistinguishedCoordinates;
import model.Point;
import model.Rectangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RectangleTest {

    @DisplayName("두 쌍의 변의 길이가 같고, 대각선이 서로 길이가 같으면 직사각형이다.")
    @Test
    void valid_points() {
        final DistinguishedCoordinates coordinates =
                new DistinguishedCoordinates(List.of(
                        new Point(10, 10),
                        new Point(22, 10),
                        new Point(10, 18),
                        new Point(22, 18)
                ));

        assertDoesNotThrow(() -> new Rectangle(coordinates));

        final Rectangle actual = new Rectangle(coordinates);
        assertThat(actual.coordinates()).isEqualTo(
                new DistinguishedCoordinates(List.of(
                        new Point(10, 10),
                        new Point(22, 10),
                        new Point(10, 18),
                        new Point(22, 18)
                ))
        );
    }

    @DisplayName("주어진 점이 4개가 아니면 직사각형이 아니다.")
    @Test
    void invalid_size_of_rectangle() {
        final DistinguishedCoordinates coordinates = new DistinguishedCoordinates(List.of(new Point(10, 10)));
        assertThatThrownBy(() -> new Rectangle(coordinates))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("직사각형이 아닙니다.");
    }

}
