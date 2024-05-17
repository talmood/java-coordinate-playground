package domain;

import java.util.List;

public class Line implements Polygon {

    private static final int VALID_COORDINATE_SIZE = 2;

    private final Coordinates coordinates;

    private Line(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public static Line create(Coordinates coordinates) {
        validateCoordinateSize(coordinates);

        return new Line(coordinates);
    }

    private static void validateCoordinateSize(Coordinates coordinates) {
        if (!coordinates.isEqualSize(VALID_COORDINATE_SIZE)) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] 선의 좌표는 %d개 여야 합니다.", VALID_COORDINATE_SIZE)
            );
        }
    }

    public double calculateDistance() {
        List<Coordinate> pointers = this.coordinates.toList();
        Coordinate firstPointer = pointers.get(0);
        Coordinate secondPointer = pointers.get(1);

        return Math.sqrt(
                this.square(firstPointer.getxCoordinate() - secondPointer.getxCoordinate()) +
                        this.square(firstPointer.getyCoordinate() - secondPointer.getyCoordinate())
        );
    }

    private double square(int number) {
        return Math.pow(number, 2);
    }
}
