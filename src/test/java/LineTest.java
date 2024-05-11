import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.offset;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LineTest {

	@Test
	void 선을_생성하는_경우_좌표는_두_개만_가능하다() {
		assertThatThrownBy(() -> new Line(List.of(Point.of(1, 2))))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 선의 좌표는 두 개가 존재해야 합니다.");
	}

	@Test
	void 두_점_사이의_거리를_계산한다() {
		final Point a = Point.of(10, 10);
		final Point b = Point.of(14, 15);
		final Line sut = new Line(List.of(a, b));

		final double actual = sut.calculateCoordinate();

		assertThat(actual).isEqualTo(6.403, offset(0.00099));
	}
}
