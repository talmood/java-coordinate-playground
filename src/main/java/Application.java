import domain.Polygon;
import domain.PolygonCreator;
import dto.CoordinateUserInput;
import input.CoordinateInputPrompt;
import input.InputPrompt;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        InputPrompt inputPrompt = new CoordinateInputPrompt();
        CoordinateUserInput userInput = inputPrompt.prompt();
        Polygon polygon = PolygonCreator.create(userInput.toCoordinates());

    }

}
