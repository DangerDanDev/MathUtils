package core;

import java.util.ArrayList;

/**
 * Created by DanDan on 6/5/2016.
 */
public abstract class Location {

    public abstract float getX();
    public abstract float getY();

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
