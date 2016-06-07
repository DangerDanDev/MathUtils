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

    /**
     * Sets my location to the same coords as another vector.
     * Marked as final because this is a passthrough call to set(float, float); if desired functionality should
     * be changed, override set(float, float) instead.
     * @param vec
     */
    public final void set(Location vec) {
        set(vec.getX(), vec.getY());
    }

    /**
     *
     * @return My X coordinate
     */
    @Override
    public double getX() {
        return x;
    }

    /**
     * Pass through to set(x, getY()). Marked as final because any overrides should be done on that method--
     * set(double, double):
     * @param x My new X coordinate
     */
    public final void setX(float x) {
        set(x, getY());
    }

    /**
     *
     * @return My Y coordinate
     */
    @Override
    public final double getY() {
        return y;
    }

    /**
     * Pass through to set(getX(), y). Marked as final because any overrides should be done on that method--
     * set(double, double):
     * @param y My new Y coordinate
     */
    public final  void setY(float y) {
        set(getX(), y);
    }

    /**
     * Translates me by the given amount. Marked as final because it utilizes a call to set(getX() + x, getY() + y);
     * Any changes should be overridden in that method
     * @param x Translation X
     * @param y Translation Y
     */
    public final void translate(double x, double y) {
        set(getX() + x, getY() + y);
    }

    /**
     * Translates me by the given amount. Marked as final because it utilizes a call translate(double, double) which utilizes
     * a call to set(getX() + x, getY() + y);
     * Any changes should be overridden in that method
     * @param x Translation X
     * @param y Translation Y
     */
    public final void translate(Location vec) {
        translate(vec.getX(), vec.getX());
    }
}
