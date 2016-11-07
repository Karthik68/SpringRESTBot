package com.robot.command;

import com.robot.Coordinate;
import com.robot.Direction;
import com.robot.Robot;
import com.robot.Table;

/**
 * Command places robot on a table. It is valid if robot isn't placed on table yet and coordinate on which
 * robot should be placed is on the table.
 */
public class PlaceCommand implements Command {

    /**
     * Table on which robot will be placed
     */
    private Table table;

    /**
     * Robot who is "receiving" this command
     */
    private Robot robot;

    /**
     * Coordinate on which robot will be placed
     */
    private Coordinate coordinate;

    /**
     * Direction which will robot be facing.
     */
    private Direction direction;

    /**
     * Constructor which takes all necessary data to execute command
     * @param table Table on which robot will be placed
     * @param robot Robot who is "receiving" this command
     * @param coordinate Coordinate on which robot will be placed
     * @param direction Direction which will robot be facing.
     */
    public PlaceCommand(Table table, Robot robot, Coordinate coordinate, Direction direction) {
        this.table = table;
        this.robot = robot;
        this.coordinate = coordinate;
        this.direction = direction;
    }

    /**
     * Execution will add table coordinate and direction to the robot.
     */
    @Override
    public void execute() {
        if(isValid()) {
            robot.putOnTable(table, coordinate, direction);
        }
    }

    /**
     * Command is valid if robot doesn't have table assigned yet and if the coordinate
     * is on table.
     * @return true if command is valid
     * @return false if command isn't valid
     */
    @Override
    public boolean isValid() {
        return
                table.isOnTable(coordinate) &&
                robot.getTable() == null;
    }
}
