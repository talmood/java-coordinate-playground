package view.input;

import model.DistinguishedCoordinates;
import view.ConsoleWriter;
import view.InputReader;
import view.UserIntentionToContinueCalculation;

public class InputViewImpl implements InputView {

    private final InputReader inputReader;
    private final ConsoleWriter consoleWriter;

    public InputViewImpl(InputReader inputReader, ConsoleWriter consoleWriter) {
        this.inputReader = inputReader;
        this.consoleWriter = consoleWriter;
    }

    public DistinguishedCoordinates inputCoordinates() {
        consoleWriter.writeLineWithPromptPrefix("좌표를 입력하세요.");
        return InputCoordinates.fromString(inputReader.readLine()).toDistinguishedCoordinates();
    }

    public UserIntentionToContinueCalculation inputUserIntentionToContinueCalculation() {
        consoleWriter.writeLineWithPromptPrefix("계산을 계속하시겠습니까?");
        return new UserIntentionToContinueCalculation(inputReader.readLine());
    }

    @Override
    public void welcome() {
        consoleWriter.writeLineWithPromptPrefix("계산을 시작합니다.");
    }

}
