package com.scanner;

/**
 * Token which is used to determine command type.
 * This is basic output of lexer.
 */
public enum CommandType {
    /**
     * Puts robot on a table. Requires 3 arguments(Integer x coordinate,
     * Integer y coordinate, Direction direction robot is facing)
     */
    PLACE("PLACE"),
    /**
     * Robot will make one step in its current direction if it's possible.
     */
    MOVE("MOVE"),
    /**
     * Robot will change his direction 90 degrees to the left
     */
    LEFT("LEFT"),
    /**
     * Robot will change his direction 90 degrees to the right
     */
    RIGHT("RIGHT"),
    /**
     * Robot will return his coordinates on the table and direction it is facing to the output.
     */
    REPORT("REPORT"),
    /**
     * Invalid command in case of unparsable input.
     */
    INVALID("");

    /**
     * String form of command name
     */
    String name;

    CommandType(String name) {
        this.name = name;
    }

    /**
     * Get string name of command
     * @return string name of command
     */
    public String getName() {
        return name;
    }
}
