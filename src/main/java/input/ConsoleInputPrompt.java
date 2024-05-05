package input;

import input.dto.ConsoleInput;

public class ConsoleInputPrompt implements InputPrompt {

    @Override
    public ConsoleInput prompt() {
        InputPrompt inputPrompt = InputPromptCreator.createExceptionHandlingCoordinate();

        return inputPrompt.prompt();
    }
}
