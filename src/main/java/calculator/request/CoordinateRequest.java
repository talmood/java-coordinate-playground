package calculator.request;

import calculator.utils.ErrorMessage;
import calculator.domain.point.Points;
import calculator.domain.point.Point;
import calculator.utils.DashSplitter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoordinateRequest {

    private static final String COORDINATE_PATTERN = "(\\d+),(\\d+)";

    private final String coordinateInput;

    private CoordinateRequest(final String coordinateInput) {
        this.coordinateInput = coordinateInput;
    }

    public static CoordinateRequest from(final String coordinateInput) {
        CoordinateRequestValidator.validate(coordinateInput);
        return new CoordinateRequest(coordinateInput);
    }

    public Points generatePoints() {
        final List<Point> points = DashSplitter.split(coordinateInput).stream()
                .map(this::generatePoint)
                .toList();

        return Points.from(points);
    }

    private Point generatePoint(final String point) {
        final Matcher matcher = Pattern.compile(COORDINATE_PATTERN).matcher(point);

        if (!matcher.find()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT);
        }

        final int x = Integer.parseInt(matcher.group(1));
        final int y = Integer.parseInt(matcher.group(2));

        return Point.of(x, y);
    }

}
