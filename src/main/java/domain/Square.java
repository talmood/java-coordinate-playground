package domain;

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
                    String.format("[ERROR] 선의 좌표는 %d개 여야 합니다.", VALID_COORDINATE_SIZE)
            );
        }
    }
}
