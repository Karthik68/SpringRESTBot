package com.robot.io;

import com.io.exception.InputException;

import java.io.*;

/**
 * Input from file.
 */
public class FileInput implements Input {

    /**
     * Reader used for reading file.
     */
    private BufferedReader reader;

    /**
     * Constructor initializes a reader from a file.
     * @param file file which will be read
     * @throws FileNotFoundException thrown if given file doesn't exist
     */
    public FileInput(File file) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(file));
    }

    @Override
    public String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new InputException("Error during reading file.",e);
        }
    }

    @Override
    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            throw new InputException("Underlying file reader couldn't be closed");
        }
    }
}
