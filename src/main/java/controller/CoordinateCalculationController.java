package controller;

import model.CoordinateCalculationResult;
import model.DistinguishedCoordinates;
import model.coordinatecalculation.CoordinateCalculator;
import view.result.ResultView;
import view.input.InputView;

public class CoordinateCalculationController {

    private final InputView inputView;
    private final ResultView resultView;
    private final CoordinateCalculator calculator;

    private CoordinateCalculationController(
            final InputView inputView,
            final ResultView resultView,
            final CoordinateCalculator calculator
    ) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.calculator = calculator;
    }

    public static CoordinateCalculationController defaultOf(final InputView inputView, final ResultView resultView) {
        return new CoordinateCalculationController(inputView, resultView, CoordinateCalculator.switchOnOf());
    }

    public void run() {
        while (this.calculator.isSwitchOn()) {
            welcomeUser();

            final CoordinateCalculationResult result = calculate();

            resultView.showResult(result);

            checkUserWantToFinish();
        }

        resultView.showCalculationFinishedMessage();
    }

    private CoordinateCalculationResult calculate() {
        final DistinguishedCoordinates coordinates = inputView.inputCoordinates();
        return calculator.calculate(coordinates);
    }

    private void welcomeUser() {
        this.inputView.welcome();
    }

    private void checkUserWantToFinish() {
        if (userWantToFinish()) {
            this.calculator.switchOff();
        }
    }

    private boolean userWantToFinish() {
        return inputView.inputUserIntentionToContinueCalculation().wantToFinish();
    }

}
