package com.robot.command;

/**
 * Command implementations contain all business logic.
 */
public interface Command {

    /**
     * Executes command.
     */
    void execute();

    boolean isValid();


    /**
     * Void implementation as simplest solution for running invalid raw commands.
     */
    public static Command VOID = new Command(){

        @Override
        public void execute() {

        }

        @Override
        public boolean isValid() {
            return false;
        }
    };
}
