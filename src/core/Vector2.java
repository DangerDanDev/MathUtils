package core;

/**
 * Created by DanDan on 6/5/2016.
 */
public class Vector2 extends Location{
    private float x;
    private float y;

    public Vector2() {
        this(0,0);
    }

    public Vector2(Vector2 vec){
        this(vec.getX(), vec.getY());
    }

    public Vector2(float x, float y) {
        set(x,y);
    }


    public void set(float x, float y) {
        this.x = x;
        this.y = y;

        onChanged();
    }

    @Override
    public float getX() {
        return x;
    }

    public void setX(float x) {
        set(x, getY());
    }

    @Override
    public float getY() {
        return y;
    }

    public void setY(float y) {
        set(getX(), y);
    }
}
