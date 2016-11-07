package com.robot;

import org.apache.commons.cli.*;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.util.Properties;

/**
 * Main class which is responsible for receiving CLI parameters and building Spring context.
 */
public class Main {

    /**
     * Only CLI option for this app.
     */
    private static final Option SOURCE_FILE = new Option("f",true,"Name of the Input file commands");

    /**
     * Name of app configuration file using FileInput.
     */
    private static final String FILE_CONTEXT_NAME = "file-context.xml";

    /**
     * Name of app configuration file using StandardInput.
     */
    private static final String STDIN_CONTEXT_NAME = "stdin-context.xml";

    /**
     * Main method parses CLI arguments and creates spring context with robot app.
     *
     * @param args command line arguments
     */
    public static void main(String[] args){
       if(!isValidArguments(args)){
            return;
        }
        String fileName = getFileName(args);
        
        //if user gave file option
        if(fileName != null){
            runWithFile(fileName);
        }else{
            ApplicationContext context = new ClassPathXmlApplicationContext(STDIN_CONTEXT_NAME);
        }
    }

    /**
     * Validates, that user's command line input makes sense.
     *
     * @param args user's command line input
     * @return is user input valid?
     */
    private static boolean isValidArguments(String[] args){
        CommandLine cmd = null;
        // parsing command line arguments
        try{
        	if(args.length != 0 && !args[0].toString().contains("file")){
        		cmd = createCommandLine(args);
        	} 
        }catch(ParseException e){
            System.err.println("Error during parsing command line arguments:");
            System.err.println(e.getMessage());
            return false;
        }
        if(cmd != null && cmd.getArgs().length > 0){
            for(String arg:cmd.getArgs()){
                System.err.println("Argument '" + arg + "' was not recognized");
            }
            return false;
        }
        return true;
    }

    /**
     * Returns name of file if user inserted any.
     *
     * @param args user's command line input
     * @return null if user didn't insert file name
     * @return name of file which will be used as input
     */
    private static String getFileName(String[] args){
    	
    	String inputFile = null;
        try{
        	
        	if(args.length != 0 && args[0].toString().contains("file")){
        		inputFile = args[0].toString();
        		String[] parts = inputFile.split("-");
        		inputFile = parts[1];
        	} 
             
        }catch(Exception e){
            //already validated, can't happen
            System.err.println(e.getMessage());
        }
        return inputFile;
    }

    /**
     * Creates application context with FileReader if given file exists.
     *
     * @param filename name of source file.
     */
    private static void runWithFile(String filename){
        File sourceFile = new File(filename);
        if(!sourceFile.exists()) {
            System.err.println("Given file doesn't exist.");
            return;
        }
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        Properties properties = new Properties();
        properties.setProperty("fileName", filename);
        configurer.setProperties(properties);

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.addBeanFactoryPostProcessor(configurer);

        context.setConfigLocation(FILE_CONTEXT_NAME);
        context.refresh();
    }

    /**
     * Creates apache command line object and parses user's command line input
     * @param args user's command line input
     * @return CommandLine object
     * @throws ParseException if user inserted bad options
     */
    private static CommandLine createCommandLine(String[] args) throws  ParseException{
        Options options = new Options();
        options.addOption(SOURCE_FILE);
        CommandLineParser parser = new PosixParser();
        CommandLine cmd = parser.parse(options,args);
        return cmd;
    }
}
