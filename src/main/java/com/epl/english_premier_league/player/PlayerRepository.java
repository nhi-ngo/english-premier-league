package com.epl.english_premier_league.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    List<Player> findByNameContainingIgnoreCase(String name);

    List<Player> findByTeamIgnoreCase(String team);

    List<Player> findByPosIgnoreCase(String pos);

    List<Player> findByNationIgnoreCase(String nation);

    List<Player> findByTeamAndPos(String team, String pos);

    boolean existsByNameIgnoreCaseAndTeamIgnoreCase(String name, String team);
}
