package calculator.view;

import calculator.controller.request.LineCoordinateRequest;
import calculator.controller.request.RectangleCoordinateRequest;
import calculator.controller.request.TriangleCoordinateRequest;
import calculator.utils.Console;

public class InputView {
	private static final String INPUT_START_CALCULATE_MESSAGE = "계산을 시작합니다.";
	private static final String INPUT_COORDINATE_MESSAGE = "좌표를 입력하세요.";
	private static final String CONTINUE_MESSAGE = "계산을 계속하시겠습니까?";
	private static final String CONTINUE_INPUT = "yes";

	public static LineCoordinateRequest inputLineCoordinate() {
		System.out.println(INPUT_START_CALCULATE_MESSAGE);
		System.out.println(INPUT_COORDINATE_MESSAGE);
		try {
			return LineCoordinateRequest.from(Console.readLine());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputLineCoordinate();
		}
	}

	public static RectangleCoordinateRequest inputRectangleCoordinate() {
		System.out.println(INPUT_COORDINATE_MESSAGE);
		try {
			return RectangleCoordinateRequest.from(Console.readLine());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputRectangleCoordinate();
		}
	}

	public static TriangleCoordinateRequest inputTriangleCoordinate() {
		System.out.println(INPUT_COORDINATE_MESSAGE);
		try {
			return TriangleCoordinateRequest.from(Console.readLine());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputTriangleCoordinate();
		}
	}

	public static boolean isCalculateContinue() {
		System.out.println(CONTINUE_MESSAGE);
		return Console.readLine().equals(CONTINUE_INPUT);
	}
}
