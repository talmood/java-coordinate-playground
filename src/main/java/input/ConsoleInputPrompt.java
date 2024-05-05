package input;

import input.dto.ConsoleInput;

public class ConsoleInputPrompt implements InputPrompt {

    @Override
    public ConsoleInput prompt() {
        InputPrompt inputPrompt = new CoordinateInputPrompt();

        return inputPrompt.prompt();
    }
}
