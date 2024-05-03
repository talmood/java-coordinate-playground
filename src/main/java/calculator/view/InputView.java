package calculator.view;

import calculator.controller.request.LineCoordinateRequest;
import calculator.utils.Console;

public class InputView {
	private static final String INPUT_START_CALCULATE_MESSAGE = "계산을 시작합니다.";
	private static final String INPUT_COORDINATE_MESSAGE = "좌표를 입력하세요.";

	static {
		System.out.println(INPUT_START_CALCULATE_MESSAGE);
	}

	public static LineCoordinateRequest inputLineCoordinate() {
		System.out.println(INPUT_COORDINATE_MESSAGE);
		try {
			return LineCoordinateRequest.from(Console.readLine());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputLineCoordinate();
		}
	}
}
