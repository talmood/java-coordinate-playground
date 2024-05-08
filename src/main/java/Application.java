import java.util.List;

public class Application {

	public static void main(String[] args) {
		InputView inputView = new InputView();
		Processor processor = new Processor();

		inputView.printStartMessage();

		do {
			processor.calculateAreaFromInput(inputView);
		} while (inputView.decideRetry());

		inputView.closeScanner();
	}

}
