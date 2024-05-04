package input;

import dto.CoordinateUserInput;
import util.PatternUtil;
import util.StringUtil;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoordinateUserInputPatternMatcher {

    private static final String USER_INPUT_REGEX = "\\(\\d+,\\d+\\)(-\\(\\d+,\\d+\\))*";
    private static final String PATTERN_COMPILE_REGEX = "\\((\\d+),(\\d+)\\)";

    public static CoordinateUserInput match(String userInput) {
        validCheck(userInput);

        Pattern pattern = Pattern.compile(PATTERN_COMPILE_REGEX);
        Matcher matcher = pattern.matcher(userInput);

        ArrayList<CoordinateUserInput.Coordinate> coordinates = new ArrayList<>();

        while (matcher.find()) {
            String xIndex = matcher.group(1);
            String yIndex = matcher.group(2);

            coordinates.add(new CoordinateUserInput.Coordinate(Integer.parseInt(xIndex), Integer.parseInt(yIndex)));
        }

        return new CoordinateUserInput(coordinates);
    }

    private static void validCheck(String userInput) {
        if (!isValidUserInput(userInput)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
    }

    private static boolean isValidUserInput(String userInput) {
        return !StringUtil.isEmpty(userInput) && PatternUtil.isMatches(USER_INPUT_REGEX, userInput);
    }
}
