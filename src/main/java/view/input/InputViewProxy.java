package view.input;

import model.DistinguishedCoordinates;
import view.UserIntentionToContinueCalculation;

public class InputViewProxy implements InputView{

    private final InputExceptionHandler exceptionHandler;
    private final InputViewImpl inputView;

    public InputViewProxy(InputExceptionHandler exceptionHandler, InputViewImpl inputView) {
        this.exceptionHandler = exceptionHandler;
        this.inputView = inputView;
    }

    @Override
    public DistinguishedCoordinates inputCoordinates() {
        return exceptionHandler.input(inputView::inputCoordinates);
    }

    @Override
    public UserIntentionToContinueCalculation inputUserIntentionToContinueCalculation() {
        return exceptionHandler.input(inputView::inputUserIntentionToContinueCalculation);
    }

    @Override
    public void welcome() {
        this.inputView.welcome();
    }

}
