package output;

import output.dto.CalculateOutput;
import output.dto.LineCalculateOutput;

public class LineOutputPrompt implements OutputPrompt {

    private static final String LINE_DISTANCE_NAVIGATION = "두 점 사이 거리는 ";

    @Override
    public void prompt(CalculateOutput calculateOutput) {
        LineCalculateOutput lineCalculateOutput = (LineCalculateOutput) calculateOutput;

        System.out.println(LINE_DISTANCE_NAVIGATION + lineCalculateOutput.getRoundedResult() + "\n");
    }
}
