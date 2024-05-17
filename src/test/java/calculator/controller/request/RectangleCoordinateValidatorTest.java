package calculator.controller.request;

import calculator.coordinate.Point;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RectangleCoordinateValidatorTest {
	static final String ERROR_MESSAGE = "[ERROR] 잘못된 입력입니다.";
	private static final String WRONG_INPUT_COORDINATE_COUNT = " 사각형 좌표는 네 개를 입력해야 합니다.";
	private static final String WRONG_RECTANGLE = " 사각형 좌표는 직사각형만 허용합니다.";

	@Test
	void 사각형_좌표_입력_검증_좌표_개수가_잘못된_경우() {
		String pointInputs = "(1,2)-(3,4)-(5,6)";

		IllegalArgumentException actual = assertThrows(IllegalArgumentException.class, () -> {
			RectangleCoordinateValidator.validatePointInput(pointInputs);
		});
		assertThat(actual.getMessage()).isEqualTo(ERROR_MESSAGE + WRONG_INPUT_COORDINATE_COUNT);
	}

	@Test
	void 사각형_좌표_입력_검증_직사각형_좌표가_아닌_경우() {
		Point firstPoint = Point.of(1, 2);
		Point secondPoint = Point.of(3, 4);
		Point thirdPoint = Point.of(5, 6);
		Point fourthPoint = Point.of(7, 8);

		IllegalArgumentException actual = assertThrows(IllegalArgumentException.class, () -> {
			RectangleCoordinateValidator.validateRectangle(firstPoint, secondPoint, thirdPoint, fourthPoint);
		});
		assertThat(actual.getMessage()).isEqualTo(ERROR_MESSAGE + WRONG_RECTANGLE);
	}

}