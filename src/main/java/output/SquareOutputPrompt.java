package output;

import output.dto.CalculateOutput;
import output.dto.SquareCalculateOutput;

public class SquareOutputPrompt implements OutputPrompt {

    private static final String SQUARE_AREA_NAVIGATION = "사각형 넓이는 ";

    @Override
    public void prompt(CalculateOutput calculateOutput) {
        SquareCalculateOutput squareCalculateOutput = (SquareCalculateOutput) calculateOutput;

        System.out.println(SQUARE_AREA_NAVIGATION + squareCalculateOutput.getResult() + "\n");
    }
}
