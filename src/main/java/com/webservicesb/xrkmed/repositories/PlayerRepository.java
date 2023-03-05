package com.webservicesb.xrkmed.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservicesb.xrkmed.entities.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
