import java.util.List;

public class Square implements Shape {

	private final List<Point> points;

	public Square(final List<Point> points) {
		validate(points);
		this.points = points;
	}

	private void validate(final List<Point> points) {
		validateFourCoordinate(points);
	}

	private void validateFourCoordinate(final List<Point> points) {
		if (points.size() != 4) {
			throw new IllegalArgumentException("[ERROR] 사각형의 좌표는 네 개가 존재해야 합니다.");
		}
	}

	@Override
	public double calculateCoordinate() {
		double width = Math.abs(points.get(0).getX() - points.get(1).getX());
		double height = Math.abs(points.get(0).getY() - points.get(3).getY());

		return width * height;
	}

	@Override
	public int getCoordinateCount() {
		return this.points.size();
	}
}
