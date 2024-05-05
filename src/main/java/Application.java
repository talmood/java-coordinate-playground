import domain.Polygon;
import domain.PolygonCreator;
import input.ConsoleInputPrompt;
import input.InputPrompt;
import input.dto.ConsoleInput;

public class Application {

    public static void main(String[] args) {
        InputPrompt inputPrompt = new ConsoleInputPrompt();
        ConsoleInput consoleInput = inputPrompt.prompt();

        Polygon polygon = PolygonCreator.create(consoleInput.toDomainCoordinates());

    }

}
