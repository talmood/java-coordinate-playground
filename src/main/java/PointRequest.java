public class PointRequest {

	private final int x;
	private final int y;

	PointRequest(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	Point toPoint() {
		return Point.of(x, y);
	}
}
