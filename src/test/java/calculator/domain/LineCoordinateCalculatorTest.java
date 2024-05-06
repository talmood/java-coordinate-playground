package calculator.domain;

import calculator.controller.request.LineCoordinateRequest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class LineCoordinateCalculatorTest {
	@Test
	void 두_좌표_간_직선_거리_계산하기() {
		LineCoordinateRequest coordinateRequest = LineCoordinateRequest.from("(10,10)-(14,15)");
		CoordinateCalculator sut = LineCoordinateCalculator.from(coordinateRequest);

		double actual = sut.calculate();

		assertThat(actual).isEqualTo(6.403124, offset(0.00099));
	}
}