package domain;

public class Line implements Polygon {

    private static final int VALID_COORDINATE_SIZE = 2;

    private final Coordinates coordinates;

    public Line(Coordinates coordinates) {
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
}
