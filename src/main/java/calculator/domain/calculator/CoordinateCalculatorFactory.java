package calculator.domain.calculator;

import calculator.utils.ErrorMessage;
import calculator.domain.point.Point;
import calculator.domain.point.Points;

import java.util.List;

public class CoordinateCalculatorFactory {

    public static CoordinateCalculator createCalculator(final Points points) {
        List<Point> pointList = points.getPoints();
        int numberOfPoints = pointList.size();

        if (numberOfPoints == 2) {return LineCalculator.of(pointList);}
        if (numberOfPoints == 3) {return TriangleCalculator.of(pointList);}
        if (numberOfPoints == 4) {return RectangleCalculator.of(pointList);}

        throw new IllegalArgumentException(ErrorMessage.INVALID_CALCULATOR);
    }

}