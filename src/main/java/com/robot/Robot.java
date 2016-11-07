package com.robot;

/**
 * Simple toy robot interface.
 */
public interface Robot {
    /**
     * Return robots coordinate on the table.
     *
     * @return coordinate on the table
     * @return null if robot isn't placed on the table
     */
    Coordinate getCoordinate();

    /**
     * Sets new coordinate to the robot. Table has to be set.
     *
     * @param coordinate new robots coordinate. Can't be null. Has to be on the table.
     */
    void setCoordinate(Coordinate coordinate);

    /**
     * Returns direction which is robot facing.
     *
     * @return direction which is robot facing
     */
    Direction getDirection();

    /**
     * Sets new direction to the robot. Table has to be set.
     *
     * @param direction  new robot's direction.
     */
    void setDirection(Direction direction);

    /**
     * Puts robot on given table. This methods ensures invariant, that if robot has table,
     * it has to have also coordinate and direction! If another method for table manipulation
     * will be added, this invariant has to be kept!!!
     *
     * @param table table on which robot is put on
     * @param coordinate coordinate on which robot is placed, NOT NULL
     * @param direction direction which robot is facing on the table, NOT NULL
     */
    void putOnTable(Table table, Coordinate coordinate, Direction direction);

    /**
     * Returns table on which robot is placed or null, if robot hasn't been placed on table yet.
     *
     * @return table on which robot is placed
     * @return null if robot hasn't been placed on a table yet
     */
    Table getTable();
}
