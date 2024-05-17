package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import output.dto.LineCalculateOutput;

import java.util.List;

class LineCalculatorTest {

    @Test
    void calculate() {
        Coordinates coordinates = Coordinates.create(
                List.of(
                        Coordinate.create(10, 10),
                        Coordinate.create(14, 15)
                )
        );
        Line line = Line.create(coordinates);

        LineCalculator lineCalculator = new LineCalculator();
        LineCalculateOutput output = (LineCalculateOutput) lineCalculator.calculate(line);

        double expected = 6.403124f;

        Assertions.assertEquals(expected, output.getRoundedResult(), 0.000001);
    }
}