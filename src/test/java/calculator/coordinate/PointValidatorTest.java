package calculator.coordinate;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PointValidatorTest {
	private static final String ERROR_MESSAGE_WRONG_X_RANGE = "[ERROR] 잘못된 입력입니다. x 좌표값의 범위는 최소 0, 최대 24입니다.";
	private static final String ERROR_MESSAGE_WRONG_Y_RANGE = "[ERROR] 잘못된 입력입니다. y 좌표값의 범위는 최소 0, 최대 24입니다.";

	@Test
	void 좌표_입력_검증_x_값이_범위_이상인_경우() {
		int x = 25;
		int y = 0;

		IllegalArgumentException actual = assertThrows(IllegalArgumentException.class, () -> {
			PointValidator.validatePoint(x, y);
		});

		assertThat(actual.getMessage()).isEqualTo(ERROR_MESSAGE_WRONG_X_RANGE);
	}

	@Test
	void 좌표_입력_검증_y_값이_범위_이상인_경우() {
		int x = 0;
		int y = 25;

		IllegalArgumentException actual = assertThrows(IllegalArgumentException.class, () -> {
			PointValidator.validatePoint(x, y);
		});

		assertThat(actual.getMessage()).isEqualTo(ERROR_MESSAGE_WRONG_Y_RANGE);
	}
}