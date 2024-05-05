package output.dto;

import output.OutputPrompt;
import output.OutputPromptCreator;

public class ConsoleOutputPrompt implements OutputPrompt {

    private static final String RESULT_NAVIGATION = "> 실행 결과";

    @Override
    public void prompt(CalculateOutput output) {
        System.out.println(RESULT_NAVIGATION);

        OutputPrompt outputPrompt = OutputPromptCreator.create(output);
        outputPrompt.prompt(output);
    }
}
