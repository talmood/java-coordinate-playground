package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DistinguishedCoordinatesTest {

    @DisplayName("서로 구별되는 점들로만 객체 생성 가능.")
    @Test
    void new_DistinguishedCoordinates() {
        final List<Point> points = List.of(new Point(10, 10), new Point(24, 24));

        final DistinguishedCoordinates actual = new DistinguishedCoordinates(points);

        assertThat(actual.getPoints()).hasSize(2)
                .containsExactlyInAnyOrder(
                        new Point(24, 24),
                        new Point(10, 10)
                );
    }

    @DisplayName("서로 구별되지 않는 점으로는 객체 생성 불가능.")
    @Test
    void invalid_new() {
        assertThatThrownBy(() -> new DistinguishedCoordinates(List.of(
                new Point(10, 10),
                new Point(10, 10)
        )))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("겹치는 좌표가 존재합니다.");

        assertThatThrownBy(() -> new DistinguishedCoordinates(List.of(
                new Point(10, 10),
                new Point(10, 10),
                new Point(10, 10)
        )))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("겹치는 좌표가 존재합니다.");

    }

}