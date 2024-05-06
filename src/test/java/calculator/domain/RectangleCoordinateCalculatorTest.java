package calculator.domain;

import calculator.controller.request.RectangleCoordinateRequest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RectangleCoordinateCalculatorTest {

	@Test
	void 직사각형_면적_구하기() {
		RectangleCoordinateRequest coordinateRequest = RectangleCoordinateRequest.from("(10,10)-(22,10)-(22,18)-(10,18)");
		CoordinateCalculator sut = RectangleCoordinateCalculator.from(coordinateRequest);

		double actual = sut.calculate();

		assertThat(actual).isEqualTo(96);
	}
}