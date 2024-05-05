package calculator.view;

public class ResultView {
	private static final String LINE_COORDINATE_RESULT_MESSAGE = "두 점 사이 거리는 %f";
	private static final String RECTANGLE_COORDINATE_RESULT_MESSAGE = "사각형 넓이는 %f";
	private static final String TRIANGLE_COORDINATE_RESULT_MESSAGE = "삼각형 넓이는 %f";

	public static void printLineCoordinateResult(final double calculateResult) {
		System.out.println(LINE_COORDINATE_RESULT_MESSAGE.formatted(calculateResult));
	}

	public static void printRectangleCoordinateResult(final double calculateResult) {
		System.out.println(RECTANGLE_COORDINATE_RESULT_MESSAGE.formatted(calculateResult));
	}

	public static void printTriangleCoordinateResult(final double calculateResult) {
		System.out.println(TRIANGLE_COORDINATE_RESULT_MESSAGE.formatted(calculateResult));
	}
}
