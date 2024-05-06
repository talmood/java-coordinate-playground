package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PolygonCalculatorCreatorTest {

    @Test
    void lineCalculatorCreate() {
        Line line = Line.create(
                Coordinates.create(
                        List.of(
                                Coordinate.create(10, 11),
                                Coordinate.create(12, 13)
                        )
                )
        );

        PolygonCalculator polygonCalculator = PolygonCalculatorCreator.create(line);

        Assertions.assertTrue(() -> polygonCalculator instanceof LineCalculator);
    }

    @Test
    void triangleCalculatorCreate() {
        Triangle triangle = Triangle.create(
                Coordinates.create(
                        List.of(
                                Coordinate.create(10, 11),
                                Coordinate.create(12, 13),
                                Coordinate.create(14, 15)
                        )
                )
        );

        PolygonCalculator polygonCalculator = PolygonCalculatorCreator.create(triangle);

        Assertions.assertTrue(() -> polygonCalculator instanceof TriangleCalculator);
    }

    @Test
    void squareCalculatorCreate() {
        Square square = Square.create(
                Coordinates.create(
                        List.of(
                                Coordinate.create(10, 10),
                                Coordinate.create(22, 10),
                                Coordinate.create(22, 18),
                                Coordinate.create(10, 18)
                        )
                )
        );

        PolygonCalculator polygonCalculator = PolygonCalculatorCreator.create(square);

        Assertions.assertTrue(() -> polygonCalculator instanceof SquareCalculator);
    }
}