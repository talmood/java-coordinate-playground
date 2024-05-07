public class Utils {
    public static double calculateDistance(Point point1, Point point2) {
        return Math.sqrt(Math.pow(point2.getPointX() - point1.getPointX(), 2)
                + Math.pow(point2.getPointY() - point1.getPointY(), 2));
    }

}
