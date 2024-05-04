import calculator.domain.CoordinateCalculator;
import calculator.domain.LineCoordinateCalculator;
import calculator.view.InputView;

public class Application {

	public static void main(String[] args) {
		CoordinateCalculator lineCoordinateCalculator = new LineCoordinateCalculator();
		lineCoordinateCalculator.calculate(InputView.inputLineCoordinate());
	}

}
