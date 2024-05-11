import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public enum ShapeStrategy {

	LINE(2, Line::new),
	TRIANGLE(3, Triangle::new),
	SQUARE(4, Square::new),
	;

	private final int coordinateCount;
	private final Function<List<Point>, Shape> expression;

	ShapeStrategy(final int coordinateCount, final Function<List<Point>, Shape> expression) {
		this.coordinateCount = coordinateCount;
		this.expression = expression;
	}

	public static Shape getShape(final CoordinateRequest coordinateRequest) {
		return Arrays.stream(values())
			.filter(shapeStrategy -> shapeStrategy.coordinateCount == coordinateRequest.fetchCoordinateCount())
			.findFirst()
			.map(shapeStrategy -> shapeStrategy.expression.apply(coordinateRequest.toPoint()))
			.orElseThrow(() -> new IllegalArgumentException("[ERROR] 좌표 개수를 확인해 주세요."));
	}
}
