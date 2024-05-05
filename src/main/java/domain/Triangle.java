package domain;

import java.util.List;

public class Triangle implements Polygon {

    private static final int VALID_COORDINATE_SIZE = 3;

    private final Coordinates coordinates;

    private Triangle(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public static Triangle create(Coordinates coordinates) {
        validateCoordinateSize(coordinates);

        return new Triangle(coordinates);
    }

    private static void validateCoordinateSize(Coordinates coordinates) {
        if (!coordinates.isEqualSize(VALID_COORDINATE_SIZE)) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] 삼각형의 좌표는 %d개 여야 합니다.", VALID_COORDINATE_SIZE)
            );
        }
    }

    public double calculateArea() {
        List<Coordinate> pointers = this.coordinates.toList();
        Coordinate pointer1 = pointers.get(0);
        Coordinate pointer2 = pointers.get(1);
        Coordinate pointer3 = pointers.get(2);

        double side1 = calculateDistance(pointer1, pointer2);
        double side2 = calculateDistance(pointer2, pointer3);
        double side3 = calculateDistance(pointer3, pointer1);

        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    private double calculateDistance(Coordinate point1, Coordinate point2) {
        return Math.sqrt(this.square(point2.getxCoordinate() - point1.getxCoordinate()) +
                this.square(point2.getyCoordinate() - point1.getyCoordinate()));
    }

    private double square(int number) {
        return Math.pow(number, 2);
    }
}
