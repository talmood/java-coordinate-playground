package utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MathUtilsTest {

    @ParameterizedTest
    @CsvSource({
            "2, 4",
            "3, 9",
            "4, 16",
            "29, 841"
    })
    void square(int valueToSquare, int expectedSquared) {
        assertThat(MathUtils.square(2)).isEqualTo(4);
    }

}