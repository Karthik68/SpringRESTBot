package com.robot;

import com.robot.Direction;
import com.robot.io.Output;
import com.scanner.CommandType;
import com.scanner.RawCommand;

import java.util.LinkedList;
import java.util.List;

/**
 * Util methods and classes used through whole test suite.
 */
public class TestUtils {

    /**
     * Helper method for building raw place command
     * @param x x coordinate
     * @param y y coordinate
     * @param direction direction
     * @return raw command from given parameters
     */
    public static RawCommand buildRawPlace(int x, int y, Direction direction){
        List<Object> args = new LinkedList<>();
        args.add(x);
        args.add(y);
        args.add(direction);
        return new RawCommand(CommandType.PLACE,args);
    }

    /**
     * Test output class used as mock for testing report command.
     */
    public static class StringOutput implements Output {

        /**
         * Variable holding written output.
         */
        private String line;

        @Override
        public void writeLine(String line) {
            this.line = line;
        }

        @Override
        public void close() {

        }

        /**
         * Gets written output.
         * @return
         */
        public String getLine(){
            return line;
        }
    }
}
