package input;

import dto.CoordinateUserInput;
import util.Console;

public class CoordinateInputPrompt implements InputPrompt {
    private static final String INPUT_COORDINATE_NAVIGATION_STRING = "> 좌표를 입력하세요.";

    @Override
    public CoordinateUserInput prompt() {
        System.out.println(INPUT_COORDINATE_NAVIGATION_STRING);
        String userInput = Console.readLine();

        CoordinateUserInput coordinateUserInput = CoordinateUserInputPatternMatcher.match(userInput);
        CoordinateUserInputValidChecker coordinateUserInputValidChecker = new CoordinateUserInputValidChecker();
        coordinateUserInputValidChecker.check(coordinateUserInput);

        return coordinateUserInput;
    }
}
