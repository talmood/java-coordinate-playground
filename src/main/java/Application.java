import service.CoordinateCalculator;
import service.CoordinateCalculatorCreator;

public class Application {

    private static final String START_CALCULATE_NAVIGATION = "> 계산을 시작합니다. \n";

    public static void main(String[] args) {
        System.out.println(START_CALCULATE_NAVIGATION);
        CoordinateCalculator coordinateCalculator = CoordinateCalculatorCreator.createRetryable();
        coordinateCalculator.calculate();
    }
}
