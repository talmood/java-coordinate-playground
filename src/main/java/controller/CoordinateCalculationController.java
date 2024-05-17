package controller;

import model.CoordinateCalculationResult;
import model.DistinguishedCoordinates;
import model.coordinatecalculation.CoordinateCalculator;
import view.input.InputView;
import view.result.ResultView;

public class CoordinateCalculationController {

    private final InputView inputView;
    private final ResultView resultView;
    private final CoordinateCalculator calculator;
    private final RetryHandler retryHandler;

    private CoordinateCalculationController(
            final InputView inputView,
            final ResultView resultView,
            final CoordinateCalculator calculator,
            final RetryHandler retryHandler
    ) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.calculator = calculator;
        this.retryHandler = retryHandler;
    }

    public static CoordinateCalculationController defaultOf(
            final InputView inputView,
            final ResultView resultView,
            RetryHandler retryHandler
    ) {
        return new CoordinateCalculationController(
                inputView,
                resultView,
                CoordinateCalculator.switchOnOf(),
                retryHandler
        );
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
        DistinguishedCoordinates coordinates = inputView.inputCoordinates();
        return this.retryHandler.retry(() -> this.calculator.calculate(coordinates), this::calculate);
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
