package shape;

import common.utils.Combination;
import point.Point;

import java.util.ArrayList;
import java.util.List;

public class Triangle implements Shape {
    final private List<Point> points = new ArrayList<>();

    public Triangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        points.add(firstPoint);
        points.add(secondPoint);
        points.add(thirdPoint);
    }

    @Override
    public double calculate() {
        int[] nums = {3,2};
        List<List<Integer>> combinations = Combination.combine(nums);
        List<Line> lines = combinations.stream().map(combination -> {
            return new Line(points.get(combination.get(0)), points.get(combination.get(1)));
        }).toList();
        List<Double> lineLength = lines.stream().map(Line::calculate).toList();
        double result = HeronFunction(lineLength.get(0), lineLength.get(1), lineLength.get(2));
        System.out.printf("실행 결과\n삼각형 넓이는 %s%n",result);
        return result;
    }


    private double HeronFunction(final double a, final double b, final double c){
        return Math.round(Math.sqrt((a+b+c)*(-a+b+c)*(a-b+c)*(a+b-c))*0.25);
    }
}
