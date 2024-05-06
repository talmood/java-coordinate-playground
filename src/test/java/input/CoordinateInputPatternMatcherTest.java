package input;

import input.dto.CoordinateInput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateInputPatternMatcherTest {

    @Test
    void match() {
        int num1 = 5;
        int num2 = 6;
        int num3 = 1;
        int num4 = 2;
        String input1 = "(" + num1 + "," + num2 + ")";
        String input2 = "(" + num3 + "," + num4 + ")";

        String userInput = input1 + "-" + input2;
        CoordinateInput matches = CoordinateInputPatternMatcher.match(userInput);

        // 내부 객체 비교를 위해 getter를만듬.. 다른 방법 없을까..?
        List<CoordinateInput.Coordinate> coordinates = matches.getCoordinates();

        assertAll(
                () -> assertEquals(coordinates.get(0), new CoordinateInput.Coordinate(num1, num2)),
                () -> assertEquals(coordinates.get(1), new CoordinateInput.Coordinate(num3, num4))
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "(1,1)-", "-(1,1)", "test"})
    void match(String userInput) {
        assertAll(
                () -> {
                    IllegalArgumentException illegalArgumentException =
                            assertThrows(IllegalArgumentException.class, () -> CoordinateInputPatternMatcher.match(userInput));

                    assertEquals(illegalArgumentException.getMessage(), "[ERROR] 잘못된 입력입니다.");
                }
        );
    }
}