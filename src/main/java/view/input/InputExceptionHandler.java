package view.input;

import view.ConsoleWriter;

import java.util.Objects;
import java.util.function.Supplier;

public class InputExceptionHandler {

    private final ConsoleWriter consoleWriter;

    public InputExceptionHandler(ConsoleWriter consoleWriter) {
        this.consoleWriter = consoleWriter;
    }

    public <T> T input(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            writeErrorMessage(e);
            return input(supplier);
        }
    }

    private void writeErrorMessage(IllegalArgumentException e) {
        consoleWriter.writeLineWithPromptPrefix(toExceptionMessageFormat(e.getMessage()));
    }

    private String toExceptionMessageFormat(final String message) {
        final String errorPrefix = "[ERROR] 잘못된 입력입니다. ";

        if (Objects.isNull(message)) {
            return errorPrefix;
        }

        return errorPrefix + message;
    }

}
