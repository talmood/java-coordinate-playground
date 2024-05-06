package model;

import java.util.List;
import java.util.Objects;

public final class Coordinates {

    private final List<Point> points;

    public Coordinates(
            List<Point> points
    ) {
        this.points = points;
    }

    public boolean sizeEquals(int size) {
        if (Objects.isNull(this.points)) {
            return false;
        }
        return this.points.size() == size;
    }

    public List<Point> getPoints() {
        return List.copyOf(this.points);
    }

}
