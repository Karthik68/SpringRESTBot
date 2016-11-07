package com.robot.io;

/**
 * Represents an input interface to the application. Don't forget to close it after use!
 */
public interface Input{

    /**
     * Reads one line of input or returns null in case of reaching the end of input.
     * @return line from input
     * @return null if end of input has been reached
     */
    String readLine();

    /**
     * Closes the underlying input stream.
     */
    void close();

}
