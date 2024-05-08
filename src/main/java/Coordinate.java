import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;

public class Coordinate {
    private static final int MINIMUM_POINT_VALUE = 0;
    private static final int MAXIMUM_POINT_VALUE = 24;
    private static final int MINIMUM_COORDINATE_SIZE = 2;
    private static final int MAXIMUM_COORDINATE_SIZE = 4;
    private final List<Point> points;

    public List<Point> getPoints() {
        return points;
    }

    public Coordinate(String userInput) {
        this.points = validateFormat(userInput);
        validateRangeOfPoints(this.points);
        validateNumberOfCoordinates(this.points);
        validateIfRectangleInCase4Points(this.points);
    }

    private void validateNumberOfCoordinates(List<Point> points) {
        if (points.size() < MINIMUM_COORDINATE_SIZE || points.size() > MAXIMUM_COORDINATE_SIZE ) {
            throw new IllegalArgumentException("좌표는 최소 2개 이상, 4개 이하까지 입력가능합니다.");
        }
    }

    private void validateIfRectangleInCase4Points(List<Point> points) {
        if (points.size() != 4) {
            return;
        }
        points.sort(Comparator.comparing(Point::getPointX).thenComparing(Point::getPointY));

        if (isRectangle(points)) return;

        throw new IllegalArgumentException("직사각형이 아닙니다.");
    }

    private boolean isRectangle(List<Point> points) {
        Point bottomLeft = points.get(0);
        Point topLeft = points.get(1);
        Point bottomRight = points.get(2);
        Point topRight = points.get(3);

        double side1 = Utils.calculateDistance(bottomLeft, topLeft);
        double side2 = Utils.calculateDistance(bottomLeft, bottomRight);
        double side3 = Utils.calculateDistance(topRight, topLeft);
        double side4 = Utils.calculateDistance(topRight, bottomRight);

        double diagonal1 = Utils.calculateDistance(bottomLeft, topRight);
        double diagonal2 = Utils.calculateDistance(topLeft, bottomRight);

        //직사각형은 마주보는 두 변의 합이 같고 대각선의 길이가 같다.
        if (side1 == side4 && side2 == side3 && diagonal1 == diagonal2) {
            return true;
        }
        return false;
    }

    private void validateRangeOfPoints(List<Point> points) {
        for (Point point : points) {
            validateCoordinate(point.getPointX());
            validateCoordinate(point.getPointY());
        }
    }

    private void validateCoordinate(double value) {
        if (value < MINIMUM_POINT_VALUE || value > MAXIMUM_POINT_VALUE) {
            throw new IllegalArgumentException("X, Y 좌표의 범위는 최소 0, 최대 24입니다.");
        }
    }

    private List<Point> validateFormat(String userInput) {
        String noWhiteSpaceUserInput = userInput.replaceAll("\\s", "");
        throwIfInputEndsWithDash(noWhiteSpaceUserInput);
        List<Point> points = createPoints(noWhiteSpaceUserInput);
        throwIfPointsIsEmpty(points.isEmpty());
        return points;
    }

    private void throwIfPointsIsEmpty(boolean points) {
        if (points) {
            throw new IllegalArgumentException("좌표가 존재하지 않습니다.");
        }
    }

    private void throwIfInputEndsWithDash(String noWhiteSpaceUserInput) {
        String regexDash = ".*-$";
        if (noWhiteSpaceUserInput.matches(regexDash)){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private List<Point> createPoints(String noWhiteSpaceUserInput) {
        String[] coordinatePairs = noWhiteSpaceUserInput.split("-");

        List<Point> points = new ArrayList<>();
        String regex = "\\(([^,]+),([^)]+)\\)";

        for (String pair : coordinatePairs) {

            throwIfPairIsEmpty(pair.isEmpty());

            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
            Matcher matcher = pattern.matcher(pair);

            createPointIfPairMatchesPattern(points, matcher);
        }
        return points;
    }

    private void createPointIfPairMatchesPattern(List<Point> points, Matcher matcher) {
        if (matcher.matches()) {
            try {
                double x = Double.parseDouble(matcher.group(1));
                double y = Double.parseDouble(matcher.group(2));
                points.add(new Point(x, y));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자 형식이 잘못되었습니다.");
            }
        } else {
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }
    }

    private void throwIfPairIsEmpty(boolean pair) {
        if (pair) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
