package controller;

import view.input.InputExceptionHandler;

import java.util.function.Supplier;

public class RetryHandler {

    private final InputExceptionHandler inputExceptionHandler;

    public RetryHandler(InputExceptionHandler inputExceptionHandler) {
        this.inputExceptionHandler = inputExceptionHandler;
    }

    public <T> T retry(Supplier<T> tryAction, Supplier<T> retryAction) {
        try {
            return tryAction.get();
        } catch (IllegalArgumentException e) {
            this.inputExceptionHandler.writeErrorMessage(e);
            return retryAction.get();
        }
    }

}
