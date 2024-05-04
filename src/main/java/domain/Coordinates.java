package domain;

import java.util.List;

public class Coordinates {

    private final List<Coordinate> coordinates;

    private Coordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public static Coordinates create(List<Coordinate> coordinates) {
        return new Coordinates(coordinates);
    }

    public boolean isEqualSize(int size) {
        return this.coordinates.size() == size;
    }
}
