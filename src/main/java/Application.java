import java.util.List;

public class Application {

	public static void main(String[] args) {

		InputView inputView = new InputView();
		Processor processor = new Processor();

		inputView.printStartMessage();

		do {
			inputView.printGuideInputMessage();
			List<Point> points = inputView.validateCoordinates();
			processor.calculateAreaByCoordinates(points);

		} while (inputView.decideRetry());

		inputView.closeScanner();
	}

}
