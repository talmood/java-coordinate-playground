package dto;

import domain.Coordinates;

import java.util.List;

public class CoordinateUserInput {
    private final List<Coordinate> coordinates;

    public CoordinateUserInput(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates toCoordinates() {
        return Coordinates.create(this.coordinates.stream()
                .map(Coordinate::toDomain)
                .toList());
    }

    public static class Coordinate {

        private final int xCoordinate;

        private final int yCoordinate;

        public Coordinate(int xCoordinate, int yCoordinate) {
            this.xCoordinate = xCoordinate;
            this.yCoordinate = yCoordinate;
        }

        public domain.Coordinate toDomain() {
            return domain.Coordinate.create(this.xCoordinate, this.yCoordinate);
        }
    }
}
