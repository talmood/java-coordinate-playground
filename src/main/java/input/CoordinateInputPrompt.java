package input;

import input.dto.ConsoleInput;
import util.Console;

public class CoordinateInputPrompt implements InputPrompt {

    private static final String INPUT_COORDINATE_NAVIGATION_STRING = "> 좌표를 입력하세요.";

    @Override
    public ConsoleInput prompt() {
        System.out.println(INPUT_COORDINATE_NAVIGATION_STRING);
        String userInput = Console.readLine();
        System.out.println();

        ConsoleInput coordinateConsoleInput = CoordinateInputPatternMatcher.match(userInput);
        CoordinateInputValidChecker coordinateInputValidChecker = new CoordinateInputValidChecker();
        coordinateInputValidChecker.check(coordinateConsoleInput);

        return coordinateConsoleInput;
    }
}
