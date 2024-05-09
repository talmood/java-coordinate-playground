package shape;

import point.Point;

import java.util.List;

public class ShapeManager {
    public Shape createShape(final List<Point> points){
        if (points.size() == 2){
            return new Line(points.get(0), points.get(1));
        }
        if(points.size() ==3){
            return new Triangle(points.get(0), points.get(1), points.get(2));
        }
        if(points.size() ==4){
            return new Line(points.get(0), points.get(1));
        }
        throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. 좌표는 최소 2개 이상, 4개 이하까지 입력가능합니다.");
    }
}
