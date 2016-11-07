package com.robot.io;



/**
 * Represents output interface from application. Don't forget to close it after use!
 */
public interface Output {

    /**
     * Writes line to output.
     * @param line string to write
     */
    void writeLine(String line);

    /**
     * Closes the underlying input stream.
     */
    void close();

}
