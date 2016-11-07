package com.robot;

import org.junit.Before;
import org.junit.Test;

import com.robot.Coordinate;
import com.robot.SimpleTable;

import static org.junit.Assert.*;
/**
 * Test of simple table's implementation.
 */
public class SimpleTableTest {

    private SimpleTable simpleTable;

    @Before
    public void init(){
        simpleTable = new SimpleTable(4,4);
    }

    /**
     * Testing coordinate on the table
     */
    @Test
    public void testIsOnTable(){
        //Test corners of table
        assertTrue(simpleTable.isOnTable(new Coordinate(0,0)));
        assertTrue(simpleTable.isOnTable(new Coordinate(0,4)));
        assertTrue(simpleTable.isOnTable(new Coordinate(4,0)));
        assertTrue(simpleTable.isOnTable(new Coordinate(4,4)));
        //Test point inside of a table
        assertTrue(simpleTable.isOnTable(new Coordinate(2,2)));
    }

    /**
     * Testing coordinate outside of the table
     */
    @Test
    public void testIsNotOnTable(){
        //Test out of table in every direction
        assertFalse(simpleTable.isOnTable(new Coordinate(-1,0)));
        assertFalse(simpleTable.isOnTable(new Coordinate(5,0)));
        assertFalse(simpleTable.isOnTable(new Coordinate(0,-1)));
        assertFalse(simpleTable.isOnTable(new Coordinate(0, 5)));
    }
}
