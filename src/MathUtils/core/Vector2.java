package MathUtils.core;

/**
 * Created by DanDan on 6/5/2016.
 */
public class Vector2 extends Location{
    private double x;
    private double y;

    public Vector2() {
        this(0,0);
    }

    public Vector2(Vector2 vec){
        this(vec.getX(), vec.getY());
    }

    public Vector2(double x, double y) {
        set(x,y);
    }


    public void set(double x, double y) {
        this.x = x;
        this.y = y;

        onChanged();
    }

    public void set(Vector2 vec) {
        set(vec.getX(), vec.getY());
    }

    @Override
    public double getX() {
        return x;
    }

    public void setX(float x) {
        set(x, getY());
    }

    @Override
    public double getY() {
        return y;
    }

    public void setY(float y) {
        set(getX(), y);
    }
}
