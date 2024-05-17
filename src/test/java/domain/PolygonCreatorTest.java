package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PolygonCreatorTest {
    @Test
    void lineCreate() {
        Coordinates coordinates = Coordinates.create(
                List.of(
                        Coordinate.create(10, 11),
                        Coordinate.create(12, 13)
                )
        );

        Polygon polygon = PolygonCreator.create(coordinates);

        assertTrue(() -> polygon instanceof Line);
    }

    @Test
    void triangleCreate() {
        Coordinates coordinates = Coordinates.create(
                List.of(
                        Coordinate.create(10, 11),
                        Coordinate.create(12, 13),
                        Coordinate.create(14, 15)
                )
        );

        Polygon polygon = PolygonCreator.create(coordinates);

        assertTrue(() -> polygon instanceof Triangle);
    }

    @Test
    void SquareCreate() {
        Coordinates coordinates = Coordinates.create(
                List.of(
                        Coordinate.create(10, 10),
                        Coordinate.create(22, 10),
                        Coordinate.create(22, 18),
                        Coordinate.create(10, 18)
                )
        );

        Polygon polygon = PolygonCreator.create(coordinates);

        assertTrue(() -> polygon instanceof Square);
    }

    @Test
    void invalidSize() {
        Coordinates coordinates = Coordinates.create(
                List.of(
                        Coordinate.create(10, 10),
                        Coordinate.create(22, 10),
                        Coordinate.create(22, 18),
                        Coordinate.create(10, 18),
                        Coordinate.create(15, 18)
                )
        );

        IllegalArgumentException illegalArgumentException =
                assertThrows(IllegalArgumentException.class, () -> PolygonCreator.create(coordinates));

        assertEquals(illegalArgumentException.getMessage(), "[ERROR] 좌표 갯수에 맞는 도형이 없습니다.");
    }
}