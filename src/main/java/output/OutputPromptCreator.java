package output;

import output.dto.CalculateOutput;

public abstract class OutputPromptCreator {

    public static OutputPrompt create(CalculateOutput calculateOutput) {
        if (calculateOutput instanceof LineOutputPrompt) {
            return new LineOutputPrompt();
        }

        if (calculateOutput instanceof TriangleOutputPrompt) {
            return new TriangleOutputPrompt();
        }

        if (calculateOutput instanceof SquareOutputPrompt) {
            return new SquareOutputPrompt();
        }

        throw new IllegalArgumentException("[ERROR] 결과에 해당하는 Prompt가 없습니다.");
    }
}
