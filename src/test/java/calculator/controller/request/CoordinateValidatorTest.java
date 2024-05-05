package calculator.controller.request;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CoordinateValidatorTest {
	static final String ERROR_MESSAGE = "[ERROR] 잘못된 입력입니다.";
	private static final String WRONG_INPUT_POINT = " 좌표 입력 형태는 괄호'()'로 둘러쌓여 있고 쉼표 ','로 x값과 y값을 구분해야 합니다.";

	@Test
	void 좌표_입력_검증하기_좌표_간_연결이_잘못된_경우() {
		String pointInputs = "(1,2) (3,4)";

		IllegalArgumentException actual = assertThrows(IllegalArgumentException.class, () -> {
			CoordinateValidator.validatePointInputSplit(pointInputs);
		});

		assertThat(actual.getMessage()).isEqualTo(ERROR_MESSAGE);
	}

	@Test
	void 좌표_입력_검증하기_형식이_다른_경우() {
		String[] pointInputs = {"[1,2]", "[3,4]"};

		IllegalArgumentException actual = assertThrows(IllegalArgumentException.class, () -> {
			CoordinateValidator.validateMatchPointRegex(pointInputs);
		});
		assertThat(actual.getMessage()).isEqualTo(ERROR_MESSAGE + WRONG_INPUT_POINT);
	}

	@Test
	void 좌표_입력_검증하기_영문자로_입력한_경우() {
		String[] pointInputs = {"[1,a]", "[2,b]"};

		IllegalArgumentException actual = assertThrows(IllegalArgumentException.class, () -> {
			CoordinateValidator.validateMatchPointRegex(pointInputs);
		});
		assertThat(actual.getMessage()).isEqualTo(ERROR_MESSAGE + WRONG_INPUT_POINT);
	}
}