public class Point {
    protected float x = 0.0f;
    protected float y = 0.0f;

    // Constructor không tham số
    public Point() {
    }

    // Constructor có tham số
    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    // Getter và Setter cho x
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    // Getter và Setter cho y
    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    // setXY
    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    // getXY: trả về mảng float[]
    public float[] getXY() {
        return new float[] {x, y};
    }

    // toString: trả về dạng (x,y)
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
