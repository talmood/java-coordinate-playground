package calculator.utils;

import calculator.model.Point;

public class PointUtils {

    private PointUtils() {}

    public static double distance(Point p1, Point p2) {
        double deltaX = (double) p2.getX() - p1.getX();
        double deltaY = (double) p2.getY() - p1.getY();

        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }

    public static boolean isOnLine(Point p1, Point p2, Point p3) {
        // 직선의 방정식: (y - y1) / (y2 - y1) = (x - x1) / (x2 - x1)
        return (p3.getY() - p1.getY()) * (p2.getX() - p1.getX()) == (p2.getY() - p1.getY()) * (p3.getX() - p1.getX());
    }
}