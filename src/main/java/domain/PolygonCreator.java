package domain;

public class PolygonCreator {

    private static final int LINE_COORDINATES_SIZE = 2;
    private static final int TRIANGLE_COORDINATES_SIZE = 3;
    private static final int SQUARE_COORDINATES_SIZE = 4;

    public static Polygon create(Coordinates coordinates) {
        if (coordinates.isEqualSize(LINE_COORDINATES_SIZE)) {
            return Line.create(coordinates);
        }

        if (coordinates.isEqualSize(TRIANGLE_COORDINATES_SIZE)) {
            return Triangle.create(coordinates);
        }

        if (coordinates.isEqualSize(SQUARE_COORDINATES_SIZE)) {
            return Square.create(coordinates);
        }

        throw new IllegalArgumentException("[ERROR] 좌표 갯수에 맞는 도형이 없습니다.");
    }
}
