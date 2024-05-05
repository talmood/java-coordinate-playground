package service;

import util.Console;

public class RetryCoordinateCalculatorProxy implements CoordinateCalculator {

    private static final String RETRY_NAVIGATION = "> 계산을 계속하시겠습니까?";
    private final CoordinateCalculator coordinateCalculator;

    public RetryCoordinateCalculatorProxy(CoordinateCalculator coordinateCalculator) {
        this.coordinateCalculator = coordinateCalculator;
    }

    @Override
    public void calculate() {

        coordinateCalculator.calculate();

        System.out.println(RETRY_NAVIGATION);
        String isRetry = Console.readLine();
        System.out.println();

        if (isRetry.equals("yes")) {
            this.calculate();
        }

        if (isRetry.equals("no")) {
            return;
        }
    }
}
