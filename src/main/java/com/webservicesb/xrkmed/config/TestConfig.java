package com.webservicesb.xrkmed.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.webservicesb.xrkmed.repositories.PlayerRepository;

@Configuration
@Profile(value = "test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private PlayerRepository playerRep;

	@Override
	public void run(String... args) throws Exception {
		//auto code
	}
	
	
	
}
