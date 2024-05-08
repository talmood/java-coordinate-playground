package view.input;

import model.DistinguishedCoordinates;
import model.Point;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputCoordinates {

    private static final Pattern COORDINATES_LITERAL_PATTERN =
            Pattern.compile("^\\(-?\\d+,-?\\d+\\)(-\\(-?\\d+,-?\\d+\\))*$");

    private static final Pattern SINGLE_POINT_LITERAL_PATTERN =
            Pattern.compile("\\((-?\\d+),(-?\\d+)\\)");

    private final List<Point> points;

    private InputCoordinates(List<Point> points) {
        this.points = points;
    }

    public static InputCoordinates fromString(String coordinatesLiteral) {
        if (Objects.isNull(coordinatesLiteral)) {
            throw new IllegalArgumentException();
        }

        if (!COORDINATES_LITERAL_PATTERN.matcher(coordinatesLiteral).matches()) {
            throw new IllegalArgumentException();
        }

        return new InputCoordinates(convertToPoints(coordinatesLiteral));
    }

    private static List<Point> convertToPoints(String coordinatesLiteral) {
        final Matcher matcher = SINGLE_POINT_LITERAL_PATTERN.matcher(coordinatesLiteral);
        return matcher.results()
                .map(matchResult ->
                        new Point(
                                Integer.parseInt(matchResult.group(1)),
                                Integer.parseInt(matchResult.group(2))
                        )
                )
                .toList();
    }

    public DistinguishedCoordinates toDistinguishedCoordinates() {
        return new DistinguishedCoordinates(getPoints());
    }

    public List<Point> getPoints() {
        return List.copyOf(this.points);
    }

}
