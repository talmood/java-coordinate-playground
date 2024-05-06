package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import output.dto.TriangleCalculateOutput;

import java.util.List;

class TriangleCalculatorTest {

    @Test
    void calculate() {
        Coordinates coordinates = Coordinates.create(
                List.of(
                        Coordinate.create(10, 10),
                        Coordinate.create(14, 15),
                        Coordinate.create(20, 8)
                )
        );

        Triangle triangle = Triangle.create(coordinates);
        TriangleCalculator triangleCalculator = new TriangleCalculator();
        TriangleCalculateOutput output = (TriangleCalculateOutput) triangleCalculator.calculate(triangle);

        double expected = 29.0f;

        Assertions.assertEquals(expected, output.getRoundedResult(), 0.1);
    }
}