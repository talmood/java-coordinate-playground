public class Application {

	public static void main(String[] args) {

		InputView inputView = new InputView();
		Processor processor = new Processor();

		inputView.printStartMessage();
		inputView.printGuideInputMessage();

		processor.calculateAreaByCoordination(inputView.acceptInput());

	}

}
