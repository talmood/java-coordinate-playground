package shape;

import point.Point;

public class Line implements Shape {
    private Point firstPoint;
    private Point secondPoint;

    public Line(Point firstPoint, Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    @Override
    public double calculate() {
        double distanceX = Math.pow(this.firstPoint.getX() - this.secondPoint.getX(), 2);
        double distanceY = Math.pow(this.firstPoint.getY() - this.secondPoint.getY(), 2);
        double result = Math.sqrt(distanceX + distanceY);
        System.out.printf("실행 결과\n두 점 사이 거리는 %s%n",result);
        return result;
    }
}
