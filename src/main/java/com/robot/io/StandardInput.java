package com.robot.io;

import com.io.exception.InputException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by vicek on 7/9/14.
 */
public class StandardInput implements Input {

    /**
     * Reader used for reading lines from standard system input.
     */
    private BufferedReader reader;

    /**
     * Constructor instantiates a buffered reader from the standard system input.
     */
    public StandardInput() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new InputException("Error occurred during reading the standard system input",e);
        }
    }

    @Override
    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            throw new InputException("Underlying reader couldn't be properly closed.",e);
        }
    }
}
