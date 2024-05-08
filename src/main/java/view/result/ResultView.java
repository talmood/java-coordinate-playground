package view.result;

import model.CoordinateCalculationResult;
import view.ConsoleWriter;

public class ResultView {

    private final ConsoleWriter consoleWriter;

    public ResultView(ConsoleWriter consoleWriter) {
        this.consoleWriter = consoleWriter;
    }

    public void showResult(CoordinateCalculationResult result) {
        consoleWriter.writeLine(CoordinateCalculationResultFormatter.format(result));
    }

    public void showCalculationFinishedMessage() {
        consoleWriter.writeLineWithPromptPrefix("> 계산을 종료합니다.");
    }

}
