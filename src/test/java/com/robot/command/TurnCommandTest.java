package com.robot.command;

import com.robot.*;
import com.robot.command.TurnCommand;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Tests abstract class for turning robot.
 */
public class TurnCommandTest {

    @Test
    public void testValidCommand(){
        Robot robot = new SimpleRobot();
        TurnCommand turnCommand = new TurnCommand(robot) {
            @Override
            protected Map<Direction, Direction> nextDirectionMap() {
                return null;
            }
        };
        assertFalse(turnCommand.isValid());
        robot.putOnTable(new SimpleTable(3,3), new Coordinate(0,0), Direction.NORTH);
        assertTrue(turnCommand.isValid());
    }
}
