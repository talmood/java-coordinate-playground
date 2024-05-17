package output;

import output.dto.CalculateOutput;
import output.dto.TriangleCalculateOutput;

public class TriangleOutputPrompt implements OutputPrompt {

    private static final String TRIANGLE_AREA_NAVIGATION = "삼각형 넓이는 ";

    @Override
    public void prompt(CalculateOutput calculateOutput) {
        TriangleCalculateOutput triangleCalculateOutput = (TriangleCalculateOutput) calculateOutput;

        System.out.println(TRIANGLE_AREA_NAVIGATION + triangleCalculateOutput.getRoundedResult() + "\n");
    }
}
