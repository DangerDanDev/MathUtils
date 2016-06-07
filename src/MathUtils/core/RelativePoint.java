package MathUtils.core;

/**
 * Created by DanDan on 6/5/2016.
 */
public class RelativePoint extends Location implements Location.ChangeListener{

    /**
     * The location I stay a relative distance from
     */
    private Location source;

    /**
     * How far from the source I will stay
     */
    private Vector2 delta;

    /**
     * Creates a relative point that
     * @param source The reference I will be following from a relative position
     * @param delta This value is copied by value-- not shared among instances if the same reference is passed.
     *              This is how far I will stay away from the source
     */
    public RelativePoint(Location source, Vector2 delta) {
        setSource(source);
        setDelta(delta);
    }

    /**
     * Gets my absolute location X coordinate
     * @return Delta.X + source.X
     */
    @Override
    public double getX() {
        return source.getX() + delta.getX();
    }

    /**
     * Gets my absolute location Y coordinate
     * @return
     */
    @Override
    public double getY() {
        return source.getY() + delta.getY();
    }

    /**
     * Gets how offset I am from my source
     * @return
     */
    public Vector2 getDelta() {
        return this.delta;
    }

    /**
     * Sets how offset I will be from my source
     * @param delta
     */
    public void setDelta(Vector2 delta) {
        this.delta = new Vector2(delta);
        onChanged();
    }

    /**
     * Removes me as a listener from the old source, sets my new source, and adds me
     * as a listener to it
     * @param source
     */
    public void setSource(Location source) {
        if(this.source != null)
            this.source.removeListener(this);

        this.source = source;

        if(this.source != null)
            this.source.addListener(this);
    }

    /**
     * Passes all onChanged events from my source onto my listeners.
     * Any time it moves, I move.
     * @param location
     */
    @Override
    public void locationChanged(Location location) {
        onChanged();
    }
}
