package dto;

import java.util.List;

public class CoordinateUserInput {
    private final List<Coordinate> coordinates;

    public CoordinateUserInput(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public static class Coordinate {

        private final int xCoordinate;

        private final int yCoordinate;

        public Coordinate(int xCoordinate, int yCoordinate) {
            this.xCoordinate = xCoordinate;
            this.yCoordinate = yCoordinate;
        }
    }
}
