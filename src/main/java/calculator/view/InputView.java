package calculator.view;

import calculator.ErrorMessage;
import calculator.Points;
import calculator.Scanner;
import calculator.model.Point;
import calculator.utils.Splitter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {

    private static final String SINGLE_COORDINATE_PATTERN = "\\(\\d+,\\d+\\)*";
    private static final String MULTIPLE_COORDINATE_PATTERN = "\\(\\d+,\\d+\\)(?:-\\(\\d+,\\d+\\))*";

    public static Points inputCoordinates() {
        System.out.println("좌표를 입력하세요.");
        final String input = Scanner.readLine();
        final String trimedInput = input.replaceAll("\\s+", "");

        final Points points = generatePoints(trimedInput);
        return points;
    }

    private static Points generatePoints(final String input) {

        final List<Point> points = new ArrayList<>();
        
        if (!input.matches(MULTIPLE_COORDINATE_PATTERN)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT);
        }
        
        Splitter.split(input).stream()
                .map(InputView::generatePoint)
                .forEach(points::add);

        return Points.from(points);
    }

    private static Point generatePoint(final String pointStr) {
        if (!pointStr.matches(SINGLE_COORDINATE_PATTERN)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT);
        }

        final Matcher matcher = Pattern.compile("(\\d+),(\\d+)").matcher(pointStr);

        if (!matcher.find()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT);
        }

        final int x = Integer.parseInt(matcher.group(1));
        final int y = Integer.parseInt(matcher.group(2));

        return Point.of(x, y);
    }

    public static boolean continueCalculation() {
        System.out.println("계산을 계속하시겠습니까? (yes/no)");
        String answer = Scanner.readLine();
        return answer.equalsIgnoreCase("yes");
    }
}