import domain.Polygon;
import domain.PolygonCreator;
import dto.CoordinateUserInput;
import input.CoordinateInputPrompt;
import input.InputPrompt;

public class Application {

    public static void main(String[] args) {
        InputPrompt inputPrompt = new CoordinateInputPrompt();
        CoordinateUserInput userInput = inputPrompt.prompt();
        Polygon polygon = PolygonCreator.create(userInput.toDomainCoordinates());

    }

}
