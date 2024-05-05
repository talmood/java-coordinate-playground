package output;

import output.dto.CalculateOutput;
import output.dto.LineCalculateOutput;
import output.dto.SquareCalculateOutput;
import output.dto.TriangleCalculateOutput;

public abstract class OutputPromptCreator {

    public static OutputPrompt create(CalculateOutput calculateOutput) {
        if (calculateOutput instanceof LineCalculateOutput) {
            return new LineOutputPrompt();
        }

        if (calculateOutput instanceof TriangleCalculateOutput) {
            return new TriangleOutputPrompt();
        }

        if (calculateOutput instanceof SquareCalculateOutput) {
            return new SquareOutputPrompt();
        }

        throw new IllegalArgumentException("[ERROR] 결과에 해당하는 Prompt가 없습니다.");
    }
}
