package point;

public class Point {
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
}
