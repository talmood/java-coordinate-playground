package point;

import common.utils.Combination;

import java.util.ArrayList;
import java.util.List;

public class PointManager {
    private List<Point> points = new ArrayList<>();

    public void createPoint(final List<String> preprocessPoints){
        this.points = preprocessPoints.stream().map(preprocessPoint->{
            String[] splitPoint = preprocessPoint.split(",");
            return new Point(
                    convertStringToInt(splitPoint[0]),
                    convertStringToInt(splitPoint[1]));
        }).toList();
        validate();
    }

    public List<Point> getPoints() {
        return points;
    }

    private void validate(){
        validUniquePoint();
        points.forEach(this::validMaxPoint);
    }

    private void validMaxPoint(final Point point){
        if(point.getX() < 0 || point.getY() >24){
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. X, Y 좌표의 범위는 최소 0, 최대 24입니다.");
        }
    }

    private void validUniquePoint(){
        int[] nums = {points.size(),2};
        List<List<Integer>> combinations = Combination.combine(nums);
        combinations.forEach(combination->{
            points.get(combination.get(0)).validateSamePoint(points.get(combination.get(1)));
        });
    }

    private int convertStringToInt(final String inputValue){
        try {
            return Integer.parseInt(inputValue);
        }catch (Exception e){
            throw new IllegalArgumentException("입력값이 숫자가 아닙니다.");
        }
    }
}
