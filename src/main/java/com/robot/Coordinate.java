package com.robot;

/**
 * Atomic immutable class for holding coordinates;
 */
public final class Coordinate {
    /**
     * X coordinate
     */
    private final int x;
    /**
     * Y coordinate
     */
    private final int y;

    /**
     * Constructor for coordinate.
     * @param x x coordinate
     * @param y y coordinate
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get the x part of coordinate
     * @return x part of coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Get the y part of coordinate
     * @return y part of coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Method for addition of two coordinates.
     *
     * @param addition coordinate to be added to this one
     * @return newly created added coordinate
     */
    public Coordinate addCoordinate(Coordinate addition){
        int newX = x + addition.getX();
        int newY = y + addition.getY();
        return new Coordinate(newX,newY);
    }

    /*
    EQUALS AND HASH CODE AUTOMATICALLY GENERATED. REGENERATE WITH EVERY FIELD CHANGE
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (x != that.x) return false;
        if (y != that.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
