import java.util.List;

public class Processor {

    public void calculateAreaByCoordinates (List<Point> points) {
        Calculator calculator = new Calculator();
        String calculatedMessage = calculator.calculateArea(points);
        System.out.println(calculatedMessage + "\n");
    }
    
}
