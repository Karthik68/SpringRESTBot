package com.scanner;

import com.robot.Direction;
import com.robot.TestUtils;
import com.robot.io.Input;
import com.scanner.CommandType;
import com.scanner.RawCommand;
import com.scanner.SimpleScanner;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Test class for SimpleLexer
 */
public class SimpleScannerTest {

    /**
     * Invalid raw command
     */
    private static RawCommand INVALID_COMMAND = new RawCommand(CommandType.INVALID);

    /**
     * Mock string input
     */
    private StringInput stringInput;
    /**
     * Tested object
     */
    private SimpleScanner lexer;

    @Before
    public void init(){
        stringInput = new StringInput();
        lexer = new SimpleScanner();
        lexer.setInput(stringInput);
    }

    /**
     * Testing lexer on invalid no arguments commands
     */
    @Test
    public void testInvalidSignleCommands(){
        assertEquals(INVALID_COMMAND, fetchCmd("ABC"));
        assertEquals(INVALID_COMMAND, fetchCmd(" MOVE"));
        assertEquals(INVALID_COMMAND, fetchCmd("LEFTA"));
        assertEquals(INVALID_COMMAND, fetchCmd("RE PORT"));
        assertEquals(INVALID_COMMAND, fetchCmd("RIGHT "));
    }

    /**
     * Testing lexer on valid no arguments commands
     */
    @Test
    public void testValidSingleCommnads(){
        assertEquals(new RawCommand(CommandType.MOVE), fetchCmd("MOVE"));
        assertEquals(new RawCommand(CommandType.LEFT), fetchCmd("LEFT"));
        assertEquals(new RawCommand(CommandType.RIGHT), fetchCmd("RIGHT"));
        assertEquals(new RawCommand(CommandType.REPORT), fetchCmd("REPORT"));
    }

    /**
     * Testing lexer on invalid place command
     */
    @Test
    public void testInvalidPlace(){
        assertEquals(INVALID_COMMAND, fetchCmd("PLACE"));
        assertEquals(INVALID_COMMAND, fetchCmd("PLACE -1,1,SOUTH"));
        assertEquals(INVALID_COMMAND, fetchCmd("PLACE x,1,SOUTH"));
        assertEquals(INVALID_COMMAND, fetchCmd("PLACE 1,y,SOUTH"));
        assertEquals(INVALID_COMMAND, fetchCmd("PLACE 1,1,SOUTL"));
        assertEquals(INVALID_COMMAND, fetchCmd("PLACE 1,1,SOUTH "));
    }

    /**
     * Testing lexer on valid place command
     */
    @Test
    public void testValidPlace(){
        assertEquals(TestUtils.buildRawPlace(10, 20, Direction.SOUTH), fetchCmd("PLACE 10,20,SOUTH"));
        assertEquals(TestUtils.buildRawPlace(0, 0, Direction.EAST), fetchCmd("PLACE 0,0,EAST"));
        assertEquals(TestUtils.buildRawPlace(1, 3, Direction.NORTH), fetchCmd("PLACE 1,3,NORTH"));
        assertEquals(TestUtils.buildRawPlace(111, 3, Direction.WEST), fetchCmd("PLACE 111,3,WEST"));
    }


    /**
     * Helper method which converts string into raw command over lexer.
     *
     * @param command string command representation
     * @return parsed raw command
     */
    private RawCommand fetchCmd(String command){
        stringInput.setLine(command);
        return lexer.fetchCommand();
    }

    /**
     * Mock input class for testing lexer
     */
    private static class StringInput implements Input{

        private String line;

        @Override
        public String readLine() {
            return line;
        }

        @Override
        public void close() {

        }

        public void setLine(String line) {
            this.line = line;
        }
    }
}
