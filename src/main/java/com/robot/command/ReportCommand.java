package com.robot.command;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.robot.Coordinate;
import com.robot.Direction;
import com.robot.Robot;
import com.robot.io.Output;

/**
 * Command which reports robots position and direction on table.
 */
/*@RestController*/
public class ReportCommand implements Command {

    /**
     * Robot who is "receiving" this command
     */
    private Robot robot;

    /**
     * Output on which report will be written
     */
    private Output output;

    /**
     * Command is built with robot and output variables. It will be executed on robot and
     * result will be written on output.
     *
     * @param robot robot on which command is executed
     * @param output output to which result of this command will be written.
     */
    public ReportCommand(Robot robot, Output output) {
        this.robot = robot;
        this.output = output;
    }

    @Override
    /*@RequestMapping(value = "/botCmd/Report", method = RequestMethod.GET)*/
    public void execute() {
        if(isValid()){
            Coordinate coordinate = robot.getCoordinate();
            Direction direction = robot.getDirection();
            StringBuilder line = new StringBuilder();
            line.append(coordinate.getX()).append(",")
                .append(coordinate.getY()).append(",")
                .append(direction.getName());
            System.out.println("Reporting Bot Co-ordinates" +line.toString());
            output.writeLine("Report Output : " +line.toString());
        }
    }

    /**
     * Command is valid if robot has been already placed on the table.
     *
     * @return is possible to execute command?
     */
    @Override
    public boolean isValid() {
        return robot.getTable() != null;
    }
}
