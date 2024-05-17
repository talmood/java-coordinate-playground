package output.dto;

public class LineCalculateOutput implements CalculateOutput {

    private final double result;

    public LineCalculateOutput(double result) {
        this.result = result;
    }

    public double getRoundedResult() {
        return Math.round(result * 1000000) / 1000000.0;
    }
}
