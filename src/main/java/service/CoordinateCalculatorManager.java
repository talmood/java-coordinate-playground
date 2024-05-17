package service;

public class CoordinateCalculatorManager {
    private static final String START_CALCULATE_NAVIGATION = "> 계산을 시작합니다. \n";
    private static final String END_CALCULATE_NAVIGATION = "> 계산을 종료합니다.";

    public void execute() {
        System.out.println(START_CALCULATE_NAVIGATION);

        CoordinateCalculator coordinateCalculator = CoordinateCalculatorCreator.createWithExceptionHandling();
        coordinateCalculator.calculate();

        System.out.println(END_CALCULATE_NAVIGATION);
    }
}
