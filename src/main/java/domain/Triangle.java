package domain;

public class Triangle implements Polygon {

    private static final int VALID_COORDINATE_SIZE = 3;

    private final Coordinates coordinates;

    public Triangle(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public static Triangle create(Coordinates coordinates) {
        validateCoordinateSize(coordinates);

        return new Triangle(coordinates);
    }

    private static void validateCoordinateSize(Coordinates coordinates) {
        if (!coordinates.isEqualSize(VALID_COORDINATE_SIZE)) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] 선의 좌표는 %d개 여야 합니다.", VALID_COORDINATE_SIZE)
            );
        }
    }
}
