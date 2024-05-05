import service.CoordinateCalculator;
import service.CoordinateCalculatorCreator;

public class Application {

    public static void main(String[] args) {
        CoordinateCalculator coordinateCalculator = CoordinateCalculatorCreator.createRetryable();
        coordinateCalculator.calculate();
    }
}
