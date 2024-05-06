package input;

import input.dto.CoordinateInput;
import util.PatternUtil;
import util.StringUtil;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoordinateInputPatternMatcher {

    private static final String USER_INPUT_REGEX = "\\(\\d+,\\d+\\)(-\\(\\d+,\\d+\\))*";
    private static final String PATTERN_COMPILE_REGEX = "\\((\\d+),(\\d+)\\)";

    public static CoordinateInput match(String userInput) {
        validate(userInput);

        Pattern pattern = Pattern.compile(PATTERN_COMPILE_REGEX);
        Matcher matcher = pattern.matcher(userInput);

        ArrayList<CoordinateInput.Coordinate> coordinates = new ArrayList<>();

        while (matcher.find()) {
            String xIndex = matcher.group(1);
            String yIndex = matcher.group(2);

            coordinates.add(new CoordinateInput.Coordinate(Integer.parseInt(xIndex), Integer.parseInt(yIndex)));
        }

        return new CoordinateInput(coordinates);
    }

    private static void validate(String userInput) {
        if (!isValidUserInput(userInput)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
    }

    private static boolean isValidUserInput(String userInput) {
        return !StringUtil.isEmpty(userInput) && PatternUtil.matches(USER_INPUT_REGEX, userInput);
    }
}
