public class Application {

	public static void main(String[] args) {
		// TODO: 미션 구현
		final CoordinateRequest coordinateRequest = InputView.inputCoordinate();
		final Shape shape = ShapeStrategy.getShape(coordinateRequest);
		OutputView.printResult(shape);
	}

}
