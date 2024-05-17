package calculator.controller;

import calculator.domain.calculator.CoordinateCalculator;
import calculator.domain.calculator.CoordinateCalculatorFactory;
import calculator.domain.point.Points;
import calculator.request.CoordinateRequest;
import calculator.view.InputView;

public class CoordinateCalculatorManager {

    private CoordinateCalculatorManager() {
    }

    public static void run() {
        InputView.printCalculateStartMessage();

        boolean continueCalculation = true;
        while (continueCalculation) {
            try {
                performCalculation();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            continueCalculation = InputView.isContinueCalculation();
        }

        InputView.printCalculateEndMessage();
    }

    private static void performCalculation() {
        final CoordinateRequest coordinateRequest = InputView.inputCoordinates();
        final Points points = coordinateRequest.generatePoints();
        final CoordinateCalculator calculator = CoordinateCalculatorFactory.createCalculator(points);
        calculator.printCalculateResult();
    }
}
