package domain;

import java.util.List;

public class Square implements Polygon {

    private static final int VALID_COORDINATE_SIZE = 4;
    private final Coordinates coordinates;

    private Square(Coordinates coordinates) {
        this.coordinates = coordinates;
    }


    public static Square create(Coordinates coordinates) {
        validateCoordinateSize(coordinates);

        return new Square(coordinates);
    }

    private static void validateCoordinateSize(Coordinates coordinates) {
        if (!coordinates.isEqualSize(VALID_COORDINATE_SIZE)) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] 사각형의 좌표는 %d개 여야 합니다.", VALID_COORDINATE_SIZE)
            );
        }
    }

    public int calculateArea() {
        List<Coordinate> pointers = this.coordinates.toList();
        Coordinate point1 = pointers.get(0);
        Coordinate point2 = pointers.get(1);
        Coordinate point3 = pointers.get(2);
        Coordinate point4 = pointers.get(3);

        int width = this.calculateDistance(point1, point2);

        int height = this.calculateDistance(point1, point4);

        return width * height;
    }

    private int calculateDistance(Coordinate point1, Coordinate point2) {
        return Math.abs(point2.getxCoordinate()) - point1.getxCoordinate() *
                Math.abs(point2.getyCoordinate() - point1.getyCoordinate());
    }
}
