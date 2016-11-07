package com.robot;

/**
 * Cardinal direction.
 */
public enum Direction {
    NORTH   (0,1,  "NORTH"),
    EAST    (1,0,  "EAST"),
    SOUTH   (0,-1, "SOUTH"),
    WEST    (-1,0, "WEST");

    /**
     * Single coordinate for showing direction on grid.
     */
    private final Coordinate stepAddition;

    /**
     * Human readable name of the direction
     */
    private final String name;

    /**
     * Constructor takes integer step showing direction on grid and creates enum.
     * @param x addition of X coordinate for this direction
     * @param y addition of Y coordinate for this direction
     */
    Direction(int x, int y, String name) {
        this.stepAddition = new Coordinate(x,y);
        this.name = name;
    }

    /**
     * Returns coordinate representing direction on the grid.
     * You can use this coordinate to move on XY grid.
     *
     * @return coordinate representing one step in direction
     */
    public Coordinate getStepAddition() {
        return stepAddition;
    }

    /**
     * Human readable name of the direction
     *
     * @return Human readable name of the direction
     */
    public String getName() {
        return name;
    }

    /**
     * It returns direction from string value.
     * @param directionName string direction NOT NULL
     * @return null if direction doesn't exist for a string
     * @return direction representation of string
     */
    public static Direction getByName(String directionName){
        for(Direction direction : Direction.values()){
            if(direction.getName().equals(directionName)){
                return direction;
            }
        }
        return null;
    }
}
