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

	@ValueSource(ints = {0, 24})
	@ParameterizedTest
	void Y_좌표는_0부터_24까지만_지정할_수_있다(final int y) {
		assertDoesNotThrow(() -> Point.of(12, y));
	}
}
