package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {

    @DisplayName("점 생성 시 x,y 값이 [0, 24] 범위가 아니라면 예외를 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "-1, 0",
            "0, -1",
            "25, 0",
            "0, 25"
    })
    void new_Point(int x, int y) {
        // given
        assertThatThrownBy(() -> new Point(x, y))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("X, Y 좌표의 범위는 최소 0, 최대 24입니다.");
    }

}