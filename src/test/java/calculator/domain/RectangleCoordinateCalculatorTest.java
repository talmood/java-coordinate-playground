package calculator.domain;

import calculator.controller.request.RectangleCoordinateRequest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RectangleCoordinateCalculatorTest {

	@Test
	void 직사각형_면적_구하기() {
		RectangleCoordinateRequest coordinateRequest = RectangleCoordinateRequest.from("(10,10)-(22,10)-(22,18)-(10,18)");
		CoordinateCalculator sut = new RectangleCoordinateCalculator();

		double actual = sut.calculate(coordinateRequest);

		assertThat(actual).isEqualTo(96);
	}
}