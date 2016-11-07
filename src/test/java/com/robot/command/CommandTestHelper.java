package com.robot.command;

import com.robot.*;

/**
 * Helper methods for command testing.
 */
public class CommandTestHelper {

    /**
     * Basic 4x4 table.
     */
    public static final Table TABLE_4X4 = new SimpleTable(4,4);

    /**
     * Returns robot on 4x4 table on location (0,0) facing NORTH.
     * @return robot on 4x4 table on location (0,0) facing NORTH.
     */
    public static Robot getRobotOnTheTable(){
        Robot robot = new SimpleRobot();
        robot.putOnTable(TABLE_4X4, new Coordinate(0,0), Direction.NORTH);
        return robot;
    }

    /**
     * Returns robot on 4x4 table on location (0,0) facing given direction.
     *
     * @param direction direction robot will be facing
     * @return robot on 4x4 table on location (0,0) facing given direction.
     */
    public static Robot getRobotOnTheTable(Direction direction){
        Robot robot = new SimpleRobot();
        robot.putOnTable(TABLE_4X4, new Coordinate(0,0), direction);
        return robot;
    }
}
