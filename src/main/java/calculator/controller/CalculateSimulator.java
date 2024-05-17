package calculator.controller;

import calculator.domain.CoordinateCalculator;
import calculator.domain.LineCoordinateCalculator;
import calculator.domain.RectangleCoordinateCalculator;
import calculator.domain.TriangleCoordinateCalculator;
import calculator.view.InputView;
import calculator.view.ResultView;

public class CalculateSimulator {
	private static final String END_MESSAGE = "계산을 종료합니다.";

	public static void runCalculator() {
		runLineCoordinateCalculator();
		if (!askToContinue()) {
			return;
		}
		runRectangleCoordinateCalculator();
		if (!askToContinue()) {
			return;
		}
		runTriangleCoordinateCalculator();
		System.out.println(END_MESSAGE);
	}

	private static void runLineCoordinateCalculator() {
		CoordinateCalculator lineCoordinateCalculator = LineCoordinateCalculator.from(InputView.inputLineCoordinate());
		ResultView.printLineCoordinateResult(lineCoordinateCalculator.calculate());
	}

	private static void runRectangleCoordinateCalculator() {
		CoordinateCalculator rectangleCoordinateCalculator = RectangleCoordinateCalculator.from(InputView.inputRectangleCoordinate());
		ResultView.printRectangleCoordinateResult(rectangleCoordinateCalculator.calculate());
	}

	private static void runTriangleCoordinateCalculator() {
		CoordinateCalculator triangleCoordinateCalculator = TriangleCoordinateCalculator.from(InputView.inputTriangleCoordinate());
		ResultView.printTriangleCoordinateResult(triangleCoordinateCalculator.calculate());
	}

	private static boolean askToContinue() {
		if (!InputView.isCalculateContinue()) {
			System.out.println(END_MESSAGE);
			return false;
		}
		return true;
	}
}
