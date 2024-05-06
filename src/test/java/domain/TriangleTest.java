package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleTest {

    private static final int VALID_COORDINATE_SIZE = 3;

    @Test
    void invalidCoordinateSize() {
        Coordinates coordinates = Coordinates.create(
                List.of(
                        Coordinate.create(10, 10),
                        Coordinate.create(22, 10),
                        Coordinate.create(22, 18),
                        Coordinate.create(10, 18)
                )
        );

        IllegalArgumentException illegalArgumentException =
                assertThrows(IllegalArgumentException.class, () -> Triangle.create(coordinates));

        assertEquals(illegalArgumentException.getMessage(),
                String.format("[ERROR] 삼각형의 좌표는 %d개 여야 합니다.", VALID_COORDINATE_SIZE)
        );
    }

}