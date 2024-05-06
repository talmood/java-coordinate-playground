package output;

import org.junit.jupiter.api.Test;
import output.dto.LineCalculateOutput;
import output.dto.SquareCalculateOutput;
import output.dto.TriangleCalculateOutput;

import static org.junit.jupiter.api.Assertions.assertTrue;

class OutputPromptCreatorTest {

    @Test
    void lineOutputPromptCreate() {
        LineCalculateOutput output = new LineCalculateOutput(1.0);
        OutputPrompt outputPrompt = OutputPromptCreator.create(output);

        assertTrue(outputPrompt instanceof LineOutputPrompt);
    }

    @Test
    void TriangleOutputPromptCreate() {
        TriangleCalculateOutput output = new TriangleCalculateOutput(1.0);
        OutputPrompt outputPrompt = OutputPromptCreator.create(output);

        assertTrue(outputPrompt instanceof TriangleOutputPrompt);
    }

    @Test
    void SquareOutputPromptCreate() {
        SquareCalculateOutput output = new SquareCalculateOutput(1);
        OutputPrompt outputPrompt = OutputPromptCreator.create(output);

        assertTrue(outputPrompt instanceof SquareOutputPrompt);
    }
}