package model;

import utils.CollectionUtils;

import java.util.List;
import java.util.Objects;

public final class DistinguishedCoordinates {

    private final List<Point> points;

    public DistinguishedCoordinates(final List<Point> points) {
        if (CollectionUtils.isEmpty(points)) {
            throw new IllegalArgumentException("좌표값 리스트는 비어있을 수 없습니다.");
        }

        validateAllDistinguishable(points);

        this.points = points;
    }

    private void validateAllDistinguishable(List<Point> points) {
        final long distinguishedPointsSize = points.stream().distinct().count();

        if (distinguishedPointsSize != points.size()) {
            throw new IllegalArgumentException("겹치는 좌표가 존재합니다.");
        }
    }

    public boolean matchesSize(final int size) {
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

    public int size() {
        return this.points.size();
    }

    public List<Point> getPoints() {
        return List.copyOf(this.points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DistinguishedCoordinates that = (DistinguishedCoordinates) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

}
