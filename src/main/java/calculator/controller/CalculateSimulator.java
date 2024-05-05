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
		CoordinateCalculator lineCoordinateCalculator = new LineCoordinateCalculator();
		ResultView.printLineCoordinateResult(
			lineCoordinateCalculator.calculate(InputView.inputLineCoordinate())
		);
	}

	private static void runRectangleCoordinateCalculator() {
		CoordinateCalculator rectangleCoordinateCalculator = new RectangleCoordinateCalculator();
		ResultView.printRectangleCoordinateResult(
			rectangleCoordinateCalculator.calculate(InputView.inputRectangleCoordinate())
		);
	}

	private static void runTriangleCoordinateCalculator() {
		CoordinateCalculator triangleCoordinateCalculator = new TriangleCoordinateCalculator();
		ResultView.printTriangleCoordinateResult(
			triangleCoordinateCalculator.calculate(InputView.inputTriangleCoordinate())
		);
	}

	private static boolean askToContinue() {
		if (!InputView.isCalculateContinue()) {
			System.out.println(END_MESSAGE);
			return false;
		}
		return true;
	}
}
