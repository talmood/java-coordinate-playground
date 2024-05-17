package shape;

import common.utils.Combination;
import point.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Square implements Shape {
    final private List<Point> points = new ArrayList<>();
    private double result;

    public Square(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint) {
        points.add(firstPoint);
        points.add(secondPoint);
        points.add(thirdPoint);
        points.add(fourthPoint);
        points.sort(Point::compareTo);
    }


    @Override
    public double calculate() {
        int[] nums = {4,2};
        List<List<Integer>> combinations = Combination.combine(nums);
        List<Line> lines = combinations.stream().map(combination -> {
            return new Line(points.get(combination.get(0)), points.get(combination.get(1)));
        }).toList();
        List<Double> lineLength = lines.stream().map(Line::calculate).toList();
        validationRectangle(lineLength);
        result = lineLength.get(0) * lineLength.get(1);
        return result;
    }

    @Override
    public void displayResult() {
        System.out.printf("실행 결과\n사각형 넓이는 %s%n",result);
    }

    private void validationRectangle(final List<Double> lineLength){
        final HashMap<Double,Integer> counter = new HashMap<>();
        lineLength.forEach(length->{
            if(!counter.containsKey(length)){
                counter.put(length,0);
            }
            counter.put(length, counter.get(length)+1);
        });
        counter.keySet().forEach(key->{
            if(counter.get(key) !=2){
                throw new IllegalArgumentException("해당 사각형은 직사각형이 아닙니다.");
            }
        });
    }
}
