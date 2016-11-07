package com.robot.command;

import com.robot.*;
import com.robot.command.PlaceCommand;

import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Test of place command.
 */
public class PlaceCommandTest {

    @Test
    public void testRobotAlreadyHaveTable(){
        Robot robot = CommandTestHelper.getRobotOnTheTable();
        PlaceCommand cmd = new PlaceCommand(new SimpleTable(4,4),robot,new Coordinate(0,0), Direction.EAST);
        assertFalse("Robot has already table but command is still valid.",cmd.isValid());
    }

    @Test
    public void testCoordinateOutsideNewTable(){
        PlaceCommand cmd = new PlaceCommand(new SimpleTable(4,4), new SimpleRobot(), new Coordinate(5,5), Direction.EAST);
        assertFalse("New coordinate is outside table but command is still valid.",cmd.isValid());
    }

    @Test
    public void testValidCommand(){
        PlaceCommand cmd = new PlaceCommand(new SimpleTable(4,4), new SimpleRobot(), new Coordinate(3,1), Direction.EAST);
        assertTrue("Command has valid constructor parameters, but validation fails",cmd.isValid());
    }

    @Test
    public void executeValidCommand(){
        Robot robot = new SimpleRobot();
        Table table = new SimpleTable(4,4);
        Coordinate coordinate = new Coordinate(3,1);
        PlaceCommand cmd = new PlaceCommand(table, robot, coordinate, Direction.EAST);
        cmd.execute();
        assertNotNull("Table should be assigned to the robot", robot.getTable());
        assertEquals("Robot has wrong table",table,robot.getTable());

        assertNotNull("Coordinate should be assigned to the robot", robot.getCoordinate());
        assertEquals("Coordinate from command and robot's coordinate doesn't match.", coordinate, robot.getCoordinate());

        assertEquals("Robot should face EAST", Direction.EAST, robot.getDirection());
    }
}
