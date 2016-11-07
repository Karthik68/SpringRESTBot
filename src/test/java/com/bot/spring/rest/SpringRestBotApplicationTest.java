package com.bot.spring.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bot.spring.rest.SpringRestBotApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringRestBotApplication.class)
@WebAppConfiguration
public class SpringRestBotApplicationTest {

	@Test
	public void contextLoads() {
	}

}
