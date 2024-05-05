package calculator.domain;

import calculator.controller.request.TriangleCoordinateRequest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TriangleCoordinateCalculatorTest {
	@Test
	void 삼각형_면적_구하기() {
		TriangleCoordinateRequest coordinateRequest = TriangleCoordinateRequest.from("(0,0)-(10,0)-(0,5)");
		CoordinateCalculator sut = new TriangleCoordinateCalculator();

		double actual = sut.calculate(coordinateRequest);

		assertThat(actual).isEqualTo(25);
	}
}