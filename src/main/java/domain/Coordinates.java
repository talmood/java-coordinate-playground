package domain;

import java.util.HashSet;
import java.util.List;

public class Coordinates {

    private final List<Coordinate> coordinates;

    private Coordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public static Coordinates create(List<Coordinate> coordinates) {
        validateHasSameCoordinates(coordinates);

        return new Coordinates(coordinates);
    }

    private static void validateHasSameCoordinates(List<Coordinate> coordinates) {
        if (hasSameCoordinate(coordinates)) {
            throw new IllegalArgumentException("[ERROR] 겹치는 좌표가 존재합니다.");
        }
    }

    private static boolean hasSameCoordinate(List<Coordinate> coordinates) {
        return new HashSet<>(coordinates).size() != coordinates.size();
    }

    public boolean isEqualSize(int size) {
        return this.coordinates.size() == size;
    }

}
