package output.dto;

public class TriangleCalculateOutput implements CalculateOutput {

    private final double result;

    public TriangleCalculateOutput(double result) {
        this.result = result;
    }

    public double getRoundedResult() {
        return Math.round(this.result * 10) / 10.0;
    }
}
