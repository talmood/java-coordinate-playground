package model;

import utils.CollectionUtils;

import java.util.List;
import java.util.Objects;

public final class Coordinates {

    private final List<Point> points;

    public Coordinates(final List<Point> points) {
        if (CollectionUtils.isEmpty(points)) {
            throw new IllegalArgumentException("좌표값 리스트는 비어있을 수 없습니다.");
        }
        this.points = points;
    }

    public boolean sizeEquals(final int size) {
        if (Objects.isNull(this.points)) {
            return false;
        }
        return this.points.size() == size;
    }

    public Point fetchPointByIndex(final int index) {
        validateSizeGreaterThanOrEqualTo(index + 1);
        return this.points.get(index);
    }

    private void validateSizeGreaterThanOrEqualTo(final int size) {
        if (!(this.points.size() >= size)) {
            throw new IllegalArgumentException("좌표값 리스트의 크기가 size=%d 미만입니다.".formatted(size));
        }
    }

    public List<Point> getPoints() {
        return List.copyOf(this.points);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Coordinates) obj;
        return Objects.equals(this.points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

}
