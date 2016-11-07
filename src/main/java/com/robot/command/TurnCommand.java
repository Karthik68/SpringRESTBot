package com.robot.command;

import com.robot.Direction;
import com.robot.Robot;

import java.util.Map;

/**
 * Abstract command for every command which makes robot change its direction.
 */
public abstract class TurnCommand implements Command {

    /**
     * Robot who is "receiving" this command
     */
    private Robot robot;

    /**
     *
     * @param robot robot which will turn
     */
    protected TurnCommand(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void execute() {
        if(isValid()){
            robot.setDirection(nextDirectionMap().get(robot.getDirection()));
        }
    }

    /**
     * Returns mapping which for every direction returns following direction in turn move.
     * For example for command Turn180Degrees would mapping look like:
     * <code>
     *     <NORTH,SOUTH>
     *     <EAST,WEST>
     *     <SOUTH,NORTH>
     *     <WEST,EAST>
     * </code>
     * @return
     */
    protected abstract Map<Direction,Direction> nextDirectionMap();

    /**
     * Command is valid if robot is on the table.
     * @return is valid to run this command?
     */
    @Override
    public boolean isValid() {
        return robot.getTable() != null;
    }
}
