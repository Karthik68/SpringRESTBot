package com.robot.command;

import com.robot.Coordinate;
import com.robot.Direction;
import com.robot.Robot;
import com.robot.Table;

/**
 * Command which makes the robot move on table. It is valid if the robot is placed
 * on the table and if movement won't cause robot to fall of the table.
 */
public class MoveCommand implements Command {

    /**
     * Robot who is "receiving" this command
     */
    private Robot robot;

    /**
     * Constructor of command takes robot which should move as an argument.
     *
     * @param robot robot which should move
     */
    public MoveCommand(Robot robot) {
        this.robot = robot;
    }

    /**
     * It moves with robot one piece in current direction if it's possible.
     */
    @Override
    public void execute() {
        if(isValid()){
            robot.setCoordinate(getNewCoordinate(robot));
        }
    }

    /**
     * Checks if robot is put on a table and if potential move won't cause robot to fell from the table.
     *
     * @return is poslible for robot to move?
     */
    @Override
    public boolean isValid() {
        if (robot.getTable() == null){
            return false;
        }
        Table table = robot.getTable();
        return table.isOnTable(getNewCoordinate(robot));
    }

    /**
     * Computes next coordinate on which robot will be placed if he moves.
     * Package visibility for easy testability.
     * @param robot robot for which we compute the coordinate.
     * @return next coordinate on which robot will be placed if he moves.
     */
    Coordinate getNewCoordinate(Robot robot){
        Direction direction = robot.getDirection();
        Coordinate currentCoordinate = robot.getCoordinate();
        Coordinate newCoordinate = currentCoordinate.addCoordinate(direction.getStepAddition());
        return newCoordinate;
    }
}
