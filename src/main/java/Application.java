import controller.CoordinateCalculationController;
import view.ConsoleReader;
import view.ConsoleWriter;
import view.result.ResultView;
import view.input.InputExceptionHandler;
import view.input.InputView;
import view.input.InputViewImpl;
import view.input.InputViewProxy;

public class Application {

	private Application() {
	}

	public static void main(String[] args) {
		initializeController().run();
	}

	private static CoordinateCalculationController initializeController() {
		final InputExceptionHandler exceptionHandler = new InputExceptionHandler(ConsoleWriter.getInstance());
		final InputViewImpl inputViewImpl = new InputViewImpl(new ConsoleReader(), ConsoleWriter.getInstance());

		final InputView inputView = new InputViewProxy(exceptionHandler, inputViewImpl);
		final ResultView resultView = new ResultView(ConsoleWriter.getInstance());

		return CoordinateCalculationController.defaultOf(inputView, resultView);
	}

}
