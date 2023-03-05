package com.webservicesb.xrkmed.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservicesb.xrkmed.entities.Player;
import com.webservicesb.xrkmed.repositories.PlayerRepository;

@Service
public class PlayerServices {

	@Autowired
	private PlayerRepository repository;
	
	private ArrayList<Player> playersDatabase = new ArrayList<>();
	
	public Player findPlayer(String findParam){
		if(playersDatabase.size() == 0) { //only for debug
			playersDatabase.add(new Player(playersDatabase.size()+1, "Christian", "christian@gmail.com", "123456", false));
			playersDatabase.add(new Player(playersDatabase.size()+1, "Xrkmed", "xrkmed@gmail.com", "123456", false));
			playersDatabase.add(new Player(playersDatabase.size()+1, "Teste", "teste@gmail.com", "123456", false));
			playersDatabase.add(new Player(playersDatabase.size()+1, "Rafael", "rafael@gmail.com", "123456", false));
		}
		
		try {
			List<Player> filteredList = playersDatabase.stream().filter(x -> x.getName().toLowerCase().contains(findParam.toLowerCase())).collect(Collectors.toList());
			return filteredList.get(0);
		}catch(Exception e) {
			return null;
		}
	}
	
	public List<Player> findPlayers(String findParam){
		if(playersDatabase.size() == 0) { //only for debug
			playersDatabase.add(new Player(playersDatabase.size()+1, "Christian", "christian@gmail.com", "123456", false));
			playersDatabase.add(new Player(playersDatabase.size()+1, "Xrkmed", "xrkmed@gmail.com", "123456", false));
			playersDatabase.add(new Player(playersDatabase.size()+1, "Teste", "teste@gmail.com", "123456", false));
			playersDatabase.add(new Player(playersDatabase.size()+1, "Rafael", "rafael@gmail.com", "123456", false));
		}
		
		try {
			List<Player> filteredList = playersDatabase.stream().filter(x -> x.getName().toLowerCase().contains(findParam.toLowerCase())).collect(Collectors.toList());
			return filteredList;
		}catch(Exception e) {
			return null;
		}
	}
	
	public Player findById(long Id) {
		try {
			System.out.println(Id);
			Player idPlayer = playersDatabase.stream().filter(p -> p.getId() == Id).limit(1).collect(Collectors.toList()).get(0);
			return idPlayer;
		}catch(Exception e) {
			return null;
		}
	}
}
