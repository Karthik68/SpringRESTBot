package com.robot.command;

import com.robot.*;
import com.robot.command.MoveCommand;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test of move command.
 */
public class MoveCommandTest {

    /**
     * Robot who is on the WEST-SOUTH edge of table and is facing SOUTH.
     */
    Robot robotOnEdge;

    @Before
    public void init(){
        robotOnEdge = CommandTestHelper.getRobotOnTheTable(Direction.SOUTH);
    }


    @Test
    public void testMoveRobotWithoutTable(){
        Robot robot = new SimpleRobot();
        MoveCommand cmd = new MoveCommand(robot);
        assertFalse(cmd.isValid());
    }

    @Test
    public void testMoveRobotOutOfTable(){
        MoveCommand cmd = new MoveCommand(robotOnEdge);
        assertFalse(cmd.isValid());
    }

    @Test
    public void testRobotOnEdgeWontMove(){
        MoveCommand cmd = new MoveCommand(robotOnEdge);
        cmd.execute();
        assertEquals("Robot has moved!", new Coordinate(0,0), robotOnEdge.getCoordinate());
    }

    @Test
    public void testGetNewCoordinate(){
        MoveCommand cmd = new MoveCommand(robotOnEdge);
        Coordinate newCoordinate = cmd.getNewCoordinate(robotOnEdge);
        assertEquals("New coordinate doesn't match!", new Coordinate(0,-1), newCoordinate);
        robotOnEdge.setDirection(Direction.EAST);
        newCoordinate = cmd.getNewCoordinate(robotOnEdge);
        assertEquals("New coordinate doesn't match!", new Coordinate(1,0), newCoordinate);
    }

    @Test
    public void robotMovesProperly(){
        robotOnEdge.setDirection(Direction.NORTH);
        MoveCommand cmd = new MoveCommand(robotOnEdge);
        cmd.execute();
        assertEquals("Robot didn't move on proper coordinate!", new Coordinate(0,1), robotOnEdge.getCoordinate());
        robotOnEdge.setDirection(Direction.EAST);
        cmd.execute();
        assertEquals("Robot didn't move on proper coordinate!", new Coordinate(1,1), robotOnEdge.getCoordinate());
    }
}
