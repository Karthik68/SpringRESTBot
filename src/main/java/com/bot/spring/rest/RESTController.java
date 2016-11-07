package com.bot.spring.rest;

import java.util.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parser.SimpleParser;
import com.robot.Robot;
import com.robot.SimpleRobot;
import com.robot.command.ReportCommand;
import com.robot.io.Output;
import com.robot.io.StandardOutput;

@RestController
public class RESTController {
	
	
	private ApplicationContext springContext;
	
	private Robot robot;

    private Output output;
	  
    @RequestMapping(value = "/botCmd/{botCmd}", method = RequestMethod.GET)
    public String runCmd(@PathVariable("botCmd") String botCmd) {
    	if(springContext == null){
    		System.out.println("*****************************Initialising Spring Context runCmd*****************************");
    		try{
    		springContext = new ClassPathXmlApplicationContext("main-rest-context.xml");
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    		//springContext = new ClassPathXmlApplicationContext("main-context.xml");
    		//springContext = new ClassPathXmlApplicationContext("stdin-context.xml");    		
    	}
    	((SimpleParser)springContext.getBean("parser")).run(botCmd);
    	return "executed " +botCmd;
    }

    @RequestMapping(value = "/botCmd/Report", method = RequestMethod.GET)
    public String runReport() {
    	if(springContext == null){
    		System.out.println("*****************************Initialising Spring Context runReport*****************************");
    		try{
    		springContext = new ClassPathXmlApplicationContext("main-rest-context.xml");
    		}catch(Exception e){
			e.printStackTrace();
		}
    		//springContext = new ClassPathXmlApplicationContext("main-context.xml");
    		//springContext = new ClassPathXmlApplicationContext("stdin-context.xml");
    	}
    	robot = ((SimpleRobot)springContext.getBean("robot"));
    	output = ((StandardOutput)springContext.getBean("output"));
    	ReportCommand cmd = new ReportCommand(robot,output);
    	cmd.execute();
    	return "executed report";
    }
}
