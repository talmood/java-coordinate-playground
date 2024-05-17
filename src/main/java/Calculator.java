import java.util.Comparator;
import java.util.List;

public class Calculator {
    public String calculateArea (List<Point> points) {
        int numberOfCoordinates = points.size();
        if (numberOfCoordinates == 2) {
            return "두 점 사이 거리는 " + Utils.calculateDistance(points.get(0), points.get(1));
        }
        if (numberOfCoordinates == 3) {
            return "삼각형 넓이는 " + calculateTriangleArea(points);
        }
        if (numberOfCoordinates == 4) {
            return  "사각형 넓이는 " + calculateSquareArea(points);
        }
        throw new IllegalArgumentException("좌표는 최소 2개 이상, 4개 이하까지 입력가능합니다.");
    }

    private Double calculateSquareArea(List<Point> points) {
        points.sort(Comparator.comparing(Point::getPointX).thenComparing(Point::getPointY));

        Point bottomLeft = points.get(0);
        Point topLeft = points.get(1);
        Point bottomRight = points.get(2);

        Double sideLeft = Utils.calculateDistance(bottomLeft, topLeft);
        Double sideDown = Utils.calculateDistance(bottomLeft, bottomRight);

        return sideLeft * sideDown;
    }

    private Double calculateTriangleArea(List<Point> points) {
        Point pointA = points.get(0);
        Point pointB = points.get(1);
        Point pointC = points.get(2);

        Double sideA = Utils.calculateDistance(pointB, pointC);
        Double sideB = Utils.calculateDistance(pointA, pointC);
        Double sideC = Utils.calculateDistance(pointA, pointB);

        Double s = (sideA + sideB + sideC)/2;
        return Math.sqrt(s * (s-sideA) * (s-sideB) * (s-sideC));
    }
}
