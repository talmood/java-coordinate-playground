package domain;

public class Coordinate {

    private final int xCoordinate;

    private final int yCoordinate;

    private Coordinate(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public static Coordinate create(int xCoordinate, int yCoordinate) {
        return new Coordinate(xCoordinate, yCoordinate);
    }
}
