package input.dto;

import domain.Coordinates;
import util.CollectionUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class CoordinateInput {
    private final List<Coordinate> coordinates;

    public CoordinateInput(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates toDomainCoordinates() {
        return Coordinates.create(
                this.coordinates.stream()
                        .map(Coordinate::toDomain)
                        .toList()
        );
    }

    public List<Coordinate> getCoordinates() {
        return List.copyOf(this.coordinates);
    }

    public boolean isCoordinatesSizeBetween(int inclusiveMin, int inclusiveMax) {
        return this.isCoordinatesSizeGreaterEqualThan(inclusiveMin) && this.isCoordinatesSizeLessEqualThan(inclusiveMax);
    }

    public boolean isCoordinatesRange(int inclusiveMin, int inclusiveMax) {
        return !CollectionUtil.isEmpty(this.coordinates) &&
                coordinates.stream()
                        .allMatch(coordinate -> coordinate.isBetweenCoordinates(inclusiveMin, inclusiveMax));
    }

    public boolean hasSameCoordinate() {
        return new HashSet<>(this.coordinates).size() != this.coordinates.size();
    }

    private boolean isCoordinatesSizeLessEqualThan(int max) {
        return this.coordinates.size() <= max;
    }

    private boolean isCoordinatesSizeGreaterEqualThan(int min) {
        return this.coordinates.size() >= min;
    }

    public static class Coordinate {

        private final int xCoordinate;

        private final int yCoordinate;

        public Coordinate(int xCoordinate, int yCoordinate) {
            this.xCoordinate = xCoordinate;
            this.yCoordinate = yCoordinate;
        }

        private boolean isBetweenCoordinates(int min, int max) {
            return this.isBetweenXCoordinate(min, max) && this.isBetweenYCoordinate(min, max);
        }

        private boolean isBetweenXCoordinate(int inclusiveMin, int inclusiveMax) {
            return this.xCoordinate >= inclusiveMin && this.xCoordinate <= inclusiveMax;
        }

        private boolean isBetweenYCoordinate(int inclusiveMin, int inclusiveMax) {
            return this.yCoordinate >= inclusiveMin && this.yCoordinate <= inclusiveMax;
        }


        public domain.Coordinate toDomain() {
            return domain.Coordinate.create(this.xCoordinate, this.yCoordinate);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return xCoordinate == that.xCoordinate && yCoordinate == that.yCoordinate;
        }

        @Override
        public int hashCode() {
            return Objects.hash(xCoordinate, yCoordinate);
        }
    }
}
