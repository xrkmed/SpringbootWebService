package com.webservicesb.xrkmed.resources;

import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.webservicesb.xrkmed.defaultMethods.returnPage;
import com.webservicesb.xrkmed.entities.Player;
import com.webservicesb.xrkmed.services.PlayerServices;

@RestController
@RequestMapping(value = "/players")
public class PlayerResources {
	
	@Autowired
	private PlayerServices service;
	
	//DEFAULT PAGE
	@GetMapping
	public ResponseEntity<returnPage> defaultPage(){
		returnPage body = new returnPage(404);
		body.insertBody("error", "Insira um argumento!");
		body.insertBody("help", "Argumentos disponiveis: /find/name & /all & /register");
		return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(body);
	}
	
	@GetMapping(value = "/find/{name}")
	public <T> ResponseEntity<Player> findPlayer(@PathVariable("name") T param){
		try {
			if(Integer.parseInt(param.toString()) > 0) {
				Player _p = service.findById(Integer.parseInt(param.toString()));
				return ResponseEntity.ok().body(_p);
			}
		}catch(NumberFormatException e) {
			Player _p = service.findPlayer(param.toString());
			return ResponseEntity.ok().body(_p);
		}
		
		return null;
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<Player>> findPlayers(){
		List<Player> _p = service.findPlayers("");
		return ResponseEntity.ok().body(_p);
	}
	
	@GetMapping(value = "/register")
	public ResponseEntity<Player> findAll(String findParam){
		Player _p = service.findPlayer(findParam);
		return ResponseEntity.ok().body(_p);
	}
}
