package com.parser;

import com.robot.Coordinate;
import com.robot.Direction;
import com.robot.Robot;
import com.robot.Table;
import com.robot.command.*;
import com.robot.io.Output;
import com.scanner.Scanner;
import com.scanner.RawCommand;
import com.scanner.SimpleScanner;

import org.apache.commons.lang3.Validate;








import java.util.Collection;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;








import java.util.List;

/**
 * Simple implementation of commands parser.
 */

/*@RestController*/
public class SimpleParser implements Parser {

   
    private Scanner scanner;
        
    private Scanner scanner_rest;
    
    private Robot robot;
    
    private Output output;
    
    /**
     * Table on which is robot placed with first valid PLACE command.
     */
    private Table table;

    @Override
    public void setScanner(Scanner lexer) {
        this.scanner = lexer;
    }

    @Override
    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void setOutput(Output output) {
        this.output = output;
    }

    @Override
    public void setTable(Table table) {
        this.table = table;
    }

    /**
     * Method iterates through whole input and converts tokens (raw commands)
     * into actual commands which it also executes.
     */
    @Override
    public void run() {
        Validate.notNull(scanner);
        Validate.notNull(robot);
        Validate.notNull(output);
        Validate.notNull(table);
        try{
            RawCommand rawCommand;
            while((rawCommand = scanner.fetchCommand())!= null) {
                Command cmd = parseRawCommand(rawCommand);
                /* here we are excluding Invoker from command pattern,
                because there would be one class with one method with
                one line calling cmd.execute. It can be easily added in
                the feature*/
                cmd.execute();
            }
        }finally{
            // We always want to close underlying Streams.
            //lexer.closeInput();
            output.close();
        }

    }
    
    /**
     * Method takes bot command through Rest request input and converts token (raw command)
     * into actual command which it also executes.
     */
    
    @Override
    /*@RequestMapping(value = "/botCmd/{botCmd}", method = RequestMethod.GET)*/
    /*@PathVariable("botCmd")*/
    public String run( String botCmd) {
    	if(scanner_rest ==  null){
    		scanner_rest = new SimpleScanner();
    	}
        Validate.notNull(scanner_rest);
    	//Validate.notNull(scanner);
        Validate.notNull(robot);
        Validate.notNull(output);
        Validate.notNull(table);
        try{
        	if(scanner_rest.fetchCommand(botCmd)!= null){
        		RawCommand rawCommand = scanner_rest.fetchCommand(botCmd);
        		Command cmd = parseRawCommand(rawCommand);
                /* here we are excluding Invoker from command pattern,
                because there would be one class with one method with
                one line calling cmd.execute. It can be easily added in
                the feature*/
                cmd.execute();
        	}
        }catch(Exception e){
        	e.printStackTrace();
        	return "Failure";
        }finally{
            // We always want to close underlying Streams.
            //output.close();
        }
        System.out.println("Successfully Executed : " +botCmd);
        return "Success";

    }

    /**
     * This method converts raw command into actual command.
     *
     * @param rawCommand raw command
     * @return actual command which can be then executed
     */
    private Command parseRawCommand(RawCommand rawCommand) {
        switch (rawCommand.getCommandType()){
            case PLACE: return buildPlaceCommand(rawCommand.getArgs());
            case MOVE: return new MoveCommand(robot);
            case LEFT: return new TurnLeftCommand(robot);
            case RIGHT: return new TurnRightCommand(robot);
            case REPORT: return new ReportCommand(robot,output);
            case INVALID: return Command.VOID;
        }
        throw new IllegalArgumentException("Raw command without known type was passed.");
    }

    /**
     * Helper method for building place command from its arguments. It's only dirty method
     * because it uses force typing of objects. The only source of those arguments is Lexer.
     * And Lexer gives us arguments in required order and required type.
     *
     * @param args list of arguments for place command
     * @return place command which can be executed.
     */
    private Command buildPlaceCommand(List<Object> args) {
        Integer x = (Integer) args.get(0);
        Integer y = (Integer) args.get(1);
        Direction direction = (Direction) args.get(2);
        return new PlaceCommand(table,robot,new Coordinate(x,y),direction);
    }
}