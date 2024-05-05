package input;

import dto.ConsoleInput;

public class ConsoleInputPrompt implements InputPrompt {

    private static final String START_CALCULATE_NAVIGATION = "> 계산을 시작합니다. \n";

    @Override
    public ConsoleInput prompt() {
        System.out.println(START_CALCULATE_NAVIGATION);
        InputPrompt inputPrompt = InputPromptCreator.createExceptionHandlingCoordinate();

        return inputPrompt.prompt();
    }
}
