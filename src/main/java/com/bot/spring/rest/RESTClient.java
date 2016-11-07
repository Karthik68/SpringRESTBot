package com.bot.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component("restClient")
public class RESTClient {
    @Autowired
    private RestTemplate restTemplate;

    public String getAllEmployees() {
        return restTemplate.getForObject("http://localhost:8080/employees", String.class);
    }
    
    public String botCommand(String cmd) {
    	System.out.println("******** REST botCmd from Client ********");
        return restTemplate.getForObject("http://localhost:8080/botCmd/"+cmd, String.class);
    }
    
    public String botReport(String cmd) {
    	System.out.println("******** REST Report Cmd from Client ********");
        return restTemplate.getForObject("http://localhost:8080/botCmd/"+cmd, String.class);
    }
}
