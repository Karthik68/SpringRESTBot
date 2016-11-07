package com.robot.io;

import java.io.PrintWriter;

/**
 * Output writing to standard system output.
 */
public class StandardOutput implements Output {

    /**
     * Writer writing to standard input.
     */
    private PrintWriter writer;

    /**
     * Constructor initializes the writer.
     */
    public StandardOutput() {
        this.writer = new PrintWriter(System.out);
    }

    @Override
    public void writeLine(String line) {
        writer.println(line);
        writer.flush();
    }

    @Override
    public void close() {
       writer.close();
    }
}
