package calculator.model.shapes;

import calculator.ErrorMessage;
import calculator.Points;
import calculator.model.Point;

import java.util.List;

public class ShapeFactory {

    public static Shape createShape(final Points points) {
        List<Point> pointList = points.getPoints();
        int numberOfPoints = pointList.size();

        if (numberOfPoints == 2) {return Line.of(pointList);}
        if (numberOfPoints == 3) {return Triangle.of(pointList);}
        if (numberOfPoints == 4) {return Rectangle.of(pointList);}

        throw new IllegalArgumentException(ErrorMessage.INVALID_SHAPE);
    }

}