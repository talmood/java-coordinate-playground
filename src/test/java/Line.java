import java.util.List;

public class Line {

	private final List<Point> points;

	public Line(final List<Point> points) {
		validateTwoCoordinate(points);
		this.points = points;
	}

	private void validateTwoCoordinate(final List<Point> points) {
		if (points.size() != 2) {
			throw new IllegalArgumentException("[ERROR] 선의 좌표는 두 개가 존재해야 합니다.");
		}
	}

	public double calculateCoordinate() {
		final Point a = points.get(0);
		final Point b = points.get(1);

		return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
	}
}
