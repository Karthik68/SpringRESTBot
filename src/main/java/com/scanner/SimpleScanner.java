package com.scanner;

import com.robot.Direction;
import com.robot.io.Input;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Simple implementation of lexer, which transforms line from input into raw commands.
 */
public class SimpleScanner implements Scanner {

    /**
     * Patern for proper PLACE command syntax with groups for numbers and direction
     */
    private static final Pattern VALID_PLACE_PATTERN = Pattern.compile("^PLACE (\\d+),(\\d+),(NORTH|EAST|SOUTH|WEST)$");

    /**
     * Prepared invalid command instance
     */
    private static final RawCommand INVALID_COMMAND = new RawCommand(CommandType.INVALID);

    /**
     * All commands that don't require any additional arguments and can be
     * than parsed just based on one simple string.
     */
    private static final List<CommandType> NON_ARGS_COMMANDS;

    /**
     * Initialization of non argument commands.
     */
    static {
        List<CommandType> nonArgsCommands = new LinkedList<>();
        nonArgsCommands.add(CommandType.MOVE);
        nonArgsCommands.add(CommandType.LEFT);
        nonArgsCommands.add(CommandType.RIGHT);
        nonArgsCommands.add(CommandType.REPORT);
        NON_ARGS_COMMANDS = Collections.unmodifiableList(nonArgsCommands);
    }

    /**
     * Input from which lines are read.
     */
    private Input input;

    @Override
    public void setInput(Input input) {
        this.input = input;
    }

    @Override
    public void closeInput() {
        if(input != null){
            input.close();
        }
    }

    /**
     * Method fetches one line from input and parses it to a raw command.
     *
     * @return raw command from input line
     */
    @Override
    public RawCommand fetchCommand() {
        if(input == null){
            throw new RuntimeException("Trying to read from null input.");
        }
        String line = input.readLine();
        if(line == null){
            return null;
        }
        return convertLineToRawCommand(line);
    }
    
    /**
     * Method fetches botCmd from Rest request and parses it to a raw command.
     *
     * @return raw command from input line
     */
    @Override
    public RawCommand fetchCommand(String botCmd) {
        if(botCmd == null){
        	return null;
        }
        
        return convertLineToRawCommand(botCmd);
    }

    /**
     * This method converts one string (line of input) to a raw command.
     *
     * @param line string (line of input)
     * @return raw command
     */
    private RawCommand convertLineToRawCommand(String line) {
        if(line.startsWith(CommandType.PLACE.getName())){
            return processPlaceCommand(line);
        }
        for(CommandType commandType : NON_ARGS_COMMANDS){
            if(commandType.getName().equals(line)){
                return new RawCommand(commandType);
            }
        }
        return INVALID_COMMAND;
    }

    /**
     * Most complicated method in this class. When line starts with PLACE string, it is parsed
     * with VALID_PLACE_PATTERN and if command is syntactically right, Raw Place Command is
     * returned.
     *
     * @param line line of input
     * @return {@link #INVALID_COMMAND} if command is syntactically incorrect
     * @return raw place command if command was syntactically correct
     */
    private RawCommand processPlaceCommand(String line) {
        Matcher m = VALID_PLACE_PATTERN.matcher(line);
        if (m.find()) {
            Integer x = new Integer(m.group(1));
            Integer y = new Integer(m.group(2));
            Direction direction = Direction.getByName(m.group(3));
            if(direction!=null){
                List<Object> args = new ArrayList<>();
                args.add(x);
                args.add(y);
                args.add(direction);
                return new RawCommand(CommandType.PLACE,args);
            }
        }
        return INVALID_COMMAND;
    }
}
