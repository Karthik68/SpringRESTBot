package com.scanner;

import java.util.Collections;
import java.util.List;

/**
 * Instead of tokens, lexer produces raw commands. Which are combination of type token and arguments.
 */
public final class RawCommand {

    /**
     * Command type token.
     */
    private CommandType commandType;
    /**
     * List of arguments for command.
     */
    private List<Object> args;

    /**
     * Creates raw command without arguments.
     *
     * @param commandType type of command
     */
    public RawCommand(CommandType commandType) {
        this.commandType = commandType;
        this.args = Collections.emptyList();
    }

    /**
     * Creates raw command with arguments.
     *
     * @param commandType command type
     * @param args arguments for real command
     */
    public RawCommand(CommandType commandType, List<Object> args) {
        this.commandType = commandType;
        this.args = args;
    }

    /**
     * returns type of this command
     * @return type of the command
     */
    public CommandType getCommandType() {
        return commandType;
    }

    /**
     * Returns list of all arguments
     * @return list of all arguments
     */
    public List<Object> getArgs() {
        return args;
    }

    /*
    EQUALS AND HASH CODE AUTOMATICALLY GENERATED. REGENERATE WITH EVERY FIELD CHANGE
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RawCommand that = (RawCommand) o;

        if (args != null ? !args.equals(that.args) : that.args != null) return false;
        if (commandType != that.commandType) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commandType != null ? commandType.hashCode() : 0;
        result = 31 * result + (args != null ? args.hashCode() : 0);
        return result;
    }
}
