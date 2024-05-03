import dto.CoordinateUserInput;
import util.PatternUtil;
import util.StringUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    private static final String REGEX = "\\(\\d+,\\d+\\)(-\\(\\d+,\\d+\\))*";

    public static void main(String[] args) throws IOException {
        System.out.println("> 좌표를 입력하세요.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = reader.readLine();

        if (StringUtil.isEmpty(userInput) || !PatternUtil.isMatches(REGEX, userInput)) {
            throw new IllegalArgumentException(String.format("[userInput:%s] user input is invalid", userInput));
        }

        Pattern pattern = Pattern.compile("\\((\\d+),(\\d+)\\)");
        Matcher matcher = pattern.matcher(userInput);

        ArrayList<CoordinateUserInput.Coordinate> coordinates = new ArrayList<>();

        while (matcher.find()) {
            String xIndex = matcher.group(1);
            String yIndex = matcher.group(2);

            coordinates.add(new CoordinateUserInput.Coordinate(Integer.parseInt(xIndex), Integer.parseInt(yIndex)));
        }

        CoordinateUserInput coordinateUserInput = new CoordinateUserInput(coordinates);
        
    }

}
