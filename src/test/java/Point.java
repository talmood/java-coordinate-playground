public class Point {

	private final int x;
	private final int y;

	private Point(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	public static Point of(final int x, final int y) {
		validateCoordinateRange(x, y);
		return new Point(x, y);
	}

	private static void validateCoordinateRange(final int x, final int y) {
		if (x < 0 || x > 24) {
			throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. X, Y 좌표의 범위는 최소 0, 최대 24입니다.");
		}
		if (y < 0 || y > 24) {
			throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. X, Y 좌표의 범위는 최소 0, 최대 24입니다.");
		}
	}
}
