import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @DisplayName("주어진 좌표들로 사각형의 넓이를 구한다.")
    @Test
    void calculateSquareArea() {
        Calculator calculator = new Calculator();
        List<Point> points = new ArrayList<>();
        points.add(new Point(10, 10));
        points.add(new Point(22, 10));
        points.add(new Point(22, 18));
        points.add(new Point(10, 18));

        String expectedResult = "사각형 넓이는 96.0";
        String result = calculator.calculateArea(points);
        assertEquals(result,expectedResult);
    }

    @DisplayName("주어진 좌표들로 삼각형의 넓이를 구한다.")
    @Test
    void calculateTriangleArea() {
        Calculator calculator = new Calculator();
        List<Point> points = new ArrayList<>();
        points.add(new Point(10, 10));
        points.add(new Point(14, 15));
        points.add(new Point(20, 8));

        String expectedResult = "삼각형 넓이는 28.999999999999996";
        String result = calculator.calculateArea(points);
        assertEquals(result,expectedResult);
    }


    @DisplayName("주어진 좌표들의 거리를 구한다.")
    @Test
    void calculateDistance() {
        Calculator calculator = new Calculator();
        List<Point> points = new ArrayList<>();
        points.add(new Point(10, 10));
        points.add(new Point(14, 15));

        String expectedResult = "두 점 사이 거리는 6.4031242374328485";
        String result = calculator.calculateArea(points);
        assertEquals(result,expectedResult);
    }




}