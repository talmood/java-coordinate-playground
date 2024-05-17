package runner;

import common.constant.Placeholder;
import io.UserInputScan;
import point.PointManager;
import shape.Shape;
import shape.ShapeManager;

public class SystemRunner {
    public void run(){
        System.out.println(Placeholder.START);
        boolean retryFlag = true;
        final UserInputScan userInputScan = new UserInputScan();
        while (retryFlag) {
            try {
                userInputScan.scan();
                PointManager pointManager = new PointManager();
                pointManager.createPoint(userInputScan.getPreprocessedPoints());
                ShapeManager shapeManager = new ShapeManager();
                Shape shape = shapeManager.createShape(pointManager.getPoints());
                shape.calculate();
                shape.displayResult();
                retryFlag = userInputScan.retryScan();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println(Placeholder.END);
    }
}
