package MathUtils.core;

import java.util.ArrayList;

/**
 * Created by DanDan on 6/5/2016.
 */
public abstract class Location {

    /**
     * Returns my X coordinate
     * @return
     */
    public abstract double getX();

    /**
     * Returns my Y coordinate
     * @return
     */
    public abstract double getY();

    /**
     * Returns my X and Y components in a vector2
     * @return
     */
    public Vector2 asVector2() {
        return new Vector2(getX(), getY());
    }

    /**
     *
     * @param pos
     * @return The difference between me and another location object
     */
    public Vector2 minus(Location pos) {
        return new Vector2(getX() - pos.getX(), getY() - pos.getY());
    }

    /**
     * List of classes listening for changes
     */
    private ArrayList<ChangeListener> listeners = new ArrayList<>();

    /**
     * Notifies all listeners that one of my components (x or y) has changed
     */
    protected void onChanged() {
        for(ChangeListener listener : listeners) {
            listener.locationChanged(this);
        }
    }

    @Override
    public String toString() {
        return "Coords: (" + getX() + ", " + getY() + ")";
    }

    /**
     * Adds a listener to my onChanged event
     * @param listener
     */
    public void addListener(ChangeListener listener) {
        this.listeners.add(listener);
    }

    /**
     * Removes a listener from my onChanged event
     * @param listener
     */
    public void removeListener(ChangeListener listener) {
        this.listeners.remove(listener);
    }

    /**
     * For classes that wish to listen in for changes on my X and Y coords
     */
    public interface ChangeListener {

        /**
         * Notifies listeners when my location has changed
         * @param location
         */
        void locationChanged(Location location);
    }
}
