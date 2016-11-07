package com.robot.command;

import com.robot.Direction;
import com.robot.Robot;
import com.robot.command.TurnLeftCommand;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests TurnLeftCommand.
 */
public class TurnLeftCommandTest {

    @Test
    public void testProperTurning(){
        Robot robot = CommandTestHelper.getRobotOnTheTable();
        TurnLeftCommand cmd = new TurnLeftCommand(robot);
        cmd.execute();
        assertEquals("Robot should be facing WEST.", Direction.WEST, robot.getDirection());
        cmd.execute();
        assertEquals("Robot should be facing SOUTH.", Direction.SOUTH, robot.getDirection());
        cmd.execute();
        assertEquals("Robot should be facing EAST.", Direction.EAST, robot.getDirection());
        cmd.execute();
        assertEquals("Robot should be facing NORTH.", Direction.NORTH, robot.getDirection());
    }
}
