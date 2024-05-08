public class Point {

	private final int x;
	private final int y;

	private Point(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	public static Point of(final int x, final int y) {
		return new Point(x, y);
	}
}
