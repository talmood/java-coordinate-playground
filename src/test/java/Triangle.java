import java.util.List;

public class Triangle implements Shape {

	private final List<Point> points;

	public Triangle(final List<Point> points) {
		validate(points);
		this.points = points;
	}

	private void validate(final List<Point> points) {
		validateThreeCoordinate(points);
	}

	private void validateThreeCoordinate(final List<Point> points) {
		if (points.size() != 4) {
			throw new IllegalArgumentException("[ERROR] 삼각형의 좌표는 세 개가 존재해야 합니다.");
		}
	}

	@Override
	public double calculateCoordinate() {
		double a = calculateDistance(points.get(0), points.get(1));
		double b = calculateDistance(points.get(1), points.get(2));
		double c = calculateDistance(points.get(2), points.get(0));

		double s = (a + b + c) / 2;

		return Math.sqrt(s * (s - a) * (s - b) * (s - c));
	}

	@Override
	public int getCoordinateCount() {
		return this.points.size();
	}

	private double calculateDistance(final Point p1, final Point p2) {
		return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
	}
}
