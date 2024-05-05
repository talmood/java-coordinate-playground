package calculator.controller.request;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleCoordinateValidatorTest {
	static final String ERROR_MESSAGE = "[ERROR] 잘못된 입력입니다.";
	private static final String WRONG_INPUT_COORDINATE_COUNT = " 삼각형 좌표는 세 개를 입력해야 합니다.";

	@Test
	void 삼각형_좌표_입력_검증_좌표_개수가_잘못된_경우() {
		String pointInputs = "(1,2)-(3,4)";

		IllegalArgumentException actual = assertThrows(IllegalArgumentException.class, () -> {
			TriangleCoordinateValidator.validatePointInput(pointInputs);
		});
		assertThat(actual.getMessage()).isEqualTo(ERROR_MESSAGE + WRONG_INPUT_COORDINATE_COUNT);
	}
}