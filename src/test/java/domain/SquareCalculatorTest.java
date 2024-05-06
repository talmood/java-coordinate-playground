package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import output.dto.SquareCalculateOutput;

import java.util.List;

class SquareCalculatorTest {

    @Test
    void calculate() {
        Coordinates coordinates = Coordinates.create(
                List.of(
                        Coordinate.create(10, 10),
                        Coordinate.create(22, 10),
                        Coordinate.create(22, 18),
                        Coordinate.create(10, 18)
                )
        );

        Square square = Square.create(coordinates);
        SquareCalculator squareCalculator = new SquareCalculator();
        SquareCalculateOutput output = (SquareCalculateOutput) squareCalculator.calculate(square);

        int expected = 96;

        Assertions.assertEquals(expected, output.getResult());
    }

}