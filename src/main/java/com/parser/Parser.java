package com.parser;

import com.robot.Robot;
import com.robot.Table;
import com.robot.io.Output;
import com.scanner.Scanner;

/**
 * Parser understand Lexer's output (raw commands) and creates actual commands
 * containing business logic. It works like a Client in command design pattern.
 */
public interface Parser {

    /**
     * Sets Scanner for command input.
     *
     */
    void setScanner(Scanner lexer);

    /**
     * Sets robot as a receiver of commands.
     *
     *
     */
    void setRobot(Robot robot);

    /**
     * Set output for commands which use it.
     *
     * @param output output for commands
     */
    void setOutput(Output output);

    /**
     * Sets table on which robot is placed with PLACE command.
     *
     * @param table table for a robot to be placed
     */
    void setTable(Table table);

    /**
     * Starts fetching commands from Scanner and executing them.
     */
    void run();
    
    /**
     * Starts fetching commands from Rest Request and executing them.
     */
    String run(String botCmd);
}
