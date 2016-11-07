package com.robot;

/**
 * Generic table on which robot can be placed.
 */
public interface Table {

    /**
     * Validates, if given coordinate can be on the table.
     *
     * @param coordinate validated coordinate
     * @return true if coordinate is on the table.
     * @return false if coordinate is outside of the table
     */
    boolean isOnTable(Coordinate coordinate);
}
