package domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Square implements Polygon {

    private static final int VALID_COORDINATE_SIZE = 4;
    private final Coordinates coordinates;

    private Square(Coordinates coordinates) {
        this.coordinates = coordinates;
    }


    public static Square create(Coordinates coordinates) {
        validateCoordinateSize(coordinates);
        validateRectangle(coordinates);
        return new Square(coordinates);
    }

    private static void validateCoordinateSize(Coordinates coordinates) {
        if (!coordinates.isEqualSize(VALID_COORDINATE_SIZE)) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] 사각형의 좌표는 %d개 여야 합니다.", VALID_COORDINATE_SIZE)
            );
        }
    }

    private static void validateRectangle(Coordinates coordinates) {
        if (!isRectangle(coordinates)) {
            throw new IllegalArgumentException("[ERROR] 사각형은 직사각형이어야 합니다.");
        }
    }

    private static boolean isRectangle(Coordinates coordinates) {
        List<Coordinate> points = coordinates.toList();
        List<Double> sideLengths = IntStream.range(0, 4)
                .mapToObj(index -> {
                    int dx = points.get((index + 1) % 4).getxCoordinate() - points.get(index).getxCoordinate();
                    int dy = points.get((index + 1) % 4).getyCoordinate() - points.get(index).getyCoordinate();
                    return Math.pow(dx, 2) + Math.pow(dy, 2);
                })
                .toList();

        return Objects.equals(sideLengths.get(0), sideLengths.get(2)) &&
                Objects.equals(sideLengths.get(1), sideLengths.get(3));
    }

    public int calculateArea() {
        List<Coordinate> pointers = this.coordinates.toList();
        int width = 0;
        int height = 0;

        int x = pointers.get(0).getxCoordinate();
        int y = pointers.get(1).getyCoordinate();

        for (Coordinate pointer : pointers) {
            if (x != pointer.getxCoordinate()) {
                width = Math.abs(x - pointer.getxCoordinate());
            }

            if (y != pointer.getyCoordinate()) {
                height = Math.abs(y - pointer.getyCoordinate());
            }
        }

        return width * height;
    }
}
