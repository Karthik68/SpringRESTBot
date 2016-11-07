package com.scanner;

import com.robot.io.Input;

/**
 * Lexer is responsible for interpreting strings into internal
 * command grammar. It is also parsing arguments into proper types.
 * Don't forget to close underlying input!!
 */
public interface Scanner {
    /**
     * Sets input to a lexer. Lexer uses it to convert lines to raw commands.
     * @param input string input
     */
    void setInput(Input input);

    /**
     * Closes underlying input.
     */
    void closeInput();

    /**
     * Fetches one raw command. Or returns null if end of input stream was reached.
     * @return
     */
    RawCommand fetchCommand();
    
    /**
     * Fetches one raw command from Rest request. Or returns null if end of input stream was reached.
     * @return
     */
    RawCommand fetchCommand(String botCmd);
}
