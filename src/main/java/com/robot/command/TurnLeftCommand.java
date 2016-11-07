package com.robot.command;

import com.robot.Direction;
import com.robot.Robot;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Comand turns robot one direction to the left.
 */
public class TurnLeftCommand extends TurnCommand {

    /**
     * Map which specifies next direction after turn.
     */
    private static final Map<Direction,Direction> TURN_MAP;

    static {
        Map<Direction,Direction> turnMap = new HashMap<>();
        turnMap.put(Direction.NORTH,Direction.WEST);
        turnMap.put(Direction.WEST,Direction.SOUTH);
        turnMap.put(Direction.SOUTH,Direction.EAST);
        turnMap.put(Direction.EAST,Direction.NORTH);
        // we don't want clients to modify this object
        TURN_MAP = Collections.unmodifiableMap(turnMap);
    }

    /**
     * @see com.robot.command.TurnCommand#TurnCommand(com.robot.Robot)
     */
    public TurnLeftCommand(Robot robot) {
        super(robot);
    }

    @Override
    protected Map<Direction, Direction> nextDirectionMap() {
        return TURN_MAP;
    }
}
