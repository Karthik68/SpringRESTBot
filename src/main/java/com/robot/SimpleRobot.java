package com.robot;

import com.robot.Coordinate;
import com.robot.Direction;
import com.robot.Robot;
import com.robot.Table;

import org.apache.commons.lang3.Validate;

/**
 * Simple implementation of Robot interface. It works basically as representation of robots state and nothing else.
 */
public class SimpleRobot implements Robot {

    private Coordinate currentCoordinate;
    private Direction direction;
    private Table table;


    @Override
    public Coordinate getCoordinate() {
        return currentCoordinate;
    }

    /**
     * Sets coordinate on the table to the robot. Can't be set if robot is not on a table. Has to be on the table.
     *
     * @param coordinate new robots coordinate.
     */
    @Override
    public void setCoordinate(Coordinate coordinate) {
        Validate.notNull(table);
        Validate.notNull(coordinate);
        Validate.isTrue(table.isOnTable(coordinate));
        this.currentCoordinate = coordinate;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public void setDirection(Direction direction) {
        Validate.notNull(table);
        Validate.notNull(direction);
        this.direction = direction;
    }

    @Override
    public void putOnTable(Table table, Coordinate coordinate, Direction direction) {
        this.table = table;
        setCoordinate(coordinate);
        setDirection(direction);
    }

    @Override
    public Table getTable() {
        return table;
    }

    /*
    EQUALS AND HASH CODE AUTOMATICALLY GENERATED. REGENERATE WITH EVERY FIELD CHANGE
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleRobot that = (SimpleRobot) o;

        if (currentCoordinate != null ? !currentCoordinate.equals(that.currentCoordinate) : that.currentCoordinate != null)
            return false;
        if (direction != that.direction) return false;
        if (table != null ? !table.equals(that.table) : that.table != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = currentCoordinate != null ? currentCoordinate.hashCode() : 0;
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        result = 31 * result + (table != null ? table.hashCode() : 0);
        return result;
    }
}
