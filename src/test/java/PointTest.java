import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PointTest {

	@ValueSource(ints = {0, 24})
	@ParameterizedTest
	void X_좌표는_0부터_24까지만_지정할_수_있다(final int x) {
		assertDoesNotThrow(() -> Point.of(x, 12));
	}

	@ValueSource(ints = {-1, 25})
	@ParameterizedTest
	void X_좌표는_0보다_작거나_24보다_큰_수를_지정할_수_없다(final int x) {
		assertThatThrownBy(() -> Point.of(x, 12))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 잘못된 입력입니다. X, Y 좌표의 범위는 최소 0, 최대 24입니다.");
	}

	@ValueSource(ints = {0, 24})
	@ParameterizedTest
	void Y_좌표는_0부터_24까지만_지정할_수_있다(final int y) {
		assertDoesNotThrow(() -> Point.of(12, y));
	}

	@ValueSource(ints = {-1, 25})
	@ParameterizedTest
	void Y_좌표는_0보다_작거나_24보다_큰_수를_지정할_수_없다(final int y) {
		assertThatThrownBy(() -> Point.of(12, y))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 잘못된 입력입니다. X, Y 좌표의 범위는 최소 0, 최대 24입니다.");
	}
}
