import java.util.Arrays;
import java.util.List;

public class CoordinateRequest {

	private final List<PointRequest> pointRequests;

	public CoordinateRequest(final List<PointRequest> pointRequests) {
		this.pointRequests = pointRequests;
	}

	public static CoordinateRequest from(final String coordinates) {
		final String[] split = coordinates.split("-");
		final List<PointRequest> pointRequests1 = Arrays.stream(split)
			.map(coordinate -> {
				final String[] parts = coordinate.substring(1, coordinate.length() - 1).split(",");
				return new PointRequest(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
			})
			.toList();
		return new CoordinateRequest(pointRequests1);
	}

	public List<Point> toPoint() {
		return pointRequests.stream()
			.map(PointRequest::toPoint)
			.toList();
	}

	public int fetchCoordinateCount() {
		return this.pointRequests.size();
	}
}
