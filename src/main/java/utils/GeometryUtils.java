package utils;

import model.Point;

import static utils.MathUtils.square;

public class GeometryUtils {

    private GeometryUtils() {
    }

    public static double calculateDistance(Point first, Point second) {
        return Math.sqrt(square(first.calculateDistanceByX(second)) + square(first.calculateDistanceByY(second)));
    }

}
