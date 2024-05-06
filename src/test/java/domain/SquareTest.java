package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SquareTest {

    private static final int VALID_COORDINATE_SIZE = 4;

    @Test
    void invalidCoordinateSize() {
        Coordinates coordinates = Coordinates.create(
                List.of(
                        Coordinate.create(10, 10),
                        Coordinate.create(22, 10),
                        Coordinate.create(22, 18)
                )
        );

        IllegalArgumentException illegalArgumentException =
                assertThrows(IllegalArgumentException.class, () -> Square.create(coordinates));

        assertEquals(
                illegalArgumentException.getMessage(),
                String.format("[ERROR] 사각형의 좌표는 %d개 여야 합니다.", VALID_COORDINATE_SIZE)
        );
    }

    @Test
    void isRectangleTest() {
        Coordinates coordinates = Coordinates.create(
                List.of(
                        Coordinate.create(10, 10),
                        Coordinate.create(22, 10),
                        Coordinate.create(22, 18),
                        Coordinate.create(10, 19)
                )
        );

        IllegalArgumentException illegalArgumentException =
                assertThrows(IllegalArgumentException.class, () -> Square.create(coordinates));

        assertEquals(illegalArgumentException.getMessage(), "[ERROR] 사각형은 직사각형이어야 합니다.");

    }
}