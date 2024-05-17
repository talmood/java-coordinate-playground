import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class CoordinateTest {

    @Test
    void validateFormat() {
        String userInput = "(10,10)-";

        assertThatThrownBy(() -> new Coordinate(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력입니다.");
    }

    @Test
    void validateRangeOfPoints() {
        String userInput = "(10,10)";

        assertThatThrownBy(() -> new Coordinate(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("좌표는 최소 2개 이상, 4개 이하까지 입력가능합니다.");
    }

    @Test
    void validateNumberOfCoordinates() {
        String userInput = "(10,10)-(22,10)-(22,18)-(34,27)";

        assertThatThrownBy(() -> new Coordinate(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("X, Y 좌표의 범위는 최소 0, 최대 24입니다.");
    }

    @Test
    void validateIfRectangleInCase4Points() {
        String userInput = "(10,10)-(22,10)-(22,18)-(10,16)";

        assertThatThrownBy(() -> new Coordinate(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("직사각형이 아닙니다.");
    }



}