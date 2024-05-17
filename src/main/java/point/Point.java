package point;

public class Point implements Comparable {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void validateSamePoint(final Point comparePoint){
        if(this.x == comparePoint.getX() && this.y == comparePoint.getY()){
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다. 겹치는 좌표가 존재합니다.");
        }
    }

    @Override
    public int compareTo(Object object) {
        final Point point = (Point) object;
        if(this.x > point.x){
            return 1;
        }
        if(this.x == point.x && this.y > point.y){
            return 1;
        }
        return -1;
    }

    public void display(){
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
}
