public class OutputView {

	private static final String LINE_MESSAGE = "두 점 사이 거리는 ";
	private static final String TRIANGLE_MESSAGE = "삼각형의 넓이는 ";
	private static final String SQUARE_MESSAGE = "사각형의 넓이는 ";

	public static void printResult(final Shape shape) {
		System.out.println("> 실행 결과");
		if (shape.getCoordinateCount() == 2) {
			System.out.println(LINE_MESSAGE + shape.calculateCoordinate());
		}
		if (shape.getCoordinateCount() == 3) {
			System.out.println(TRIANGLE_MESSAGE + shape.calculateCoordinate());
		}
		if (shape.getCoordinateCount() == 4) {
			System.out.println(SQUARE_MESSAGE + shape.calculateCoordinate());
		}
	}
}
